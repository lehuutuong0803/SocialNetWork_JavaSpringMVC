package Javaspring.com.Society.API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Javaspring.com.Society.DTO.CartDTO;
import Javaspring.com.Society.DTO.ProductDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.CartService;
import Javaspring.com.Society.ServiceUser.ProductService;
import Javaspring.com.Society.ServiceUser.UserService;

@RestController(value = "cartAPIOfAdmin")
public class CartAPI {
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;
	
	@PostMapping("api/user/addcart")
	public void AddCart(@RequestBody String code, HttpSession session) {
		String[] arrOfStr = code.split("=");
	     String room = arrOfStr[0];
		long id = Integer.parseInt(room);
		ProductDTO productDTO = productService.findOneById(id);
		List<UserDTO> owner = (List<UserDTO>)session.getAttribute("OwnerList");
		UserDTO productOwner = userService.findOneById(productDTO.getUser_id());
		if(owner ==null) {
			owner = new ArrayList<UserDTO>();
		}
		int n=0;
		for(UserDTO user : owner) {
			if(user.getId() == productOwner.getId())
				n++;
				
		}
		if(n==0) {
			owner.add(productOwner);
		}
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		if(cart ==null) {
			cart = new HashMap<Long, CartDTO>();
		}
		 cart = cartService.AddCart(id, cart);
		
		 session.setAttribute("OwnerList", owner);
		 session.setAttribute("Cart", cart);
		 session.setAttribute("TotalPrice", cartService.TotalPrice( cart));
		 session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
	}

}
