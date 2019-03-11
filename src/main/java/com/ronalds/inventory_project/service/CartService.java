package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.controller.constants.ControllerConstants;
import com.ronalds.inventory_project.entity.Client;
import com.ronalds.inventory_project.entity.OrderDetails;
import com.ronalds.inventory_project.entity.Product;
import com.ronalds.inventory_project.service.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private ProductService productService;
    @Autowired
    private HttpSession session;

    // Add Products to Shopping Cart
    public synchronized void addProduct(Cart cart, Integer productId) {
        if (cart.contains(productId)) {
            cart.incrementProductQuantity(productId);
        } else {
            OrderDetails orderDetails = cart.getProduct(productId);
            Product product = productService.findProductById(productId);
            if (orderDetails == null) {
                orderDetails = new OrderDetails();
                orderDetails.setProduct(product);
                orderDetails.setQuantity(0);
                cart.addToCart(productId, orderDetails);
                orderDetails.incrementQuantity();
            }
        }
    }

    public synchronized void updateProduct(Cart cart, Integer productId,
                                           int quantity) {
        OrderDetails orderDetails = cart.getProduct(productId);
        orderDetails.setQuantity(quantity);
    }

    public synchronized int getProductsCount(Cart cart) {
        return cart.getCartSize();
    }

    public synchronized boolean containsProduct(Cart cart,
                                                Integer productId) {
        return cart.containsKey(productId);
    }

    public synchronized void incrementProductQuantity(Cart cart,
                                                      Integer productId) {
        OrderDetails orderDetails = cart.getProduct(productId);
        orderDetails.incrementQuantity();
    }

    public synchronized void decrementProductQuantity(Cart cart,
                                                      Integer productId) {
        cart.decrementProductQuantity(productId);
    }

    public synchronized int getNumberOfItems(Cart cart) {
        return cart.getNumberOfItems();
    }

    public synchronized void removeProduct(Cart cart, Integer productId) {
        cart.removeProduct(productId);
    }

    public synchronized void clearCart(Cart cart) {
        cart.clearCart();
    }

    public synchronized List<OrderDetails> getOrderItemsList(Cart cart) {
        return cart.getOrderItemsList();
    }

    public synchronized double getTotal(Cart cart) {
        return cart.getTotal();
    }

    public synchronized boolean isCartEmpty(Cart cart) {
        return cart.isCartEmpty();
    }

    public Cart getShoppingCart() {
        Cart cartData = (Cart) session
                .getAttribute(ControllerConstants.CART);
        if (cartData != null)
            return cartData;
        else
            return new Cart();
    }

    public Cart getShoppingCartByCustomer(Client client) {
        return null;
    }

    public void saveShoppingCartDetails(Cart customerCartData,
                                        Client client) {
        

    }

    public void saveCartInDatabase(Cart cart, Client client) {

    }

}
