package Javaspring.com.Society.Entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class InvoiceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	private UserEntity owner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buyer_id")
	private UserEntity buyer;
	
	@Column(name = "createAt")
	private Date createAt;
	
	@Column(name = "total")
	private double total;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "note")
	private String note;
	

	@Column(name = "status")
	private int status;
	
	@Column(name = "paymentmethod")
	private int paymentmethod;
	
	
	@OneToMany(mappedBy = "invoice")
	private List<DetailedInvoiceEntity> invoice= new ArrayList<DetailedInvoiceEntity>();
	
	
	
	public InvoiceEntity() {
		super();
	}



	


	
	public InvoiceEntity(long id, UserEntity owner, UserEntity buyer, Date createAt, double total, int quantity,
			String address, String note, int status, int paymentmethod, List<DetailedInvoiceEntity> invoice) {
		super();
		this.id = id;
		this.owner = owner;
		this.buyer = buyer;
		this.createAt = createAt;
		this.total = total;
		this.quantity = quantity;
		this.address = address;
		this.note = note;
		this.status = status;
		this.paymentmethod = paymentmethod;
		this.invoice = invoice;
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public UserEntity getOwner() {
		return owner;
	}



	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}



	public UserEntity getBuyer() {
		return buyer;
	}



	public void setBuyer(UserEntity buyer) {
		this.buyer = buyer;
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



	public List<DetailedInvoiceEntity> getInvoice() {
		return invoice;
	}



	public void setInvoice(List<DetailedInvoiceEntity> invoice) {
		this.invoice = invoice;
	}

	
	
	
}
