package com.team.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="member_details")
public class Mem_details {
    @Id
	@Column(name="userid")
	private Long userid;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	
}
