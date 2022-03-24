package Javaspring.com.Society.ServiceUser;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.CartDTO;
import Javaspring.com.Society.DTO.ProductDTO;

@Service
public class CartServiceImp implements CartService{

	@Autowired
	private ProductService productService;
	
	@Override
	public HashMap<Long, CartDTO> AddCart(long id, HashMap<Long, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();
		ProductDTO productDTO = productService.findOneById(id);
		if(productDTO != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(itemCart.getQuantity()+1);
			itemCart.setTotalPrice(itemCart.getQuantity()*itemCart.getProductDTO().getPrice());
		}else {
			itemCart.setProductDTO(productDTO);
			itemCart.setQuantity(1);
			itemCart.setTotalPrice(productDTO.getPrice());
		}
		Locale localeEN = new Locale("en", "EN");
	    NumberFormat en = NumberFormat.getInstance(localeEN);
	    itemCart.setFormatCurrency(en.format(itemCart.getTotalPrice()));
	    
		cart.put(id, itemCart);
		return cart;
	}

	@Override
	public HashMap<Long, CartDTO> EditCart(long id, int quantity, HashMap<Long, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuantity(quantity);
			itemCart.setTotalPrice(quantity*itemCart.getProductDTO().getPrice());
			cart.put(id, itemCart);
		} 
		return cart;
	
	}

	@Override
	public HashMap<Long, CartDTO> DeleteCart(long id, HashMap<Long, CartDTO> cart) {
		if(cart == null) {
			return cart;
		}	
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		
		return cart;
	}

	@Override
	public int TotalQuantity( HashMap<Long, CartDTO> cart) {
		int totalQuantity = 0;
		for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			totalQuantity += itemCart.getValue().getQuantity();
		}
		return totalQuantity;
	}

	@Override
	public double TotalPrice( HashMap<Long, CartDTO> cart) {
		double totalPrice = 0;
		for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}

	
}
