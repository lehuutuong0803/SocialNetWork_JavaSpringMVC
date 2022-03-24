package Javaspring.com.Society.DTO;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	private long id;
	private String product_name;
	private double price;
	private String note;
	private int amount;
	private int status;
	private Date createat;
	private long user_id;
	private String image;
	private List<MultipartFile> file;
	private String formatCurrency;
	
	
	public ProductDTO() {
		super();
	}
	
	
	public ProductDTO(long id, String product_name, double price, String note, int amount, int status, Date createat,
			long user_id, String image) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.price = price;
		this.note = note;
		this.amount = amount;
		this.status = status;
		this.createat = createat;
		this.user_id = user_id;
		this.image = image;
	}


	
	
	
	public String getFormatCurrency() {
		return formatCurrency;
	}


	public void setFormatCurrency(String formatCurrency) {
		this.formatCurrency = formatCurrency;
	}


	public List<MultipartFile> getFile() {
		return file;
	}


	public void setFile(List<MultipartFile> file) {
		this.file = file;
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
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	
	
}
