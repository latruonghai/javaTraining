package net.javatraining.controller;

import net.javatraining.model.Product;
import net.javatraining.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> products = productService.listAll();
        model.addAttribute("listProducts", products);
        return "index";
    }

    @RequestMapping("/addProduct")
    public String showNewProductForm(Model model){
        Product product = new Product();

        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/save")
    public String addProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editProductForm(@PathVariable(name="id") Long id){
//        Product product = new Product();
        ModelAndView mav = new ModelAndView("edit_product");
//        model.addAttribute("product", product);
        Product product = productService.getProduct(id);

        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/product/{id}")
    public ModelAndView getProductForm(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("get_product");

        Product product = productService.getProduct(id);
        mav.addObject("product", product);

        return mav;
    }
    @RequestMapping("/del/{id}")
    public String delProduct(@PathVariable(name="id") Long id){
        productService.deleteProduct(id);

        return "redirect:/";
    }

}
