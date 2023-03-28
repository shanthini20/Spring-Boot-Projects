package com.purchaseorder.dto;

import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;



public class FileDownloadUtil {
	 private Path foundFile;
	  
	    public Resource getFileAsResource(String pofilename) throws IOException {
	    	String Folder="C:\\Users\\ShanthiniPackirisamy\\Desktop\\PoCopy\\";
	        Path dirPath = Paths.get(Folder);
	         
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

	
	
	
}
