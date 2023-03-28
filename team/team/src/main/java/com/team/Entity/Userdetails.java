package com.team.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class Userdetails {
	@Id
	@Column(name = "userid")
	private long userid;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "age")
	private String age;
	@Column(name = "dob")
	private String dob;
	@Column(name = "doj")
	private String doj;
	@Column(name = "profilepic")
	private String profilepic;
	@Column(name = "profilepicname")
	private String profilepicname;

}
