package Javaspring.com.Society.UserController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
import Javaspring.com.Society.DTO.FacultyDTO;
import Javaspring.com.Society.DTO.FriendDTO;
import Javaspring.com.Society.DTO.Image_postDTO;
import Javaspring.com.Society.DTO.Like_PostDTO;
import Javaspring.com.Society.DTO.PostDTO;
import Javaspring.com.Society.DTO.SearchDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.Comment_PostService;
import Javaspring.com.Society.ServiceUser.FacultyService;
import Javaspring.com.Society.ServiceUser.FriendService;
import Javaspring.com.Society.ServiceUser.Image_PostService;
import Javaspring.com.Society.ServiceUser.Like_PostService;
import Javaspring.com.Society.ServiceUser.PostService;
import Javaspring.com.Society.ServiceUser.UserService;

@Controller
public class AccountController extends BaseController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private PostService postService;
	@Autowired
	private Image_PostService image_PostService;
	@Autowired
	private FriendService friendService;
	@Autowired
	private Like_PostService like_PostService;
	@Autowired
	private Comment_PostService comment_PostService;
	@Autowired
	private Cloudinary cloudinary;
	
	@RequestMapping(value = "user/about/{userid}")
	public ModelAndView About(@PathVariable("userid") long id ,HttpSession session) {
		UserDTO userDTO = userService.findOneById(id);
		FacultyDTO facultyDTO = facultyService.findOneById(userDTO.getId_Faculty());
		String fa = facultyDTO.getFacultyName();
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("faculty1", fa);
		_mvShare.addObject("details_user", userDTO);
		_mvShare.setViewName("user/about");
		return _mvShare;
	}
	
	@RequestMapping(value = "user/time-line/{userid}")
	public ModelAndView TimeLine(@PathVariable("userid") long id ,HttpSession session) {
		UserDTO user1 = (UserDTO) session.getAttribute("User_Infor");
		
		UserDTO userDTO = userService.findOneById(id);
		FacultyDTO facultyDTO = facultyService.findOneById(userDTO.getId_Faculty());
		List<PostDTO> listPost = postService.findAllByUserid(userDTO.getId());
		String fa = facultyDTO.getFacultyName();
		List<Image_postDTO> listImage = image_PostService.findAll();
		//sum like, comment
		for(int i =0; i<listPost.size();i++) {
				List<Like_PostDTO> amount = like_PostService.findAllByIdPost(listPost.get(i).getId());
				List<Comment_PostDTO> amount_comment = comment_PostService.findAllByPostid(listPost.get(i).getId());
				listPost.get(i).setAmount(amount.size());
				listPost.get(i).setAmountComment(amount_comment.size());
		}
		

		//like
		List<Like_PostDTO> listLike =  like_PostService.findAllByIdUser(user1.getId());
		for(Like_PostDTO like : listLike) {
			for(int i=0; i< listPost.size();i++) {
				PostDTO post = listPost.get(i);
				if(like.getIdpost() == post.getId()) {
					listPost.get(i).setStatus(1);
				}
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
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("commet_Post", commentList);
		_mvShare.addObject("myLike", listLike);
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("list_Image", listImage);
		_mvShare.addObject("list_Post", listPost);
		_mvShare.addObject("faculty1", fa);
		_mvShare.addObject("details_user", userDTO);
		_mvShare.addObject("Post", new PostDTO());
		_mvShare.addObject("edit_Post", new PostDTO());
		_mvShare.addObject("like", new Like_PostDTO());
		_mvShare.addObject("comment", new Comment_PostDTO());
		_mvShare.setViewName("user/timeline");
		return _mvShare;
	}
	@RequestMapping(value = "user/edit-avatar",method = RequestMethod.POST)
	public ModelAndView Edit_Avatar(HttpSession session,@ModelAttribute("user1") UserDTO userDTO) {
		
		try {
			UserDTO newUser = userService.findOneById(userDTO.getId());
		MultipartFile[] file = userDTO.getFile();
		for(MultipartFile f : file) {
			if(!f.isEmpty()) {
				Map r = this.cloudinary.uploader().upload(f.getBytes(), ObjectUtils.asMap("resource_type","auto"));
				
				newUser.setAvatar((String) r.get("secure_url"));
			}
		}
		session.setAttribute("User_Infor", newUser);
		userService.update(newUser);
		_mvShare.setViewName("redirect:time-line/"+newUser.getId());
		return _mvShare;
		
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value = "user/friends-of/{userid}", method = RequestMethod.GET)
	public ModelAndView TimeLine_Friends(@PathVariable("userid") long id ,HttpSession session) {
		UserDTO userDTO = userService.findOneById(id);
		FacultyDTO facultyDTO = facultyService.findOneById(userDTO.getId_Faculty());
		List<FacultyDTO> listFacultyDTOs = facultyService.getAll();
		String fa = facultyDTO.getFacultyName();
		//MyFriend
		List<UserDTO> myFriend = new ArrayList<UserDTO>();
		List<UserDTO> allUser = userService.findALl();
		List<FriendDTO> source = friendService.findAllBySource(userDTO.getId());
		List<FriendDTO> target = friendService.findAllByTarget(userDTO.getId());

		for(int  i = 0; i < allUser.size();i++) {
			UserDTO u = allUser.get(i);
			
			for(int s =0; s<source.size();s++ ) {
				FriendDTO sx = source.get(s);
				if(u.getId() == sx.getTargetId() && sx.getStatus() == 1) {
					myFriend.add(u);
				}
				
			}
			for(int t =0; t  < target.size();t++ ) {
				FriendDTO tx = target.get(t);
				if(u.getId() == tx.getSourceId() && tx.getStatus() == 1) {
					myFriend.add(u);
				}
			}

		}
	
		List<FacultyDTO> facultyls = facultyService.getAll();
		Map<String,String> fac = new LinkedHashMap<String,String>();
		for(FacultyDTO item : facultyls) {
			fac.put(String.valueOf(item.getId()) , item.getFacultyName());	
		}
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("search", new SearchDTO());
		_mvShare.addObject("_Faculty",fac);
		_mvShare.addObject("listFaculty", fac);
		_mvShare.addObject("myFriend", myFriend);
		_mvShare.addObject("faculty1", fa);
		_mvShare.addObject("details_user", userDTO);
		_mvShare.setViewName("user/timelineFriend");
		return _mvShare;
	}
	
	@RequestMapping(value = "user/friends-of/{userid}",method = RequestMethod.POST)
	public ModelAndView Search_Friends(@PathVariable("userid") long id ,HttpSession session,@ModelAttribute("search") SearchDTO searchDTO) {
		UserDTO userDTO = userService.findOneById(id);
		FacultyDTO facultyDTO = facultyService.findOneById(userDTO.getId_Faculty());
		List<FacultyDTO> listFacultyDTOs = facultyService.getAll();
		String fa = facultyDTO.getFacultyName();
		//MyFriend
		List<UserDTO> myFriend = new ArrayList<UserDTO>();
		List<UserDTO> allUser = userService.findALl();
		List<FriendDTO> source = friendService.findAllBySource(userDTO.getId());
		List<FriendDTO> target = friendService.findAllByTarget(userDTO.getId());
	
		
		for(int  i = 0; i < allUser.size();i++) {
			UserDTO u = allUser.get(i);
			
			for(int s =0; s<source.size();s++ ) {
				FriendDTO sx = source.get(s);
				if(u.getId() == sx.getTargetId() && sx.getStatus() == 1) {
					myFriend.add(u);
				}
				
			}
			for(int t =0; t  < target.size();t++ ) {
				FriendDTO tx = target.get(t);
				if(u.getId() == tx.getSourceId() && tx.getStatus() == 1) {
					myFriend.add(u);
				}
			}

		}
		String str = unAccent(searchDTO.getValue());
		List<UserDTO> searchs = new ArrayList<UserDTO>();
		for(UserDTO item : myFriend) {
			String check = unAccent(item.getName());
			if(check.toLowerCase().trim().contains(str.toLowerCase().trim().toString())) {
				searchs.add(item);
			}
		}
		
		List<FacultyDTO> facultyls = facultyService.getAll();
		Map<String,String> fac = new LinkedHashMap<String,String>();
		for(FacultyDTO item : facultyls) {
			fac.put(String.valueOf(item.getId()) , item.getFacultyName());	
		}
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("_Faculty",fac);
		_mvShare.addObject("listFaculty", fac);
		_mvShare.addObject("myFriend", searchs);
		_mvShare.addObject("faculty1", fa);
		_mvShare.addObject("details_user", userDTO);
		_mvShare.setViewName("user/timelineFriend");
		return _mvShare;
	}
	@RequestMapping(value = "user/search")
	public ModelAndView Search(@ModelAttribute("user_friend") UserDTO userDTO, HttpSession session) {
		List<UserDTO> allUser = userService.findALl();
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		List<UserDTO>  myFriend = (List<UserDTO>) session.getAttribute("MyFriend");
		
		String str = unAccent(userDTO.getName());
		List<UserDTO> searchs = new ArrayList<UserDTO>();
		
		for(UserDTO item : allUser) {
			String check = unAccent(item.getName());
			if(check.toLowerCase().trim().contains(str.toLowerCase().trim().toString())) {
				searchs.add(item);
			}
		}
		

			for(int i =0;i<searchs.size();i++) {
				UserDTO u = searchs.get(i);
				if(users.getId() == u.getId()) {
					searchs.remove(i);
					i = 0;
				}
			}
		
		
		for(int i =0;i<searchs.size();i++) {
			UserDTO user = searchs.get(i);
			for(UserDTO u : myFriend) {
				if(u.getId() == user.getId()) {
					searchs.get(i).setStatus(1);
				}
			}
		}
		List<FriendDTO> source = friendService.findAllBySource(users.getId());
		List<FriendDTO> target = friendService.findAllByTarget(users.getId());
	
		for(int  i = 0; i < searchs.size();i++) {
			UserDTO u = searchs.get(i);
			
			for(int s =0; s<source.size();s++ ) {
				FriendDTO sx = source.get(s);
				if(u.getId() == sx.getTargetId() && sx.getStatus() == 0) {
					searchs.get(i).setStatus(2);
				}
				
			}
			for(int t =0; t  < target.size();t++ ) {
				FriendDTO tx = target.get(t);
				if(u.getId() == tx.getSourceId() && tx.getStatus() == 0) {
					searchs.get(i).setStatus(3);
				}
			}

		}
		

		List<FacultyDTO> facultyls = facultyService.getAll();
		Map<String,String> fac = new LinkedHashMap<String,String>();
		for(FacultyDTO item : facultyls) {
			fac.put(String.valueOf(item.getId()) , item.getFacultyName());	
		}
		
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("listFaculty", fac);
		_mvShare.addObject("result_search", searchs);
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.setViewName("user/search");
		return _mvShare;
	}
	@RequestMapping(value = "user/addfriend-page")
	public ModelAndView Addfriend_Page(HttpSession session) {
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		
		List<FriendDTO> target = friendService.findAllByTarget(users.getId());
		List<UserDTO> friendList = new ArrayList<UserDTO>();
		
		for(FriendDTO f : target) {
			if(f.getStatus() ==0) {
				UserDTO u = userService.findOneById(f.getSourceId());
				friendList.add(u);
			}
			
		}
		
		List<FacultyDTO> facultyls = facultyService.getAll();
		Map<String,String> fac = new LinkedHashMap<String,String>();
		for(FacultyDTO item : facultyls) {
			fac.put(String.valueOf(item.getId()) , item.getFacultyName());	
		}
		
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("result_search", friendList);
		_mvShare.addObject("listFaculty", fac);
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.setViewName("user/addfriend");
		return _mvShare;
	}
}
