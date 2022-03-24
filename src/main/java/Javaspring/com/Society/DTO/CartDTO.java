package Javaspring.com.Society.DTO;

public class CartDTO {
	private int quantity;
	private double totalPrice;
	private ProductDTO productDTO;
	private String formatCurrency;
	
	
	
	public CartDTO() {
		super();
	}
	public CartDTO(int quantity, double totalPrice, ProductDTO productDTO) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.productDTO = productDTO;
	}
	
	
	public String getFormatCurrency() {
		return formatCurrency;
	}
	public void setFormatCurrency(String formatCurrency) {
		this.formatCurrency = formatCurrency;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	
	
}
