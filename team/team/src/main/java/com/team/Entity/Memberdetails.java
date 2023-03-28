package com.team.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "member_details")
public class Memberdetails {
	private List<Long> userIds;

	@Id
	@Column(name="memid")
	private long memid;
	@Column(name="userid")
	private long userid;
	@Column(name="teamid")
	private long teamid;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	
	

}
