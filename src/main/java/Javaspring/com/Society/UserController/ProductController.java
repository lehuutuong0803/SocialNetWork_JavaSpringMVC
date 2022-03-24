package Javaspring.com.Society.UserController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import Javaspring.com.Society.DTO.CartDTO;
import Javaspring.com.Society.DTO.ChatDTO;
import Javaspring.com.Society.DTO.Comment_PostDTO;
import Javaspring.com.Society.DTO.DetailedInvoiceDTO;
import Javaspring.com.Society.DTO.FacultyDTO;
import Javaspring.com.Society.DTO.InvoiceDTO;
import Javaspring.com.Society.DTO.ProductDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.CartService;
import Javaspring.com.Society.ServiceUser.DetailedInvoiceService;
import Javaspring.com.Society.ServiceUser.FacultyService;
import Javaspring.com.Society.ServiceUser.InvoiceService;
import Javaspring.com.Society.ServiceUser.ProductService;
import Javaspring.com.Society.ServiceUser.UserService;

@Controller
public class ProductController extends BaseController{

	@Autowired
	public UserService userService;
	@Autowired
	public FacultyService facultyService;
	@Autowired
	public ProductService productService;
	@Autowired
	private Cloudinary cloudinary;
	@Autowired
	private CartService cartService;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private DetailedInvoiceService detailedInvoiceService;
	
	
	@RequestMapping(value = "user/shop/{userid}", method = RequestMethod.GET)
	public ModelAndView Shop(@PathVariable("userid") long id ,HttpSession session) {
		UserDTO user1 = (UserDTO) session.getAttribute("User_Infor");
		
		UserDTO userDTO = userService.findOneById(id);
		
		FacultyDTO facultyDTO = facultyService.findOneById(userDTO.getId_Faculty());
		String fa = facultyDTO.getFacultyName();
	
		List<ProductDTO> productList = productService.findAllByUser_id(id);
		
		

		_mvShare.addObject("productList", productList);
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("faculty1", fa);
		_mvShare.addObject("details_user", userDTO);
		_mvShare.addObject("comment", new Comment_PostDTO());
		
		_mvShare.setViewName("user/shop");
		return _mvShare;
	}
	@RequestMapping(value = "user/insert-product", method = RequestMethod.GET)
	public ModelAndView Product(HttpSession session) {
		UserDTO user1 = (UserDTO) session.getAttribute("User_Infor");
		UserDTO userDTO = userService.findOneById(user1.getId());
		
		FacultyDTO facultyDTO = facultyService.findOneById(userDTO.getId_Faculty());
		String fa = facultyDTO.getFacultyName();

		
		_mvShare.addObject("product", new ProductDTO());
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("faculty1", fa);
		_mvShare.addObject("details_user", userDTO);
		_mvShare.addObject("comment", new Comment_PostDTO());
		_mvShare.setViewName("user/insertproduct");
		return _mvShare;
	}
	@RequestMapping(value = "user/insert-product")
	public ModelAndView InsertProduct(HttpSession session,@ModelAttribute("product")ProductDTO productDTO) {
		try {
			UserDTO user1 = (UserDTO) session.getAttribute("User_Infor");
			List<MultipartFile> file = productDTO.getFile();
			for(MultipartFile f : file) {
				if(!f.isEmpty()) {
					Map r= this.cloudinary.uploader().upload(f.getBytes(), ObjectUtils.asMap("resource_type","auto"));
					productDTO.setImage((String) r.get("secure_url"));
				}
			}
		productDTO.setUser_id(user1.getId());
		productService.save(productDTO);
		
		_mvShare.addObject("product", new ProductDTO());
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("comment", new Comment_PostDTO());
		_mvShare.setViewName("redirect:shop/"+user1.getId());
		
		return _mvShare;
		} catch (IOException e) {
			return null;
		}
		
	}
	@RequestMapping(value = "user/detailed-product/{id}")
	public ModelAndView DetailedProduct(@PathVariable("id") long id ,HttpSession session) {
		ProductDTO productDTO = productService.findOneById(id);
			
		_mvShare.addObject("detailedproduct", productDTO);
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("comment", new Comment_PostDTO());
		
		_mvShare.setViewName("user/detailedproduct");
		return _mvShare;
	
	}
	@RequestMapping(value = "user/addcart/{id}")
	public ModelAndView AddCart(HttpServletRequest httpServletRequest,@PathVariable("id") long id ,HttpSession session) {
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
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		
		_mvShare.setViewName("redirect:/user/shop/"+productDTO.getUser_id()); 
		return _mvShare;
	
	}
	@RequestMapping(value = "user/cart")
	public ModelAndView Cart(HttpSession session) {
		
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("comment", new Comment_PostDTO());
		
		_mvShare.setViewName("user/cart");
		return _mvShare;
	
	}
	@RequestMapping(value = "user/editcart/{id}/{quantity}")
	public ModelAndView EditCart(HttpServletRequest httpServletRequest,@PathVariable("id") long id ,@PathVariable("quantity") int quantity ,HttpSession session) {
		ProductDTO productDTO = productService.findOneById(id);
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		List<UserDTO> owner = (List<UserDTO>)session.getAttribute("OwnerList");
		if(cart ==null) {
			cart = new HashMap<Long, CartDTO>();
		}
		for(int i=0;i<owner.size();i++) {
			UserDTO user =owner.get(i);
			if(user.getId()==productDTO.getUser_id()) {
				owner.remove(i);
			}
		}
		 cart = cartService.EditCart(id, quantity,cart);
		
		 session.setAttribute("Cart", cart);
		 session.setAttribute("TotalPrice", cartService.TotalPrice( cart));
		 session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		
		_mvShare.setViewName("redirect:/user/cart"); 
		return _mvShare;
	
	}
	
	@RequestMapping(value = "user/deletecart/{id}")
	public ModelAndView DeleteCart(HttpServletRequest httpServletRequest,@PathVariable("id") long id ,HttpSession session) {
		ProductDTO productDTO = productService.findOneById(id);
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		if(cart ==null) {
			cart = new HashMap<Long, CartDTO>();
		}
		 cart = cartService.DeleteCart(id, cart);
		
		 session.setAttribute("Cart", cart);
		 session.setAttribute("TotalPrice", cartService.TotalPrice( cart));
		 session.setAttribute("TotalQuantity", cartService.TotalQuantity(cart));
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		
		_mvShare.setViewName("redirect:/user/cart"); 
		return _mvShare;
	
	}
	@RequestMapping(value = "user/checkout/{id}", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpSession session,@PathVariable("id") long id ) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		HashMap<Long, CartDTO> invoice = new HashMap<Long, CartDTO>(); 
		for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			if(itemCart.getValue().getProductDTO().getUser_id() == id)
				invoice.put(itemCart.getKey(), itemCart.getValue());
		}
		
		
		session.setAttribute("Invoice_user", invoice);
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("invoice", new InvoiceDTO());
		
		_mvShare.setViewName("user/checkout"); 
		return _mvShare;
	
	}
	@RequestMapping(value = "user/checkout", method = RequestMethod.POST)
	public ModelAndView CheckOut(HttpSession session,@ModelAttribute("invoice") InvoiceDTO invoiceDTO) {
		HashMap<Long, CartDTO> invoice = (HashMap<Long, CartDTO>)session.getAttribute("Invoice_user");
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		int quantity =0;
		double totalPrice = 0;
		long id =0;;
		for(Map.Entry<Long, CartDTO> itemCart : invoice.entrySet()) {
				if(cart.containsKey(itemCart.getKey())) {
					cart.remove(itemCart.getKey());
				}
				totalPrice += itemCart.getValue().getTotalPrice();
				quantity += itemCart.getValue().getQuantity();
				id =itemCart.getValue().getProductDTO().getUser_id();
		}
		UserDTO buyer = (UserDTO) session.getAttribute("User_Infor");
		
		invoiceDTO.setBuyer_id(buyer.getId());
		invoiceDTO.setOwner_id(id);
		invoiceDTO.setQuantity(quantity);
		invoiceDTO.setTotal(totalPrice);
		invoiceDTO.setPaymentmethod(0);
		invoiceDTO.setStatus(0);
		
		
		InvoiceDTO newInvoice = invoiceService.save(invoiceDTO);
		
		
		detailedInvoiceService.save(newInvoice.getId(), invoice);
		
		 session.setAttribute("Cart", cart);
		_mvShare.addObject("idOwner", id);
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("invoice", new InvoiceDTO());
		
		_mvShare.setViewName("redirect:/user/cart"); 
		return _mvShare;
	
	}
	@RequestMapping(value = "user/purchase-history")
	public ModelAndView History(HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("User_Infor");
		HashMap<Long, UserDTO> owner = new HashMap<Long, UserDTO>();
		
		List<InvoiceDTO> invoiceList = invoiceService.findAllByBuyer_id(user.getId());
		
		if(!invoiceList.isEmpty()) {
			for(InvoiceDTO item : invoiceList) {
				UserDTO owner_ = userService.findOneById(item.getOwner_id());
				owner.put(owner_.getId(),owner_);
			}
		}
		List<DetailedInvoiceDTO> detailedInvoiceDTOList = new ArrayList<DetailedInvoiceDTO>();
		for(InvoiceDTO item : invoiceList) {
			List<DetailedInvoiceDTO> details = detailedInvoiceService.findAllByInvoice_id(item.getId());
				for(DetailedInvoiceDTO detail : details) {
					detailedInvoiceDTOList.add(detail);
				}
		}
		List<ProductDTO> productDTOs = productService.findAll();
		
		_mvShare.addObject("productdetail", productDTOs);
		_mvShare.addObject("details", detailedInvoiceDTOList);
		_mvShare.addObject("owner", owner);
		_mvShare.addObject("invoice", invoiceList);
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.setViewName("user/purchasehistory");
		return _mvShare;
	}
	@RequestMapping(value = "user/selled")
	public ModelAndView Selled(HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("User_Infor");
		HashMap<Long, UserDTO> buyer = new HashMap<Long, UserDTO>();
		List<InvoiceDTO> invoiceList = invoiceService.findAllByOwner_id(user.getId());
		if(!invoiceList.isEmpty()) {
			for(InvoiceDTO item : invoiceList) {
				UserDTO buyer_ = userService.findOneById(item.getBuyer_id());
				buyer.put(buyer_.getId(),buyer_);
			}
			
		}
		List<DetailedInvoiceDTO> detailedInvoiceDTOList = new ArrayList<DetailedInvoiceDTO>();
		for(InvoiceDTO item : invoiceList) {
			List<DetailedInvoiceDTO> details = detailedInvoiceService.findAllByInvoice_id(item.getId());
				for(DetailedInvoiceDTO detail : details) {
					detailedInvoiceDTOList.add(detail);
				}
		}
		List<ProductDTO> productDTOs = productService.findAllByUser_id(user.getId());
		
		_mvShare.addObject("productdetail", productDTOs);
		_mvShare.addObject("details", detailedInvoiceDTOList);
		_mvShare.addObject("buyer", buyer);
		_mvShare.addObject("invoice", invoiceList);
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.setViewName("user/invoice");
		return _mvShare;
	}
}
