package com.purchaseorder.Entity;

import org.springframework.core.io.Resource;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "purchase_details")
public class PurchaseDetails {
    @Column(name="business_model")
	private String business_model;
    @Column(name="department")
	private String department;
    @Column(name="project_initiation")
	private String project_initiation;
    @Column(name="pov_month")
	private double pov_month;
    @Column(name="pov")
	private double pov;
    @Column(name="order_quantity")
	private double order_quantity;
    @Column(name="invoiced_amount")
	private double invoiced_amount;
    @Column(name="po_startdate")
	private String po_startdate;
    @Column(name="country")
	private String country;
    @Column(name="client_purchasecontact")
	private String client_purchasecontact;
    @Column(name="client_operationcontact")
	private String client_operationcontact;
    @Column(name="kg_operationcontact")
	private String kg_operationcontact;
    @Column(name="bill_to_address")
	private String bill_to_address;
    @Column(name="po_receiveddate")
	private String po_receiveddate;
    @Column(name="date_of_closure")
	private String date_of_closure;
	@Id
	  @Column(name="po_number")
	private long po_number;
	  @Column(name="functionality")
	private String functionality;
	  @Column(name="total_resources")
	private String total_resources;
	  @Column(name="po_tenure")
	private double po_tenure;
	  @Column(name="achieved_pov")
	private double achieved_pov;
	  @Column(name="achieved_order_qty")
	private double achieved_order_qty;
	  @Column(name="received_amount")
	private double received_amount;
	  @Column(name="po_enddate")
	private String po_enddate;
	  @Column(name="state")
	private String state;
	  @Column(name="phone_no1")
	private String phone_no1;
	  @Column(name="phone_no2")
	private String phone_no2;
	  @Column(name="phone_no3")
	private String phone_no3;
	  @Column(name="ship_to_address")
	private String ship_to_address;
	 
	  @Column(name="dispositions")
	private String dispositions;
	  @Column(name="project_name")
	private String project_name;
	  @Column(name="status")
	private String status;
	  @Column(name="business_location")
	private String business_location;
	  @Column(name="sow_id")
	private String sow_id;
	  @Column(name="balance_pov")
	private double balance_pov;
	  @Column(name="balance_quantity")
	private double balance_quantity;
	  @Column(name="outstanding")
	private String outstanding;
	  @Column(name="actual_po_enddate")
	private String actual_po_enddate;
	  @Column(name="city")
	private String city;
	  @Column(name="email_id1")
	private String email_id1;
	  @Column(name="email_id2")
	private String email_id2;
	  @Column(name="email_id3")
	private String email_id3;
	  
	  @Column(name="comments")
	private String comments;
	  @Column(name="sow_url")
	  private String sow_url;
	  @Column(name="po_url")
	  private String po_url;
	  @Column(name="sowfilename")
	  private String sowfilename;
	  @Column(name="pofilename")
	  private String pofilename;
	
}
