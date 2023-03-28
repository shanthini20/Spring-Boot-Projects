package com.kgis.springboot.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kgis.springboot.product.entity.ProductDetails;
import com.kgis.springboot.product.service.ProductService;

@RestController
@RequestMapping("/product")

public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/create")
	String createProductDetail(@RequestBody ProductDetails ProductDetails) {
		return productService.createProductDetail(ProductDetails);
	}

	@GetMapping("/get")
	List<ProductDetails> getProductDetailList() {
		return productService.getProductDetailList();
	}

	@PutMapping("/update/{id}")
	String updateProductDetail(@PathVariable(name = "id") int id, @RequestBody ProductDetails ProductDetails) {
		return productService.updateProductDetail(id, ProductDetails);
	}

	@DeleteMapping("/delete/{id}")
	String deleteProductDetail(@PathVariable(name = "id") int id) {
		return productService.deleteProductDetail(id);
	}

	@GetMapping("/retrieve/{name}")
	ProductDetails retrieveProductDetailByName(@PathVariable(name = "name") String name) {
		return productService.retrieveProductDetailByName(name);
	}

	@GetMapping("/retrieve-contains")
	List<ProductDetails> retrieveProductByCompanyName(@RequestParam(name = "company") String company) {
		return productService.retrieveProductByCompanyName(company);

	}

}
