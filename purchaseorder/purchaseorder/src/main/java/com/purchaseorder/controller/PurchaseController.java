package com.purchaseorder.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.purchaseorder.Entity.PurchaseDetails;
import com.purchaseorder.dto.FileDownloadUtil;
import com.purchaseorder.dto.FileUpload;
import com.purchaseorder.service.PurchaseService;


@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;

	@PostMapping("/neworder")
	String newPurchase(@RequestBody PurchaseDetails purchaseDetails) {
		return purchaseService.newPurchase(purchaseDetails);
	}

	@PostMapping("/fileupload" )
	FileUpload roughEntry( @RequestParam ("sow_copy")MultipartFile sow_copy,@RequestParam ("po_copy")MultipartFile po_copy) throws IOException{
		return purchaseService.roughEntry(sow_copy, po_copy);
	}
	
	@GetMapping("/data")
	List<PurchaseDetails> getdata()
	{
		return purchaseService.getdata();
	}
	
	 @GetMapping("/downloadFil/{filename}")
	    public ResponseEntity<?> downloadFil(@PathVariable("filename") String pofilename) {
	        FileDownloadUtil downloadUtil = new FileDownloadUtil();
	         
	        Resource resource = null;
	        try {
	            resource = downloadUtil.getFileAsResource(pofilename);
	        } catch (IOException e) {
	            return ResponseEntity.internalServerError().build();
	        }
	         
	        if (resource == null) {
	            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
	        }
	         
	        String contentType = "application/octet-stream";
	        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
	         
	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
	                .body(resource);       
	    }
	
	
	
	
	 private static final String FILE_PATH = "C:\\Users\\ShanthiniPackirisamy\\Desktop\\PoCopy\\";

	 @GetMapping("/downloadFile/{pofilename:.+}")
	 public ResponseEntity<Resource> downloadFile(@PathVariable String pofilename) throws IOException {
	     Path filePath = Paths.get(FILE_PATH + pofilename);
	     Resource resource = new UrlResource(filePath.toUri());

	     if (resource.exists()) {
	         HttpHeaders headers = new HttpHeaders();
	         headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\""); // set filename
	         headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(filePath));

	         return ResponseEntity.ok()
	                 .headers(headers)
	                 .contentLength(resource.getFile().length())
	                 .body(resource);
	     } else {
	         throw new FileNotFoundException("File not found: " + pofilename);
	     }
	 }

	 

		
	 private static final String FILE_PATH1 = "C:\\Users\\ShanthiniPackirisamy\\Desktop\\SowCopy\\";

	 @GetMapping("/downloadfile/{sowfilename:.+}")
	 public ResponseEntity<Resource> downloadfile(@PathVariable String sowfilename) throws IOException {
	     Path filePath = Paths.get(FILE_PATH1 + sowfilename);
	     Resource resource = new UrlResource(filePath.toUri());

	     if (resource.exists()) {
	         HttpHeaders headers = new HttpHeaders();
	         headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\""); // set filename
	         headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(filePath));

	         return ResponseEntity.ok()
	                 .headers(headers)
	                 .contentLength(resource.getFile().length())
	                 .body(resource);
	     } else {
	         throw new FileNotFoundException("File not found: " + sowfilename);
	     }
	 }

	    
	 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/download/{fileName}")
//	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String pofilename) throws IOException {
//		byte[] filedata=purchaseService.downloadImageFromFileSystem(pofilename);
//		return ResponseEntity.status(HttpStatus.OK)
//				.contentType(MediaType.MULTIPART_FORM_DATA)
//				.body(filedata);
//
//	}
//	
//	 @GetMapping("/downloadFile/{fileCode}")
//	    public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String pofilename) {
//	        PurchaseDetails downloadUtil = new PurchaseDetails();
//	         
//	        Resource resource = null;
//	        try {
//	            resource = downloadUtil.getFileAsResource(pofilename);
//	        } catch (IOException e) {
//	            return ResponseEntity.internalServerError().build();
//	        }
//	         
//	        if (resource == null) {
//	            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
//	        }
//	         
//	        String contentType = "MULTIPART_FORM_DATA";
////	        String headerValue = "attachment; filename=\"" + resource. + "\"";
////	         
////	        return ResponseEntity.ok()
////	                .contentType(MediaType.parseMediaType(contentType))
////	                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
////	                .body(resource);       
////	    }
////	
	

}
