package com.kgis.springboot.product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kgis.springboot.product.entity.ProductDetails;
@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

	Optional<ProductDetails> findByName(String name);

	List<ProductDetails> findByCompanyContains(String company);
	
	@Query(value = "select * from product_details where company  like %?1%",nativeQuery = true)
	List<ProductDetails> getByCompanyContains(String company);
	

}