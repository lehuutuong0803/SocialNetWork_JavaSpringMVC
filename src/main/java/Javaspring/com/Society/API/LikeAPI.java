package Javaspring.com.Society.API;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Javaspring.com.Society.DTO.Like_PostDTO;
import Javaspring.com.Society.DTO.PostDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.Like_PostService;

@RestController(value = "likeAPIOfAdmin")
public class LikeAPI {
	
	@Autowired
	private Like_PostService like_PostService;
	
	@PostMapping("/api/like")
	public PostDTO likePost(@RequestBody Like_PostDTO like_PostDTO,HttpSession session) {
		PostDTO export = new PostDTO();
		UserDTO userDTO =  (UserDTO) session.getAttribute("User_Infor");
		List<Like_PostDTO> listCheck = like_PostService.findAllByIdPost(like_PostDTO.getIdpost());
		like_PostDTO.setLikeiduser(userDTO.getId());
		int check =0;
		Like_PostDTO unlike = new Like_PostDTO();
		
		for(Like_PostDTO item : listCheck) {
			if(item.getLikeiduser() == userDTO.getId()) {
				check++;
				unlike= item;
			}
		}
		
		if(check == 0) {
			like_PostService.save(like_PostDTO);
			export.setStatus(0);
		}else {
			like_PostService.delete(unlike.getId());
			export.setStatus(1);
		}
		export.setId(like_PostDTO.getIdpost());
		
		
		List<Like_PostDTO> list = like_PostService.findAllByIdPost(like_PostDTO.getIdpost());
		 export.setAmount(list.size());
		 
		session.setAttribute("position", export.getId());
		return export;
	}
}
