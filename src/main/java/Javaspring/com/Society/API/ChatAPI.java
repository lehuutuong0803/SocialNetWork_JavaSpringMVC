package Javaspring.com.Society.API;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Javaspring.com.Society.DTO.ChatDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.ChatService;
import Javaspring.com.Society.ServiceUser.UserService;

@RestController (value = "chatAPIOfAdmin")
public class ChatAPI {
	@Autowired
	private ChatService chatService; 
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/chat")
	public List<ChatDTO> displayBox(@RequestBody ChatDTO chatDTO,HttpSession session) {
		List<ChatDTO> chatList = chatService.findAllByBox_id(chatDTO.getBox_id());
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		
		String pattern = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(pattern);  
		for(int i =0;i<chatList.size();i++) {
			
			if(users.getId() != chatList.get(i).getSource_id()) {
				UserDTO friend = userService.findOneById(chatList.get(i).getSource_id());
				chatList.get(i).setUser_avatar(users.getAvatar());
				chatList.get(i).setFriend_avatar(friend.getAvatar());
				chatList.get(i).setDate(df.format(chatList.get(i).getCreateAt()));
			}else {
				UserDTO friend = userService.findOneById(chatList.get(i).getSource_id());
				chatList.get(i).setUser_avatar(users.getAvatar());
				chatList.get(i).setFriend_avatar(friend.getAvatar());
				chatList.get(i).setDate(df.format(chatList.get(i).getCreateAt()));
			}
		}
		
		return chatList;
	}
}
