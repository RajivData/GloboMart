package com.globomart.pricedetail.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.pricedetail.app.model.Product;
import com.globomart.pricedetail.app.service.PriceDetailsService;

@RestController
@RequestMapping("/price-details")
public class PriceDetailsController {

	@Autowired
	private PriceDetailsService detailsService;

	@PostMapping(value = "/price", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addPrice(@RequestBody Product productPrice) {

		Product product = detailsService.fetchBookById(productPrice.getProductId());
		if (product != null) {
			detailsService.addPrice(productPrice);
			return new ResponseEntity<String>("Price is updated", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Price is not updated -Id Not found", HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/price/{productid}")
	public ResponseEntity<?> getPriceByProductId(@PathVariable Integer productid) {
		Product price = detailsService.getPriceByProductId(productid);
		if (price == null) {
			return new ResponseEntity<String>(" Product Id is not found", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(price);
	}
}
