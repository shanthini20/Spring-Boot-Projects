package com.kgis.springboot.product.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgis.springboot.product.dao.ProductDetailsRepository;
import com.kgis.springboot.product.entity.ProductDetails;
import com.kgis.springboot.product.service.ProductService;

@Service
public class ProductImpl implements ProductService {

	@Autowired
	ProductDetailsRepository productDetailsRepository;

	@Override
	public String createProductDetail(ProductDetails productDetails) {
		if (productDetails != null) {
			productDetailsRepository.save(productDetails);
			return "Product data added Successfully";
		}

		return "Product data is null";
	}

	@Override
	public List<ProductDetails> getProductDetailList() {
		List<ProductDetails> ProductDetailList = productDetailsRepository.findAll();
		List<String> nameList = new ArrayList<>();

		for (ProductDetails productDetails : ProductDetailList) {
			nameList.add(productDetails.getName());
		}
		System.out.println(nameList);
		return ProductDetailList;
	}

	@Override
	public String updateProductDetail(int id, ProductDetails productDetails) {

		Optional<ProductDetails> optProduct = productDetailsRepository.findById(id);
		if (optProduct.isPresent()) {
			ProductDetails product = optProduct.get();
			product.setName(productDetails.getName());
			product.setCompany(productDetails.getCompany());
			product.setDescription(productDetails.getDescription());
			product.setPrice(productDetails.getPrice());
			productDetailsRepository.save(product);
			return "Updated Successfully";
		}
		return "Product detail id not found";
	}

	@Override
	public String deleteProductDetail(int id) {
		Optional<ProductDetails> optProduct = productDetailsRepository.findById(id);
		if (optProduct.isPresent()) {
			productDetailsRepository.deleteById(id);
			return "Product Detail Deleted Successfullly";
		}
		return "Product detail id not found";
	}

	@Override
	public ProductDetails retrieveProductDetailByName(String name) {
		Optional<ProductDetails> optProduct = productDetailsRepository.findByName(name);
		if (optProduct.isPresent()) {
			return optProduct.get();
		}
		return null;
	}

	@Override
	public List<ProductDetails> retrieveProductByCompanyName(String company) {
		//String param = "%" + company + "%";

		return productDetailsRepository.getByCompanyContains(company);
	}
}
