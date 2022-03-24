package Javaspring.com.Society.UserController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

import Javaspring.com.Society.DTO.CartDTO;
import Javaspring.com.Society.DTO.ChatDTO;
import Javaspring.com.Society.DTO.InvoiceDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.DetailedInvoiceService;
import Javaspring.com.Society.ServiceUser.InvoiceService;
import Javaspring.com.Society.ServiceUser.PaymentServiceImp;

@Controller
public class PaymentController extends BaseController{
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private DetailedInvoiceService detailedInvoiceService;
	
	@RequestMapping(value = "authorize_payment", method = RequestMethod.POST)
	public void Shop(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws IOException, ServletException {
		String address = request.getParameter("address");
		String note = request.getParameter("note");
		
		HashMap<Long, CartDTO> detailedInvoice = (HashMap<Long, CartDTO>)session.getAttribute("Invoice_user");
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
		int quantity =0;
		double totalPrice = 0;
		long id =0;;
		for(Map.Entry<Long, CartDTO> itemCart : detailedInvoice.entrySet()) {
				totalPrice += itemCart.getValue().getTotalPrice();
				quantity += itemCart.getValue().getQuantity();
				id =itemCart.getValue().getProductDTO().getUser_id();
		}
		UserDTO buyer = (UserDTO) session.getAttribute("User_Infor");
		
		try {
			PaymentServiceImp paymentServiceImp = new PaymentServiceImp();
			String approvalLink = paymentServiceImp.authorizePayment(detailedInvoice, buyer);
			response.sendRedirect(approvalLink);
			
		} catch (PayPalRESTException e) { 
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	
	}
	
	@RequestMapping(value = "user/review-payment")
	public ModelAndView reviewPayment(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws IOException, ServletException {
		String paymentId = request.getParameter("paymentId");
		String payerId = request.getParameter("PayerID");
		
		try {
			PaymentServiceImp paymentServiceImp = new PaymentServiceImp();
			Payment payment = paymentServiceImp.getPaymentDetails(paymentId);
			
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			
			Transaction transaction = payment.getTransactions().get(0);
			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
			
			HashMap<Long, CartDTO> invoice = (HashMap<Long, CartDTO>)session.getAttribute("Invoice_user");
			
			long id = 0;
			for(Map.Entry<Long, CartDTO> itemCart : invoice.entrySet()) {
				id = itemCart.getValue().getProductDTO().getUser_id();
		}
			
			
			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);
			request.setAttribute("shippingAddress", shippingAddress);
			
			_mvShare.addObject("idOwner", id);
			_mvShare.addObject("user_friend", new UserDTO());
			_mvShare.addObject("chat", new ChatDTO());
			_mvShare.addObject("user1", new UserDTO());
			_mvShare.setViewName("user/reviewpayment");
			return _mvShare;
			
		} catch (PayPalRESTException e) { 
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "user/execute_payment", method = RequestMethod.POST)
	public ModelAndView executePayment(HttpServletRequest request, HttpServletResponse response ,HttpSession session) throws ServletException, IOException  {
		String paymentId = request.getParameter("paymentId");
		String payerId = request.getParameter("PayerID");
		try {
			
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
			
			 
			PaymentServiceImp paymentServiceImp = new PaymentServiceImp();
			Payment payment = paymentServiceImp.executePayment(paymentId, payerId);
			
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
			
			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);
			
			UserDTO buyer = (UserDTO) session.getAttribute("User_Infor");
			InvoiceDTO invoiceDTO = new InvoiceDTO();
			invoiceDTO.setBuyer_id(buyer.getId());
			invoiceDTO.setOwner_id(id);
			invoiceDTO.setQuantity(quantity);
			invoiceDTO.setTotal(totalPrice);
			invoiceDTO.setAddress(shippingAddress.getLine1()+" "+shippingAddress.getCity()+" "+shippingAddress.getState());
			invoiceDTO.setPaymentmethod(1);
			invoiceDTO.setStatus(0);
			
			
			InvoiceDTO newInvoice = invoiceService.save(invoiceDTO);
			
			
			detailedInvoiceService.save(newInvoice.getId(), invoice);
			
			 session.setAttribute("Cart", cart);
			_mvShare.addObject("user_friend", new UserDTO());
			_mvShare.addObject("chat", new ChatDTO());
			_mvShare.addObject("user1", new UserDTO());
			_mvShare.setViewName("user/receipt");
			return _mvShare;
			
		} catch (PayPalRESTException e) { 
			e.printStackTrace();
			return null;
		}
		
	}
	
//	@RequestMapping(value = "user/error")
//	public ModelAndView Shop()  {
//		
//		_mvShare.addObject("chat", new ChatDTO());
//		_mvShare.addObject("user1", new UserDTO());
//		_mvShare.setViewName("user/error");
//		return _mvShare;
//	}
}
