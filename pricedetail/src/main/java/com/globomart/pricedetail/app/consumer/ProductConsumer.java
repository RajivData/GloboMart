package com.globomart.pricedetail.app.consumer;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.globomart.pricedetail.app.model.Product;



@Component
public class ProductConsumer {
//	Logger logger = LoggerFactory.getLogger(ProductConsumer.class);

	/*@Value("${book.consumer.endpoint}")
	private String productConsumerEndpoint;*/

	public Product getProductById(int productId) {
		final String url = "http://localhost:8080/product-catalog/product/{productid}";
		Product product = null;
		try {
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			HttpEntity<String> httpEntity = new HttpEntity<String>("parameter", httpHeaders);
			ResponseEntity<Product> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
					Product.class, productId);
			product = responseEntity.getBody();

		} catch (Exception exp) {
			return null;
		}
		return product;
	}
}
