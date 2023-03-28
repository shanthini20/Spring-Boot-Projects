package com.ExcelProject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.persistence.spi.PersistenceProvider;
@Repository
public interface ExcelProjectDetailsRepository extends JpaRepository<ExcelProjectDetails, Long>{

	
	
	@Query(value = "select * from excel_details where vendor_name  like %?1%",nativeQuery = true)
	List<ExcelProjectDetails> getByVendorNameContains(String vendor_name);

	

}
