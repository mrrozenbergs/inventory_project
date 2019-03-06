package com.ronalds.inventory_project.controller;


import com.ronalds.inventory_project.entity.Order;
import com.ronalds.inventory_project.entity.OrderDetails;
import com.ronalds.inventory_project.entity.Product;
import com.ronalds.inventory_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String listClients(Model model) {

        List<Product> products = productService.findAll();

        model.addAttribute("product", products);

        return "/products/list-products";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Product product = new Product();

        model.addAttribute("product", product);

        return "/products/product-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int Id,
                                    Model model) {

        Product product = productService.findProductById(Id);

        model.addAttribute("product", product);

        return "/products/product-form";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("product") Product product) {

        productService.saveProduct(product);

        return "redirect:/products/list";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("productId") int Id) {

        productService.removeProduct(Id);

        return "redirect:/products/list";
    }



}
