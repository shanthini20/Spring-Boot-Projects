package com.team.Implementation;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.team.Dao.UserRepository;
import com.team.Dto.FileUpload;
import com.team.Entity.Userdetails;
import com.team.Service.Userservice;



@Service
public class UserImpl implements Userservice {

	@Autowired
	private UserRepository repo;

	private final String Folder_Path1 = "C:\\Users\\ShanthiniPackirisamy\\Desktop\\profileimg\\";

	@Override
	public FileUpload roughEntry(MultipartFile profilepic) throws IOException {
		String fileCode = RandomStringUtils.randomAlphanumeric(8);

		String filePath = Folder_Path1 + fileCode + "-" + profilepic.getOriginalFilename();

		profilepic.transferTo(new File(filePath));
		String data1 = filePath;

		FileUpload fiUpload = new FileUpload();
		fiUpload.setProfilepic(data1);

		return fiUpload;
	}

	@Override
	public String insert(Userdetails userdetails) {

		if (userdetails != null) {
			repo.save(userdetails);
			return "save";
		}
		return "wrong";
	}

	@Override
	public List<Userdetails> getdata() {
		List<Userdetails> userlist = repo.findAll();
		return userlist;
	}

	@Override
	public String edit(String firstname, String lastnmae, String age, String dob, String doj, long userid,
			String profilepic, String profilepicname) {

		Optional<Userdetails> getdata = repo.findById(userid);
		if (getdata.isPresent()) {
			Userdetails newentry = getdata.get();
			newentry.setFirstname(firstname);
			newentry.setLastname(lastnmae);
			newentry.setAge(age);
			newentry.setDob(dob);
			newentry.setDoj(doj);
			newentry.setProfilepic(profilepicname);
			newentry.setProfilepicname(profilepicname);

			repo.save(newentry);
		}
		return "updated";
	}

	@Override
	public FileUpload profileedit(MultipartFile profilepic, long userid) throws IOException {

		Optional<Userdetails> getdata = repo.findById(userid);
		if (getdata.isPresent()) {

			String fileCode = RandomStringUtils.randomAlphanumeric(8);
			String filePath = Folder_Path1 + fileCode + "-" + profilepic.getOriginalFilename();
			profilepic.transferTo(new File(filePath));
			String data1 = filePath;
			FileUpload newentry = new FileUpload();
			newentry.setProfilepic(data1);

			return newentry;
		}
		FileUpload ff = new FileUpload();
		return ff;

	}

	@Override
	public List<Userdetails> getSingleuser(long vendor_id) {

		Optional<Userdetails> newdata = repo.findById(vendor_id);
		if (newdata.isPresent()) {
			newdata.get();
			List<Userdetails> newlist = new ArrayList<>();
			newlist.add(newdata.get());
			return newlist;
		}
		return null;

	}

	@Override
	public String update(Long userid, Userdetails userdetails) {

		Optional<Userdetails> getdata = repo.findById(userid);
		if (getdata.isPresent()) {
			Userdetails newentry = getdata.get();
			newentry.setFirstname(userdetails.getFirstname());
			newentry.setLastname(userdetails.getLastname());
			newentry.setAge(userdetails.getAge());
			newentry.setDob(userdetails.getDob());
			newentry.setDoj(userdetails.getDoj());
			newentry.setProfilepic(userdetails.getProfilepic());
			newentry.setProfilepicname(userdetails.getProfilepicname());

			repo.save(newentry);
		}
		return "updated";
	}

	@Override
	public List<Userdetails> getTableAgentData(Long userid) {
		List<Userdetails> newList = repo.findByUserID(userid);
		return newList;
	}

//	@Override
//	public List<Userdetails> findAllUserDetails(String firstname) throws NullPointerException{
//		 List<Userdetails> data = repo.findAllByUserName(firstname);
//			return data;
//	
//	}

//	  @Override
//	    public List<Userdetails> findAllUserDetails(long userid) {
//		  
//		
//	    }
//	
//	

// private Path foundFile;
// 
//    public Resource getFileAsResource(String profilepicname) throws IOException {
//        Path dirPath = Paths.get("filePath");
//         
//        Files.list(dirPath).forEach(file -> {
//            if (file.getFileName().toString().startsWith(profilepicname)) {
//                foundFile = file;
//                return;
//            }
//        });
// 
//        if (foundFile != null) {
//            return new UrlResource(foundFile.toUri());
//        }
//         
//        return null;
//    }

//	@Override
//	public FileUpload profileedit(MultipartFile profilepic,long userid) {
//		Optional<Userdetails> getdata = repo.findById(userid);
//		if (getdata.isPresent()) {
//			Userdetails newentry = getdata.get();
//			newentry.setFirstname(firstname);
//	}

//	public String edit(String firstname, Object lastname, String age, String dob, String doj, long userid) {
//		
//		Optional<Userdetails> getdata = repo.findById(userid);
//		if (getdata.isPresent()) {
//			Userdetails newentry = getdata.get();
//			newentry
//			
//			repository.save(newentry);
//		}
//		return "updated";
//	}

}
