package Javaspring.com.Society.DTO;

import java.sql.Date;

public class InvoiceDTO {
	private long id;
	private long owner_id;
	private long buyer_id;
	private Date createAt;
	private double total;
	private int quantity;
	private String address;
	private String note;
	private String formatCurrency;
	private int status;
	private int paymentmethod;
	
	public InvoiceDTO() {
		super();
	}



	public InvoiceDTO(long id, long owner_id, long buyer_id, Date createAt, double total, int quantity, String address,
			String note, String formatCurrency, int status, int paymentmethod) {
		super();
		this.id = id;
		this.owner_id = owner_id;
		this.buyer_id = buyer_id;
		this.createAt = createAt;
		this.total = total;
		this.quantity = quantity;
		this.address = address;
		this.note = note;
		this.formatCurrency = formatCurrency;
		this.status = status;
		this.paymentmethod = paymentmethod;
	}













	public int getStatus() {
		return status;
	}













	public void setStatus(int status) {
		this.status = status;
	}













	public int getPaymentmethod() {
		return paymentmethod;
	}













	public void setPaymentmethod(int paymentmethod) {
		this.paymentmethod = paymentmethod;
	}













	public String getFormatCurrency() {
		return formatCurrency;
	}







	public void setFormatCurrency(String formatCurrency) {
		this.formatCurrency = formatCurrency;
	}







	public String getNote() {
		return note;
	}







	public void setNote(String note) {
		this.note = note;
	}







	public String getAddress() {
		return address;
	}






	public void setAddress(String address) {
		this.address = address;
	}






	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getOwner_id() {
		return owner_id;
	}


	public void setOwner_id(long owner_id) {
		this.owner_id = owner_id;
	}


	public long getBuyer_id() {
		return buyer_id;
	}


	public void setBuyer_id(long buyer_id) {
		this.buyer_id = buyer_id;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
