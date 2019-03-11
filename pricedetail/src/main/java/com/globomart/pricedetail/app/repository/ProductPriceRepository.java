package com.globomart.pricedetail.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.globomart.pricedetail.app.model.Product;

public interface ProductPriceRepository extends CrudRepository<Product, Integer> {

}
