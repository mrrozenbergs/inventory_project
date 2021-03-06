package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.controller.constants.ControllerConstants;
import com.ronalds.inventory_project.dao.OrderRepository;
import com.ronalds.inventory_project.entity.Order;
import com.ronalds.inventory_project.entity.OrderDetails;
import com.ronalds.inventory_project.entity.User;
import com.ronalds.inventory_project.error.NotEnoughProductsInStockException;
import com.ronalds.inventory_project.service.model.Cart;
import com.ronalds.inventory_project.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;
    private UserService userService;
    private ProductService productService;

    @Autowired
    private HttpSession session;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAllByOrderById();
    }

    @Override
    public Order findOrderById(int Id) {
        //return orderRepository.findById(Id).orElseThrow(()-> new RuntimeException("Did not find Product id - " + Id));
        Optional<Order> result = orderRepository.findById(Id);

        Order order = null;

        if (result.isPresent()) {
            order = result.get();
        } else {
            throw new RuntimeException("Did not find Product id - " + Id);
        }

        return order;
    }

    @Override
    public Order saveOrder(CartService cartService, HttpServletRequest request, Principal principal) throws NotEnoughProductsInStockException {
        Order order = new Order();
        order.setDate(new Date());
        Cart cart = SessionUtils.getSessionVariables(request,
                ControllerConstants.CART);
        order.setTotalPrice(cartService.getTotal(cart));
        User user = userService.findByUsername(principal.getName()).get();
        order.setClient(user.getClient());
        List<OrderDetails> orderItemsList = new ArrayList<>();
        for (OrderDetails orderItem : cartService.getOrderItemsList(cart)) {
            if (orderItem.getQuantity() > productService.findProductById(orderItem.getProduct().getId()).getInStock()){
                throw new NotEnoughProductsInStockException(productService.findProductById(orderItem.getProduct().getId()));
            } else if (orderItem.getQuantity() < 0){
                throw new NotEnoughProductsInStockException(productService.findProductById(orderItem.getProduct().getId()));
            }
            orderItemsList.add(orderItem);
        }
        order.setOrderEntries(orderItemsList);
        return orderRepository.save(order);
    }

    @Override
    public void removeOrder(int Id) {
        orderRepository.deleteById(Id);
    }

}
