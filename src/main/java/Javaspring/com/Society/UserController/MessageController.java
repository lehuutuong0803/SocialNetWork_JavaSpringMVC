package Javaspring.com.Society.UserController;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import Javaspring.com.Society.DTO.ChatDTO;
import Javaspring.com.Society.DTO.InvoiceDTO;
import Javaspring.com.Society.DTO.Message;
import Javaspring.com.Society.DTO.NotificationDTO;
import Javaspring.com.Society.DTO.Notify;
import Javaspring.com.Society.DTO.OutputMessage;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.ChatService;
import Javaspring.com.Society.ServiceUser.InvoiceService;
import Javaspring.com.Society.ServiceUser.UserService;

@Controller
public class MessageController {
	@Autowired
	private ChatService chatService;
	@Autowired
	private UserService userService;
	@Autowired
	private InvoiceService invoiceService;
	
    @MessageMapping("/chat")
    @SendTo("/topic/messages1")
    public OutputMessage send(Message message) throws Exception {
    	ChatDTO chatDTO = new ChatDTO();
    	chatDTO.setSource_id(Long.parseLong(message.getUserid()));
    	chatDTO.setTarget_id(Long.parseLong(message.getFriendid()));
    	chatDTO.setBox_id(Long.parseLong(message.getBoxid()));
    	chatDTO.setContent(message.getContent());
    	long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
    	chatDTO.setCreateAt(date);
    	chatService.save(chatDTO);
    	
    	UserDTO user = userService.findOneById(Long.parseLong(message.getUserid()));
    	UserDTO friend = userService.findOneById(Long.parseLong(message.getFriendid()));
    	
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getUserid(), message.getFriendid(),message.getBoxid(),message.getContent(),user.getAvatar(),friend.getAvatar(), time);
    }
    
    @MessageMapping("/noti")
    @SendTo("/topic/notification")
    public NotificationDTO inform(Notify notify) throws Exception {
    	
        return new NotificationDTO(notify.getUserid(),notify.getUsername_buyer());
    }
    
    @MessageMapping("/verifyInvocie")
    @SendTo("/topic/verification")
    public NotificationDTO verify(Notify notify) throws Exception {
    	InvoiceDTO invoiceDTO = invoiceService.findOneById(Long.parseLong(notify.getInvoiceid()));
    	invoiceService.save(invoiceDTO);
    	
        return new NotificationDTO(notify.getUserid(),notify.getUsername_buyer(),notify.getInvoiceid());
    }
}
