package com.doctor.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.doctor.Entity.UserDetails;
import com.doctor.Repository.UserRepository;
import com.doctor.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public Long login(@RequestParam String username, @RequestParam String password, HttpSession session) {

		UserDetails user = userRepository.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			session.setAttribute("user", user);
			if (user.getRole().equals("admin")) {
				long userid = user.getUserid();
				return userid;
			} else {
				long userid = user.getUserid();
				return userid;
			}
		} else {
			long num = 0000;
			return num;
		}
	}

}