package com.purchaseorder.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.purchaseorder.Entity.PurchaseDetails;
import com.purchaseorder.Repo.PurchaseRepository;
import com.purchaseorder.dto.FileUpload;
import com.purchaseorder.service.PurchaseService;

@Service
public class PurchaseImplementation implements PurchaseService {

	@Autowired
	PurchaseRepository purchaseRepository;

	private final String Folder_Path1="C:\\Users\\ShanthiniPackirisamy\\Desktop\\SowCopy\\";
	private final String Folder_Path2="C:\\Users\\ShanthiniPackirisamy\\Desktop\\PoCopy\\";
	
	@Override
	public FileUpload roughEntry( MultipartFile sow_copy, MultipartFile po_copy)throws IOException {
		  String fileCode = RandomStringUtils.randomAlphanumeric(8);
		  String fileCode1 = RandomStringUtils.randomAlphanumeric(8);
		  
		String filePath=Folder_Path1+fileCode+"-"+sow_copy.getOriginalFilename();
		String filePath1=Folder_Path2+fileCode1+"-"+po_copy.getOriginalFilename();
//		PurchaseDetails purchaseDetails1=purchaseRepository.save(PurchaseDetails.builder()
//				 .sow_copy(filePath)
//		         .po_copy(filePath1).build());
		
		sow_copy.transferTo(new File(filePath));
		po_copy.transferTo(new File(filePath1));
		
		
				
			 String data1=filePath;
			 String data2=filePath1;
			FileUpload fiUpload=new FileUpload();
			fiUpload.setPo_copy_url(data2);
			fiUpload.setSow_copy_url(data1);
			 
			
			return fiUpload;			
				
	}

	@Override
	public String newPurchase(PurchaseDetails purchaseDetails) {
		if (purchaseDetails != null) {
			purchaseRepository.save(purchaseDetails);
		return "save";
	}
	return "wrong";
	
	}

	@Override
	public List<PurchaseDetails> getdata() {
		List<PurchaseDetails> purchaselist = purchaseRepository.findAll();
		return purchaselist;
		
	}
	
	private Path foundFile;
    
    public Resource getFileAsResource(String pofilename) throws IOException {
        Path dirPath = Paths.get("filePath");
         
        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(pofilename)) {
                foundFile = file;
                return;
            }
        });
 
        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }
         
        return null;
    }


//	@Override
//	public byte[] downloadImageFromFileSystem(String pofilename) throws IOException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
	
//	 public byte[] downloadImageFromFileSystem(String pofilename) throws IOException {
//	        Optional<PurchaseDetails> fileData = purchaseRepository.(pofilename);
//	        String filePath=fileData.get().getPo_url();
//	        byte[] images = Files.readAllBytes(new File(filePath).toPath());
//	        return images;
//	    }
//	 
	 

	
	
	
	
	
	
//	@Override
//	public String roughEntry(PurchaseDetails purchaseDetails, MultipartFile sowcopy, MultipartFile pocopy) {
//	
//		return null;
//	}
//
//	@Override
//	public String newPurchase(PurchaseDetails purchaseDetails) {
//		if (purchaseDetails != null) {
//			purchaseRepository.save(purchaseDetails);
//			return "Product data added Successfully";
//		}
//		return "Product is null";
//	}

//	@Override
//	public String roughEntry(PurchaseDetails purchaseDetails,  MultipartFile sowcopy,  MultipartFile pocopy) {
//		if (purchaseDetails != null &&  sowcopy!= null && pocopy != null) {
//			MultipartFile firstFilePath = uploadFile(sowcopy);
//			 MultipartFile secondFilePath = uploadFile(pocopy);
//			if (firstFilePath != null && !firstFilePath.isEmpty() && !firstFilePath.isBlank()) {
//				purchaseDetails.setPo_copy(firstFilePath);
//			}
//			if (secondFilePath != null && !secondFilePath.isEmpty() && !firstFilePath.isBlank()) {
//				purchaseDetails.setSow_copy(secondFilePath);
//			}
//
//			if (purchaseDetails.getPo_copy() != null && !purchaseDetails.getPo_copy().isEmpty()
//					&& !purchaseDetails.getPo_copy().isBlank() && purchaseDetails.getSow_copy() != null
//					&& !purchaseDetails.getSow_copy().isEmpty() && !purchaseDetails.getSow_copy().isBlank()) {
//				purchaseRepository.save(purchaseDetails);
//				return "Saved Successfully";
//			}
//		}
//		return "Some Details Missing";
//	}
//
//	private String uploadFile( MultipartFile sowcopy, MultipartFile pocopy) {
//		String filePath = null;
//		return filePath;
//	}

}
