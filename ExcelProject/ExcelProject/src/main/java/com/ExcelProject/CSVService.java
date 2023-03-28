package com.ExcelProject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import jakarta.persistence.spi.PersistenceProvider;
@Service
public class CSVService {

	
	 @Autowired
	  ExcelProjectDetailsRepository repository;

	  public void save(MultipartFile file) {
	    try {
	      List<ExcelProjectDetails> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
	      repository.saveAll(tutorials);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

	  public ByteArrayInputStream load() {
	    List<ExcelProjectDetails> tutorials = repository.findAll();

	    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
	    return in;
	  }

	  public List<ExcelProjectDetails> getAllTutorials() {
	    return repository.findAll();
	  }

	public List<ExcelProjectDetails> getSingleTutorials(long vendor_id) {
		// TODO Auto-generated method stub
		Optional<ExcelProjectDetails> newdata= repository.findById(vendor_id);
		if (newdata.isPresent())
		{
			newdata.get();
			List<ExcelProjectDetails> newlist=new ArrayList<>();
			newlist.add(newdata.get());
			return newlist;
	}
		return null;

	
}

	public String edit(String priority, String reason,long vendor_id, String vendor_name, String cluster, String country,
			String document_no, String company_code, String type, double total_amnt, String currency, String po_no,
			String scan_date,String existing_status,String existing_comments) {
		
		Optional<ExcelProjectDetails> getdata = repository.findById(vendor_id);
		if (getdata.isPresent()) {
			ExcelProjectDetails newentry = getdata.get();
			newentry.setPriority(priority);
			newentry.setReason(reason);
			newentry.setVendor_name(vendor_name);
			newentry.setCluster(cluster);
			newentry.setCountry(country);
			newentry.setDocument_no(document_no);
			newentry.setCompany_code(company_code);
			newentry.setType(type);
			newentry.setTotal_amnt(total_amnt);
			newentry.setCurrency(currency);
			newentry.setPo_no(po_no);
			newentry.setScan_date(scan_date);
			newentry.setExisting_status(existing_status);
			newentry.setExisting_comments(existing_comments);
			repository.save(newentry);
		}
		return "updated";
	}

	public List<ExcelProjectDetails> getbyname(String vendor_name) {
		
		return repository.getByVendorNameContains(vendor_name);
	}

	
	  
	
	
	
	
	
	  
//	public static  ExcelProjectDetails editScreenRec(long vendor_id) 
//	{
//		Optional<ExcelProjectDetails> entrydetailfinal = repository.findById(vendor_id);
//		if (entrydetailfinal.isPresent()) {
//			return entrydetailfinal.get();
//		}
//		throw new RuntimeException("Employee is not found for the id" + vendor_id);
//
//		
//	}

	
	
}
