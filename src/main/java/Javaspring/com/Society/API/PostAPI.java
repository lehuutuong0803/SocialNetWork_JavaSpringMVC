package Javaspring.com.Society.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Javaspring.com.Society.DTO.PostDTO;
import Javaspring.com.Society.ServiceUser.Comment_PostService;
import Javaspring.com.Society.ServiceUser.Image_PostService;
import Javaspring.com.Society.ServiceUser.Like_PostService;
import Javaspring.com.Society.ServiceUser.PostService;

@RestController(value = "PostAPIOfAdmin")
public class PostAPI {
	@Autowired
	private Like_PostService like_PostService;
	@Autowired
	private Comment_PostService comment_PostService;
	@Autowired
	private PostService postService;
	@Autowired
	private Image_PostService image_PostService;
	
	@DeleteMapping("/api/post")
	public void deletePost(@RequestBody PostDTO postDTO) {
		like_PostService.deleteAllByPostId(postDTO.getId());
		comment_PostService.deleteAllByPostId(postDTO.getId());
		image_PostService.deleteAllByPostId(postDTO.getId());
		postService.delete(postDTO.getId());
	}
	
		
}
