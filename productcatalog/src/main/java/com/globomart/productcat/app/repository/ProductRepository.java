package com.globomart.productcat.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.globomart.productcat.app.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
