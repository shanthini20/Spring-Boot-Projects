package com.ExcelProject;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.spi.PersistenceProvider;

@Entity
@Table(name="excel_details")
public class ExcelProjectDetails {
    @Column(name="priority")
	private String priority;
    @Column(name="reason")
	private String reason;
    @Id
    @Column(name="vendor_id")
	private long vendor_id;
   
	@Column(name="vendor_name")
	private String vendor_name;
    @Column(name="scan_id")
	private long scan_id;
    @Column(name="cluster")
	private String cluster;
    @Column(name="country")
	private String country;
    @Column(name="document_no")
	private String document_no;
    @Column(name="company_code")
	private String company_code;
    @Column(name="type")
	private String type;
    @Column(name="total_amnt")
	private double total_amnt;
    @Column(name="currency")
	private String currency;
    @Column(name="po_no")
	private String po_no;
    @Column(name="scan_date")
	private String scan_date;
    @Column(name="existing_status")
	private String existing_status;
    @Column(name="existing_comments")
	private String existing_comments;
    
    
    public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public long getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(long vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public long getScan_id() {
		return scan_id;
	}
	public void setScan_id(long scan_id) {
		this.scan_id = scan_id;
	}
	public String getCluster() {
		return cluster;
	}
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDocument_no() {
		return document_no;
	}
	public void setDocument_no(String document_no) {
		this.document_no = document_no;
	}
	public String getCompany_code() {
		return company_code;
	}
	public void setCompany_code(String company_code) {
		this.company_code = company_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getTotal_amnt() {
		return total_amnt;
	}
	public void setTotal_amnt(double total_amnt) {
		this.total_amnt = total_amnt;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPo_no() {
		return po_no;
	}
	public void setPo_no(String po_no) {
		this.po_no = po_no;
	}
	public String getScan_date() {
		return scan_date;
	}
	public void setScan_date(String scan_date) {
		this.scan_date = scan_date;
	}
	public String getExisting_status() {
		return existing_status;
	}
	public void setExisting_status(String existing_status) {
		this.existing_status = existing_status;
	}
	public String getExisting_comments() {
		return existing_comments;
	}
	public void setExisting_comments(String existing_comments) {
		this.existing_comments = existing_comments;
	}
	
	@Override
	public String toString() {
		return "ExcelProjectDetails [priority=" + priority + ", reason=" + reason + ", vendor_id=" + vendor_id
				+ ", vendor_name=" + vendor_name + ", scan_id=" + scan_id + ", cluster=" + cluster + ", country="
				+ country + ", document_no=" + document_no + ", company_code=" + company_code + ", type=" + type
				+ ", total_amnt=" + total_amnt + ", currency=" + currency + ", po_no=" + po_no + ", scan_date="
				+ scan_date + ", existing_status=" + existing_status + ", existing_comments=" + existing_comments + "]";
	}
	
	public ExcelProjectDetails()
	{
		
	}
	
	public ExcelProjectDetails(String priority, String reason, long vendor_id, String vendor_name, long scan_id,
			String cluster, String country, String document_no, String company_code, String type, double total_amnt,
			String currency, String po_no, String scan_date, String existing_status, String existing_comments) {
	
		this.priority = priority;
		this.reason = reason;
		this.vendor_id = vendor_id;
		this.vendor_name = vendor_name;
		this.scan_id = scan_id;
		this.cluster = cluster;
		this.country = country;
		this.document_no = document_no;
		this.company_code = company_code;
		this.type = type;
		this.total_amnt = total_amnt;
		this.currency = currency;
		this.po_no = po_no;
		this.scan_date = scan_date;
		this.existing_status = existing_status;
		this.existing_comments = existing_comments;
	}
	
	
	
	
	
	
}
