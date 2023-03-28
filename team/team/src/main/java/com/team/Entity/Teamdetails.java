package com.team.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "team_details")
public class Teamdetails {
	@Id
	@Column(name = "teamid")
	private long teamid;
	@Column(name = "teamname")
	private String teamname;
}
