package Javaspring.com.Society.DTO;

public class DetailedInvoiceDTO {

	private long id;
	private long product_id;
	private long invoice_id;
	private int amount;
	private double price;
	private String formatCurrency;
	
	
	public DetailedInvoiceDTO() {
		super();
	}


	public DetailedInvoiceDTO(long id, long product_id, long invoice_id, int amount, double price) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.invoice_id = invoice_id;
		this.amount = amount;
		this.price = price;
	}

	
	public String getFormatCurrency() {
		return formatCurrency;
	}


	public void setFormatCurrency(String formatCurrency) {
		this.formatCurrency = formatCurrency;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getProduct_id() {
		return product_id;
	}


	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}


	public long getInvoice_id() {
		return invoice_id;
	}


	public void setInvoice_id(long invoice_id) {
		this.invoice_id = invoice_id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
