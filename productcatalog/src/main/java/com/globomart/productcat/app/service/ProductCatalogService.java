package com.globomart.productcat.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.productcat.app.dao.ProductCatalogDao;
import com.globomart.productcat.app.model.Product;
import com.globomart.productcat.app.model.ProductType;

@Service
public class ProductCatalogService {

	@Autowired
	private ProductCatalogDao catalogDao;

	public void addProduct(Product product) {
		catalogDao.addProduct(product);
	}

	public Product getProductById(Integer productid) {
		return catalogDao.getProductById(productid);
	}

	public List<Product> getProductByType(ProductType productType) {
		List<Product> products = new ArrayList<>();
		Iterator<Product> productItr = catalogDao.getAllProduct().iterator();
		while (productItr.hasNext()) {
			Product product = productItr.next();
			if (product.getProductType() == productType) {
				products.add(product);
			}
		}
		return products;
	}

	public void productDelete(Integer productId) {
		catalogDao.productDelete(productId);
	}
}
