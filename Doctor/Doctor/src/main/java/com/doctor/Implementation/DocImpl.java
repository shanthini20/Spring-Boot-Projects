package com.doctor.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.Entity.Docdetails;
import com.doctor.Repository.DocRepo;
import com.doctor.Service.DocService;


@Service
public class DocImpl implements DocService {
	
	@Autowired
	DocRepo docRepo;

	@Override
	public String doctorinsert(Docdetails docdetails) {
		docRepo.save(docdetails);
		return "save";
	}

}
