package com.example.SpringBootBasics.repository;

import com.example.SpringBootBasics.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
