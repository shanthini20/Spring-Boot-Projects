package com.kgis.springboot.product.service;

import java.util.List;

import com.kgis.springboot.product.entity.ProductDetails;

public interface ProductService {
	String createProductDetail(ProductDetails ProductDetails);

	List<ProductDetails> getProductDetailList();

	String updateProductDetail(int id, ProductDetails ProductDetails);

	String deleteProductDetail(int id);

	ProductDetails retrieveProductDetailByName(String name);

	List<ProductDetails> retrieveProductByCompanyName(String company);
}
