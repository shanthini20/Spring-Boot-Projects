package com.ExcelProject;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.persistence.spi.PersistenceProvider;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/csv")
public class CSVController {
	
	 @Autowired
	  CSVService fileService;

	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (CSVHelper.hasCSVFormat(file)) {
	      try {
	        fileService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/api/csv/download/")
	                .path(file.getOriginalFilename())
	                .toUriString();

	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,fileDownloadUri));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
	      }
	    }

	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
	  }

	  @GetMapping("/tutorials")
	  public ResponseEntity<List<ExcelProjectDetails>> getAllTutorials() {
	    try {
	      List<ExcelProjectDetails> tutorials = fileService.getAllTutorials();

	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/download/{fileName:.+}")
	  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
	    InputStreamResource file = new InputStreamResource(fileService.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
	        .contentType(MediaType.parseMediaType("application/csv"))
	        .body(file);
	  }
	  
	  @GetMapping("/singlerow")
	  public ResponseEntity<List<ExcelProjectDetails>> getSingleTutorials(@RequestParam(name="vendor_id")long vendor_id) {
	    try {
	      List<ExcelProjectDetails> singletutorials = fileService.getSingleTutorials(vendor_id);

	      if (singletutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(singletutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("/lastsave")
	  public String edit(@RequestParam(name="priority")String priority,@RequestParam(name="reason")String reason,@RequestParam(name="vendor_id")long vendor_id,@RequestParam(name="vendor_name")String vendor_name,@RequestParam(name="cluster")String cluster,@RequestParam(name="country")String country,@RequestParam(name="document_no")String document_no,@RequestParam(name="company_code")String company_code,@RequestParam(name="type")String type,@RequestParam(name="total_amnt")double total_amnt,@RequestParam(name="currency")String currency,@RequestParam(name="po_no")String po_no,@RequestParam(name="scan_date")String scan_date,@RequestParam(name="existing_status")String existing_status,@RequestParam(name="existing_comments")String existing_comments)
	  {
		  return fileService.edit(priority,reason,vendor_id,vendor_name,cluster,country,document_no,company_code,type,total_amnt,currency,po_no,scan_date,existing_status,existing_comments);
	  }
	  
	  @GetMapping("/get")
		List<ExcelProjectDetails> getbyname(@RequestParam(name = "vendor_name") String vendor_name) {
			return fileService.getbyname(vendor_name);

		}
}
