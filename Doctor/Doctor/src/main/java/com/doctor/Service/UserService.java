package com.doctor.Service;

import jakarta.servlet.http.HttpSession;

public interface UserService {

	Long login(String username, String password, HttpSession session);

}
