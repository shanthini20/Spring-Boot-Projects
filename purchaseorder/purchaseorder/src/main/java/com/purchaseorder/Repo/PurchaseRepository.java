package com.purchaseorder.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.purchaseorder.Entity.PurchaseDetails;
import com.purchaseorder.Entity.PurchaseDetails.PurchaseDetailsBuilder;

public interface PurchaseRepository extends JpaRepository<PurchaseDetails, Long>{

	PurchaseDetailsBuilder save(PurchaseDetailsBuilder builder);



	
	

}
