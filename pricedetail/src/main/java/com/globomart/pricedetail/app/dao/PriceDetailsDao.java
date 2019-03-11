package com.globomart.pricedetail.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globomart.pricedetail.app.model.Product;
import com.globomart.pricedetail.app.repository.ProductPriceRepository;

@Repository
public class PriceDetailsDao {

	@Autowired
	private ProductPriceRepository priceRepository;

	public void addPrice(Product productPrice) {
		priceRepository.save(productPrice);
	}

	public Iterable<Product> getPriceByProductId(Integer productid) {
		return priceRepository.findAll();
	}
}
