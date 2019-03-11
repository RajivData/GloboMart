package com.globomart.productcat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.productcat.app.model.Product;
import com.globomart.productcat.app.model.ProductType;
import com.globomart.productcat.app.service.ProductCatalogService;

@RestController
@RequestMapping("/product-catalog")
public class ProductCatalogController {
	
	@Autowired
	private ProductCatalogService catalogService;
	
	@PostMapping(value="/product",consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		
		catalogService.addProduct(product);
		return new ResponseEntity<String>("Product Created",HttpStatus.CREATED);
	}

	@GetMapping(value="/product/{productid}",produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Product> getProductById(@PathVariable Integer productid) {
		
		Product product=catalogService.getProductById(productid);
		if(product==null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(product);
	}
	
	@GetMapping(value="/product")
	public ResponseEntity<List<Product>> getProductByType(@RequestParam("product_type") ProductType productType){
		List<Product> products=catalogService.getProductByType(productType);
		return ResponseEntity.ok(products);
	}
}
