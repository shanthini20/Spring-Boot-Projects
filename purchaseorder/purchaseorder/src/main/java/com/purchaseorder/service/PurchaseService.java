
package com.purchaseorder.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.purchaseorder.Entity.PurchaseDetails;
import com.purchaseorder.dto.FileUpload;

public interface PurchaseService {

	FileUpload roughEntry( MultipartFile sow_copy, MultipartFile po_copy) throws IOException;

	String newPurchase(PurchaseDetails purchaseDetails);

	List<PurchaseDetails> getdata();

//	byte[] downloadImageFromFileSystem(String pofilename) throws IOException;

//	String newPurchase(PurchaseDetails purchaseDetails);

//	String roughEntry(PurchaseDetails purchaseDetails, MultipartFile sowcopy, MultipartFile pocopy);

}
