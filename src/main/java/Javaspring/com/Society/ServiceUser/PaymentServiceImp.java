package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import Javaspring.com.Society.DTO.CartDTO;
import Javaspring.com.Society.DTO.InvoiceDTO;
import Javaspring.com.Society.DTO.UserDTO;

@Service
public class PaymentServiceImp implements PaymentService{
	
	@Autowired
	private UserService userService = new UserServiceImp();
	
	private static final String CLIENT_ID = "Ad1LoBeuGiB5ZIbc7Jq-cLkg_ovLUSI2-gcNHJKDstZm50I5fi5FC4SIM4bsZqcHX_ntc774_Xf8yG5u";
	private static final String CLIENT_SECRET = "EEgZNqKwz76_2elJigsDkS4b2yvbFs6Ar2aHwNpL2HF60eswJkY9v4-L7lQQ7-CSTtaau0hvv3OXtPjD";
	private static final String MODE = "sandbox";
	
	public String authorizePayment(HashMap<Long, CartDTO> detailedInvoice, UserDTO buyer) throws PayPalRESTException {
		Payer payer = getPayerInfomation(detailedInvoice, buyer);
		RedirectUrls redirectUrls =	 getRedirectURLs();
		List<Transaction> listTransaction = getTransactionInformation(detailedInvoice, buyer);
		
		Payment requestPayment = new Payment();
		requestPayment.setTransactions(listTransaction)
					  .setRedirectUrls(redirectUrls)
					  .setPayer(payer)
					  .setIntent("authorize");
		APIContext apiContext = new APIContext(CLIENT_ID,CLIENT_SECRET,MODE);
		
		Payment approvedPayment = requestPayment.create(apiContext);
		System.out.println(approvedPayment);
		
		return getAprovalLink(approvedPayment);
	}
	private String getAprovalLink(Payment approvedPayment) {
		 List<Links> links = approvedPayment.getLinks();
		    String approvalLink = null;
		     
		    for (Links link : links) {
		        if (link.getRel().equalsIgnoreCase("approval_url")) {
		            approvalLink = link.getHref();
		            break;
		        }
		    }      
		     
		    return approvalLink;
	}
	
	private List<Transaction> getTransactionInformation(HashMap<Long, CartDTO> detailedInvoice, UserDTO buyer){
		float usd = 20000;
		int quantity =0;
		double totalPrice = 0;
		long id =0;;
		float tax = 0;
		for(Map.Entry<Long, CartDTO> itemCart : detailedInvoice.entrySet()) {
				totalPrice += itemCart.getValue().getTotalPrice();
				quantity += itemCart.getValue().getQuantity();
				id =itemCart.getValue().getProductDTO().getUser_id();
		}
		double totalPrice_USD = totalPrice/usd;
		String n = String.format("%.2f", totalPrice_USD);
		System.out.println("Checkllllllllll: "+n);
		 Details details = new Details();
		    details.setShipping("10.00");
		    details.setSubtotal(String.format("%.2f", totalPrice_USD));	
//		    details.setTax("10.00");
		 
		    Amount amount = new Amount();
		    amount.setCurrency("USD");
		    amount.setTotal(String.format("%.2f", (totalPrice_USD+10.00)));
		    amount.setDetails(details);
		 
		    Transaction transaction = new Transaction();
		    transaction.setAmount(amount);
		    transaction.setDescription("Invoice");
		     
		    ItemList itemList = new ItemList();
		    List<Item> items = new ArrayList<>();
		     
			for(Map.Entry<Long, CartDTO> itemCart : detailedInvoice.entrySet()) {
				double price_USD = itemCart.getValue().getTotalPrice()/usd;
				String x = String.format("%.2f", price_USD);
				System.out.println("Checkllllllllll: "+x);
				Item item = new Item();
			    item.setCurrency("USD");
			    item.setName(itemCart.getValue().getProductDTO().getProduct_name());
			    item.setPrice(String.format("%.2f", price_USD));
//			    item.setTax("10.00");
			    item.setQuantity(String.valueOf(itemCart.getValue().getQuantity()));
			    items.add(item);
			}
		    
		     
		    
		    itemList.setItems(items);
		    transaction.setItemList(itemList);
		 
		    List<Transaction> listTransaction = new ArrayList<>();
		    listTransaction.add(transaction);  
		     
		    return listTransaction;
		
	}

	private RedirectUrls getRedirectURLs() {
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:8080/HutechSocialNetwork/user/cancel");
		redirectUrls.setReturnUrl("http://localhost:8080/HutechSocialNetwork/user/review-payment");
		return redirectUrls;
	}
	
	public Payment getPaymentDetails(String paymentID) throws PayPalRESTException {
		APIContext apiContext = new APIContext(CLIENT_ID,CLIENT_SECRET,MODE);
		return Payment.get(apiContext,paymentID);
		
	}
	
	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);
		
		Payment payment = new Payment().setId(paymentId);
		APIContext apiContext = new APIContext(CLIENT_ID,CLIENT_SECRET,MODE);
		return payment.execute(apiContext, paymentExecution);
		
	}
	
	private Payer getPayerInfomation(HashMap<Long, CartDTO> detailedInvoice, UserDTO buyer) {
		  Payer payer = new Payer();
		    payer.setPaymentMethod("paypal");
		     
		    PayerInfo payerInfo = new PayerInfo();
		    payerInfo.setFirstName(buyer.getName())
		             .setEmail(buyer.getEmail());
		     
		    payer.setPayerInfo(payerInfo);
		     
		    return payer;
	}
}
