package Javaspring.com.Society.UserController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import Javaspring.com.Society.DTO.ChatDTO;
import Javaspring.com.Society.DTO.Comment_PostDTO;
import Javaspring.com.Society.DTO.Image_postDTO;
import Javaspring.com.Society.DTO.Like_PostDTO;
import Javaspring.com.Society.DTO.PostDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.Comment_PostService;
import Javaspring.com.Society.ServiceUser.Image_PostService;
import Javaspring.com.Society.ServiceUser.Like_PostService;
import Javaspring.com.Society.ServiceUser.PostService;
import Javaspring.com.Society.ServiceUser.UserService;


@Controller
public class PostController extends BaseController{
	
	
	@Autowired
	private PostService postService ;
	@Autowired
	private Cloudinary cloudinary;
	@Autowired
	private Image_PostService image_PostService;
	@Autowired
	private Like_PostService like_PostService;
	@Autowired
	private Comment_PostService comment_PostService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/post",method = RequestMethod.POST )
	public ModelAndView post(HttpSession session,@ModelAttribute("Post") PostDTO post) {
	
		try {
		//Add post
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");		
		post.setUserID(users.getId());
		PostDTO postModel = postService.save(post);		
		if(postModel != null) {
			long idPost = postModel.getId();

			List<MultipartFile> file = post.getFile();
			
			
				//Add image
				for(MultipartFile f : file) {
					if(!f.isEmpty()) {
							Map r = this.cloudinary.uploader().upload(f.getBytes(), ObjectUtils.asMap("resource_type","auto"));
								
						Image_postDTO image_post = new Image_postDTO();
						image_post.setId_post(idPost);
						image_post.setImage((String) r.get("secure_url"));
						image_PostService.save(image_post);
					}
			}
			
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_mvShare.setViewName("redirect:home");
		return _mvShare;
	}
	
	@RequestMapping(value = "/user/edit-post", method = RequestMethod.POST)
	public ModelAndView editPost(HttpSession session,@ModelAttribute("edit_Post") PostDTO postDTO) {
		try {
			int check_image = 0;
			PostDTO oldPost = postService.findById(postDTO.getId());
			
			if(!postDTO.getContent().equals("")) {
				oldPost.setContent(postDTO.getContent());
			}
			PostDTO newPost = postService.save(oldPost);
			
			List<MultipartFile> file = postDTO.getFile();
			for(MultipartFile f : file) {
				if(!f.isEmpty()) {
					check_image++;
					
				}
			}
			
			if(check_image>0) {
				List<Image_postDTO> imageList = image_PostService.findAllByPost_id(newPost.getId());
				for(Image_postDTO image : imageList) {
					image_PostService.remove(image.getId());
				}
				for(MultipartFile f : file) {
					if(!f.isEmpty()) {
						Map r = this.cloudinary.uploader().upload(f.getBytes(), ObjectUtils.asMap("resource_type","auto"));
						Image_postDTO image_post = new Image_postDTO();
						image_post.setId_post(newPost.getId());
						image_post.setImage((String) r.get("secure_url"));
						image_PostService.save(image_post);
					}
				}
			}
			
			_mvShare.setViewName("redirect:detail-post/"+newPost.getId());
			return _mvShare;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				_mvShare.setViewName("redirect:home");
				return _mvShare;
			}
		
	}
	@RequestMapping(value = "/user/detail-post/{postid}")
	public ModelAndView DetailPost(@PathVariable("postid") long id,HttpSession session) {
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		PostDTO detailPost = postService.findById(id);
		List<Image_postDTO> imageList = image_PostService.findAllByPost_id(id);
		
		//like-comment
		List<Like_PostDTO> amount = like_PostService.findAllByIdPost(detailPost.getId());
		List<Comment_PostDTO> amount_comment = comment_PostService.findAllByPostid(detailPost.getId());
		detailPost.setAmount(amount.size());
		detailPost.setAmountComment(amount_comment.size());
				List<Like_PostDTO> listLike =  like_PostService.findAllByIdUser(users.getId());
				for(Like_PostDTO like : listLike) {
						if(like.getIdpost() == detailPost.getId()) {
							detailPost.setStatus(1);
						
					}
				}
				
				//comment
				List<Comment_PostDTO> commentList = comment_PostService.findAll();
				List<UserDTO> userList = userService.findALl();
				for(UserDTO user : userList) {
					for(int i =0; i< commentList.size();i++) {
						Comment_PostDTO comment = commentList.get(i);
						if(user.getId() ==  comment.getUser_id()) {
							commentList.get(i).setNameUser(user.getName());
							commentList.get(i).setAvatarUser(user.getAvatar());
						}
					}
				}
		_mvShare.addObject("user1", new UserDTO());		
		_mvShare.addObject("user_friend", new UserDTO());		
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("edit_Post", new PostDTO());
		_mvShare.addObject("like", new Like_PostDTO());
		_mvShare.addObject("comment", new Comment_PostDTO());
		_mvShare.addObject("detail_Post", detailPost);
		_mvShare.addObject("detail_Image", imageList);
		_mvShare.setViewName("user/detailPost");
		return _mvShare;
	}
}
