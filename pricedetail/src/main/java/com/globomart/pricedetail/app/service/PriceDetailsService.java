package com.globomart.pricedetail.app.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.pricedetail.app.consumer.ProductConsumer;
import com.globomart.pricedetail.app.dao.PriceDetailsDao;
import com.globomart.pricedetail.app.model.Product;

@Service
public class PriceDetailsService {

	@Autowired
	private PriceDetailsDao priceDetailsDao;

	@Autowired
	private ProductConsumer productConsumer;

	public void addPrice(Product productPrice) {
		priceDetailsDao.addPrice(productPrice);
	}

	public Product getPriceByProductId(Integer productid) {
		Iterator<Product> prdPriceItr = priceDetailsDao.getPriceByProductId(productid).iterator();
		while (prdPriceItr.hasNext()) {
			Product price = prdPriceItr.next();
			if (price.getProductId() == productid) {
				Double totalPrice = price.getPrice() + price.getTax();
				price.setTotalPrice(totalPrice);
				return price;
			}
		}
		return null;
	}

	public Product fetchBookById(int productId) {
		return productConsumer.getProductById(productId);
	}
}
