package com.example.SpringBootBasics.controller;


import com.example.SpringBootBasics.model.Product;
import com.example.SpringBootBasics.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    //Get Products
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getAllProducts();
    }

    //Get Product
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable int id){
        return service.getProduct(id);
    }

    //Creating Product
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        service.createProduct(product);
        return service.getProduct(product.getId());
    }

    //Updating Product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody  Product product){
        service.updateProduct(id,product);
        return service.getProduct(id);
    }

    //Delete Product
    @DeleteMapping("/products/{id}")
    public List<Product> deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return service.getAllProducts();
    }
}
