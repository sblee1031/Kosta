package com.example.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.jpa.entity.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}
