package Javaspring.com.Society.API;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Javaspring.com.Society.DTO.Comment_PostDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.Comment_PostService;
import Javaspring.com.Society.ServiceUser.UserService;

@RestController(value = "CommentAPIOfAdmin")
public class CommentAPI {
	@Autowired
	private Comment_PostService comment_PostService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/comment")
	public List<Comment_PostDTO> commentPost(@RequestBody Comment_PostDTO  comment_PostDTO){
		comment_PostService.save(comment_PostDTO);
		
		List<Comment_PostDTO> commentList = new ArrayList<Comment_PostDTO>();
		commentList = comment_PostService.findAllByPostid(comment_PostDTO.getPost_id());
		List<UserDTO> userList = userService.findALl();
		
		String pattern = "yyyy-MM-dd";
		DateFormat df = new SimpleDateFormat(pattern);  
		for(UserDTO user : userList) {
			for(int i =0; i< commentList.size();i++) {
				Comment_PostDTO comment = commentList.get(i);
				if(user.getId() ==  comment.getUser_id()) {
					commentList.get(i).setNameUser(user.getName());
					commentList.get(i).setAvatarUser(user.getAvatar());
					commentList.get(i).setDate(df.format(commentList.get(i).getCreateAt()));
				}
			}
		}
		
		
		return commentList;
	}
	
}
