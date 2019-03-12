package com.ronalds.inventory_project.controller;

import com.ronalds.inventory_project.controller.constants.ControllerConstants;
import com.ronalds.inventory_project.entity.OrderDetails;
import com.ronalds.inventory_project.service.CartService;
import com.ronalds.inventory_project.service.model.Cart;
import com.ronalds.inventory_project.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping("/add_to_cart")
    public String addProducts(Model model,
                              @RequestParam(value = "productId") Integer productId,
                              HttpServletRequest request) {
        Cart customerCartData = null;
        customerCartData = SessionUtils.getSessionVariables(request,
                ControllerConstants.CART);
        if (customerCartData == null) {
            customerCartData = cartService.getShoppingCart();
            SessionUtils.setSessionVariables(customerCartData, request,
                    ControllerConstants.CART);
            cartService.addProduct(customerCartData, productId);
        } else {
            cartService.addProduct(customerCartData, productId);
        }
        return "redirect:/orders/add_order";
    }

    @GetMapping("/info")
    public String getCartData(Model model, HttpServletRequest request){

        List<OrderDetails> list = cartService.getOrderItemsList(cartService.getShoppingCart());
        double total = cartService.getTotal(cartService.getShoppingCart());

        model.addAttribute("total", total);
        model.addAttribute("orderitems", list);
        return "/cart/cart";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("productId") int Id) {

        cartService.removeProduct(cartService.getShoppingCart(), Id);

        return "redirect:/cart/info";
    }

    @PostMapping("/update")
    public String update(@RequestParam("productId") int Id, @RequestParam("quantity") int quantity) {

        cartService.updateProduct(cartService.getShoppingCart(), Id, quantity);

        return "redirect:/cart/info";
    }

}
