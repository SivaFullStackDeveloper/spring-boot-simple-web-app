package com.siva.SimpleWebApp.controller;

import com.siva.SimpleWebApp.model.Product;
import com.siva.SimpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{myId}")
    public Optional<Product> getProductById(@PathVariable String myId) {
        return productService.getProductById(Integer.parseInt(myId));
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product);
        productService.addProduct(product);
    }

    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product) {
        System.out.println(product);
        productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{myId}")
    public void updateProduct(@PathVariable int myId) {

        productService.deleteProduct(myId);
    }
}
