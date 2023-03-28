package com.coachingTracker.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="coachingtrackerentrytbl")


public class EntryDetails {
    @Id
    private int entryid;
    @Column(name="shiftdate")
	private Date shiftdate;
    @Column(name="supervisorname")
	private String supervisorname;
    @Column(name="reason")
	private String reason;
    @Column(name="hour")
	private String hour;
    @Column(name="agent_name")
	private String agent_name;
    @Column(name="notes")
    private String	notes;
    @Column(name="minute")
	private String minute;
    @Column(name="agent_comments")
    private String agent_comments;
    @Column(name="status")
    private String status;
    @Column(name="userid")
    private int userid;
}
