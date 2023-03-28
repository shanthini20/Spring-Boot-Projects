package com.team.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.team.Dto.FileUpload;
import com.team.Entity.Userdetails;

public interface Userservice {

	FileUpload roughEntry(MultipartFile profilepic) throws IOException;

	String insert(Userdetails userdetails);

	List<Userdetails> getdata();

	String edit(String firstname, String lastnmae, String age, String dob, String doj, long userid, String profilepic,
			String profilepicname);

	FileUpload profileedit(MultipartFile profilepic, long userid) throws IOException;

	List<Userdetails> getSingleuser(long vendor_id);

	String update(Long userid, Userdetails userdetails);

	List<Userdetails> getTableAgentData(Long userid);

}
