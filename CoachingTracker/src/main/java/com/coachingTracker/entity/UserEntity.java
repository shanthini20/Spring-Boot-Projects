package com.coachingTracker.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "usertbl")
public class UserEntity {
	@Id
	private int userid;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	@Column(name = "roleid")
	private int roleId;
	
	@Column(name="role")
	private String role;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
  public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
		

}
