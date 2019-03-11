package com.globomart.productcat.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globomart.productcat.app.model.Product;
import com.globomart.productcat.app.repository.ProductRepository;

@Repository
public class ProductCatalogDao {

	@Autowired
	private ProductRepository productRepository;

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public Product getProductById(Integer productid) {
		return productRepository.findById(productid).get();
	}

	public Iterable<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public void productDelete(Integer productId) {
		productRepository.delete(productRepository.findById(productId).get());
	}
}
