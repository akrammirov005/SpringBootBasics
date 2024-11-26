package com.example.SpringBootBasics.service;

import com.example.SpringBootBasics.model.Product;
import com.example.SpringBootBasics.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    //Object of ProductRepository
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product getProduct(int id){
        return repository.findById(id).get();
    }

    public void createProduct(Product product){
        repository.save(product);
    }

    public void updateProduct(int id,Product product){
        Product productUpdate = repository.findById(id).orElseThrow();
        productUpdate.setName(product.getName());
        productUpdate.setCategory(product.getCategory());
        productUpdate.setDate(product.getDate());
        repository.save(productUpdate);
    }

    public void deleteProduct(int id){
        repository.deleteById(id);
    }

}
