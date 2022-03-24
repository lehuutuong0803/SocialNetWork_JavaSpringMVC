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
@Table(name = "product_user")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "product_name")
	private String product_name;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "amount")
	private int amount;
	
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "createat")
	private Date createat;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@OneToMany(mappedBy = "product")
	private List<DetailedInvoiceEntity> product= new ArrayList<DetailedInvoiceEntity>();

	
	
	public ProductEntity() {
		super();
	}

	
	

	public ProductEntity(long id, String product_name, double price, String note, String image, int amount, int status,
			Date createat, UserEntity user, List<DetailedInvoiceEntity> product) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.price = price;
		this.note = note;
		this.image = image;
		this.amount = amount;
		this.status = status;
		this.createat = createat;
		this.user = user;
		this.product = product;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateat() {
		return createat;
	}

	public void setCreateat(Date createat) {
		this.createat = createat;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<DetailedInvoiceEntity> getProduct() {
		return product;
	}

	public void setProduct(List<DetailedInvoiceEntity> product) {
		this.product = product;
	}


	
	
}
