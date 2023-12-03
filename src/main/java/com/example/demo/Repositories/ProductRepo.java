package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Classes.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{

}
