package com.team.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.team.Dto.FileUpload;
import com.team.Entity.Userdetails;
import com.team.Service.Userservice;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.nio.file.Path;
import java.nio.file.Paths;

@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private Userservice userservice;

	@PostMapping("/profile")
	FileUpload roughEntry(@RequestParam("profilepic") MultipartFile profilepic) throws IOException {
		return userservice.roughEntry(profilepic);
	}

	@PostMapping("/userdata")

	String insert(@RequestBody Userdetails userdetails) {
		return userservice.insert(userdetails);
	}

	@GetMapping("/data")
	List<Userdetails> getdata() {
		return userservice.getdata();
	}

	@PutMapping("/edit")
	public String edit(@RequestParam(name = "firstname") String firstname,
			@RequestParam(name = "lastname") String lastnmae, @RequestParam(name = "age") String age,
			@RequestParam(name = "dob") String dob, @RequestParam(name = "doj") String doj,
			@RequestParam(name = "userid") long userid, @RequestParam(name = "profilepic") String profilepic,
			@RequestParam(name = "profilepicname") String profilepicname) {
		return userservice.edit(firstname, lastnmae, age, dob, doj, userid, profilepic, profilepicname);
	}

	@PutMapping("/profileedit")
	FileUpload profileedit(@RequestParam("profilepic") MultipartFile profilepic,
			@RequestParam(name = "userid") long userid) throws IOException {
		return userservice.profileedit(profilepic, userid);
	}

	@GetMapping("/singlerow")
	public ResponseEntity<List<Userdetails>> getSingleTutorials(@RequestParam(name = "userid") long userid) {
		try {
			List<Userdetails> singleuser = userservice.getSingleuser(userid);

			if (singleuser.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(singleuser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update")

	String update(@RequestParam(name = "userid") Long userid, @RequestBody Userdetails userdetails) {
		return userservice.update(userid, userdetails);
	}

	@GetMapping("/images/{profilepicname}")
	public ResponseEntity<Resource> downloadImage(@PathVariable String profilepicname) throws IOException {
		Path filePath = Paths.get("C:\\Users\\ShanthiniPackirisamy\\Desktop\\profileimg\\" + profilepicname);
		Resource resource = new UrlResource(filePath.toUri());

		if (resource.exists()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + profilepicname);
			return ResponseEntity.ok().headers(headers).contentLength(resource.contentLength())
					.contentType(MediaType.IMAGE_PNG).body(resource);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/agentpage")
	List<Userdetails> getTableAgentData(@RequestParam(name = "userid") long userid) {
		return userservice.getTableAgentData(userid);
	}

}
