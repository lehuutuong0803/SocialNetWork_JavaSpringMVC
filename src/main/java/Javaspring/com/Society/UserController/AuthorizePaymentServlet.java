package Javaspring.com.Society.UserController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import Javaspring.com.Society.DTO.CartDTO;
import Javaspring.com.Society.DTO.InvoiceDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.PaymentServiceImp;


//@WebServlet("/authorize_payment")
//public class AuthorizePaymentServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//
//    public AuthorizePaymentServlet() {
//        super();
//    }
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String address = request.getParameter("address");
//		String note = request.getParameter("note");
//		
////		HashMap<Long, CartDTO> invoice = (HashMap<Long, CartDTO>)session.getAttribute("Invoice_user");
////		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart");
////		int quantity =0;
////		double totalPrice = 0;
////		long id =0;;
////		for(Map.Entry<Long, CartDTO> itemCart : invoice.entrySet()) {
////				if(cart.containsKey(itemCart.getKey())) {
////					cart.remove(itemCart.getKey());
////				}
////				totalPrice += itemCart.getValue().getTotalPrice();
////				quantity += itemCart.getValue().getQuantity();
////				id =itemCart.getValue().getProductDTO().getUser_id();
////		}
////		UserDTO buyer = (UserDTO) session.getAttribute("User_Infor");
////		InvoiceDTO invoiceDTO = new InvoiceDTO();
////		invoiceDTO.setBuyer_id(buyer.getId());
////		invoiceDTO.setOwner_id(id);
////		invoiceDTO.setQuantity(quantity);
////		invoiceDTO.setTotal(totalPrice);
////		invoiceDTO.setAddress(address);
////		invoiceDTO.setNote(note);
//		InvoiceDTO invoiceDTO = new InvoiceDTO();
//		invoiceDTO.setBuyer_id(1);
//		invoiceDTO.setOwner_id(1);
//		invoiceDTO.setQuantity(3);
//		invoiceDTO.setTotal(123);
//		invoiceDTO.setAddress(address);
//		invoiceDTO.setNote(note);
//		
//		try {
//			PaymentServiceImp paymentServiceImp = new PaymentServiceImp();
//			String approvalLink = paymentServiceImp.authorizePayment(invoiceDTO);
//			response.sendRedirect(approvalLink);
//			
//		} catch (PayPalRESTException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
