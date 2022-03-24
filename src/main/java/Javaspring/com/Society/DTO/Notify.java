package Javaspring.com.Society.DTO;

public class Notify {
	String userid;
	String username_buyer;
	String time;
	String invoiceid;
	
	
	public Notify() {
		super();
	}
	public Notify(String userid, String username_buyer, String time) {
		super();
		this.userid = userid;
		this.username_buyer = username_buyer;
		this.time = time;
	}
	
	public Notify(String userid, String username_buyer, String time, String invoiceid) {
		super();
		this.userid = userid;
		this.username_buyer = username_buyer;
		this.time = time;
		this.invoiceid = invoiceid;
	}
	
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername_buyer() {
		return username_buyer;
	}
	public void setUsername_buyer(String username_buyer) {
		this.username_buyer = username_buyer;
	}
	
	
}
