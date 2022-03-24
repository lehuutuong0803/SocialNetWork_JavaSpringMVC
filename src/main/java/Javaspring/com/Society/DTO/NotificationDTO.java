package Javaspring.com.Society.DTO;

public class NotificationDTO {
	String userid;
	String username_buyer;
	String invoiceid;
	
	
	
	public NotificationDTO() {
		super();
	}
	public NotificationDTO(String userId, String username_buyer) {
		super();
		this.userid = userId;
		this.username_buyer = username_buyer;
	}
	public NotificationDTO(String userid, String username_buyer, String invoiceid) {
		super();
		this.userid = userid;
		this.username_buyer = username_buyer;
		this.invoiceid = invoiceid;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getUserId() {
		return userid;
	}
	public void setUserId(String userId) {
		this.userid = userId;
	}
	public String getUsername_buyer() {
		return username_buyer;
	}
	public void setUsername_buyer(String username_buyer) {
		this.username_buyer = username_buyer;
	}
	
	

}
