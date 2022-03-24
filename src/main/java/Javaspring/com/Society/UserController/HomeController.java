package Javaspring.com.Society.UserController;


import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Javaspring.com.Society.DTO.ChatDTO;
import Javaspring.com.Society.DTO.Comment_PostDTO;
import Javaspring.com.Society.DTO.FacultyDTO;
import Javaspring.com.Society.DTO.FriendDTO;
import Javaspring.com.Society.DTO.Image_postDTO;
import Javaspring.com.Society.DTO.Like_PostDTO;
import Javaspring.com.Society.DTO.PostDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.DTO.VideoCallDTO;
import Javaspring.com.Society.ServiceUser.ChatService;
import Javaspring.com.Society.ServiceUser.Comment_PostService;
import Javaspring.com.Society.ServiceUser.FacultyService;
import Javaspring.com.Society.ServiceUser.FriendService;
import Javaspring.com.Society.ServiceUser.Image_PostService;
import Javaspring.com.Society.ServiceUser.Like_PostService;
import Javaspring.com.Society.ServiceUser.PostService;
import Javaspring.com.Society.ServiceUser.UserService;
import Javaspring.com.Society.ServiceUser.VideoCallService;


@Controller
public class HomeController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private FriendService friendService;
	@Autowired
	private PostService postService;
	@Autowired
	private Image_PostService image_PostService;
	@Autowired
	private Like_PostService like_PostService;
	@Autowired
	private Comment_PostService comment_PostService;
	@Autowired
	private ChatService chatService;
	@Autowired
	private VideoCallService videoCallService;
	
	//Home
	@RequestMapping(value = "/user/home", method = RequestMethod.GET)
	public ModelAndView Home(HttpSession session) {
		
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		@SuppressWarnings("unchecked")
		List<UserDTO> myFriend = (List<UserDTO>) session.getAttribute("MyFriend");
		//classmate
		List<UserDTO> proposeFriend = new ArrayList<UserDTO>();
		List<UserDTO> friend_faculty = userService.findFacultyID(users.getId_Faculty());
		List<FriendDTO> source = friendService.findAllBySource(users.getId());
		List<FriendDTO> target = friendService.findAllByTarget(users.getId());
		
		//Suggest friend
		int size = friend_faculty.size();
		for(int  i = 0; i < size;i++) {
			UserDTO u = friend_faculty.get(i);
			
			for(int s =0; s<source.size();s++ ) {
				FriendDTO sx = source.get(s);
				if(u.getId() == sx.getTargetId()) {
					friend_faculty.remove(u);
					size = friend_faculty.size();
					i=-1;
				}
				
			}
			for(int t =0; t  < target.size();t++ ) {
				FriendDTO tx = target.get(t);
				if(u.getId() == tx.getSourceId()) {
					friend_faculty.remove(u);
					size = friend_faculty.size();
					i=-1;
				} 
			}
			if(u.getId() == users.getId()) {
				friend_faculty.remove(u);
				size = friend_faculty.size();
				i=-1;
			}
		}
		Collections.shuffle(friend_faculty);
		if(friend_faculty.size() >=5) {
			for(int i = 0; i<5; i++) {
				proposeFriend.add(friend_faculty.get(i));
			}
		}
		if(friend_faculty.size() <5 && friend_faculty.size()>0) {
			for(int i = 0; i<1; i++) {
				proposeFriend.add(friend_faculty.get(i));
			}
		}
		//Post
		List<PostDTO> listPostAll = postService.findAll();
		List<PostDTO> friend_post = new ArrayList<PostDTO>();

			//delete_residual
		int size_users = myFriend.size();
		for(int  i = 0; i < size_users;i++) {
			UserDTO u = myFriend.get(i);
			if(u.getId() == users.getId()) {
				myFriend.remove(u);
				size_users = myFriend.size();
				i=-1;
			}
			
		}
		myFriend.add(users);
		
		
		//check
		if(myFriend.size()==1) {
			List<PostDTO> listPost = postService.findAllByUserid(myFriend.get(0).getId());
			for(PostDTO post : listPost) {
				List<Like_PostDTO> amount = like_PostService.findAllByIdPost(post.getId());
				List<Comment_PostDTO> amount_comment = comment_PostService.findAllByPostid(post.getId());
				post.setAmount(amount.size());
				post.setAmountComment(amount_comment.size());
				friend_post.add(post);
			}
		
		}
		else{
			for(UserDTO user : myFriend) {
				for(PostDTO post : listPostAll) {
					if(user.getId() == post.getUserID()) {
						List<Like_PostDTO> amount = like_PostService.findAllByIdPost(post.getId());
						List<Comment_PostDTO> amount_comment = comment_PostService.findAllByPostid(post.getId());
						post.setAmount(amount.size());
						post.setAmountComment(amount_comment.size());
						friend_post.add(post);
					}
				}
			}
		}
		
		
		//sort posts
		int s = friend_post.size()-1;
		Collections.shuffle(friend_post);
		if(s >0) {
			 PostDTO temp = friend_post.get(s);
		        for (int i = 0  ; i < s; i++) {
		            for (int j = i + 1; j <=s; j++) {	
		            	Date date1 = friend_post.get(i).getCreateAt();	  
		            	Date date2 = friend_post.get(j).getCreateAt();
		                if (date1.before(date2)) {
		                    temp = friend_post.get(j);
		                    friend_post.set(j, friend_post.get(i)) ;
		                    friend_post.set(i, temp);
		                }
		            }
		          }
		}
		
		
		List<Image_postDTO> listImage = image_PostService.findAll();
		
		//like
		List<Like_PostDTO> listLike =  like_PostService.findAllByIdUser(users.getId());
		for(Like_PostDTO like : listLike) {
			for(int i=0; i< friend_post.size();i++) {
				PostDTO post = friend_post.get(i);
				if(like.getIdpost() == post.getId()) {
					friend_post.get(i).setStatus(1);
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
		
		//birthday
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		String d = formatter.format(date);
		String[] abc = d.split("-");
		String current =  abc[2]+"-"+abc[1];
		
		List<UserDTO> birthday_User = new ArrayList<UserDTO>();
		for(UserDTO user : myFriend) {
			Format formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			String a = formatter1.format(user.getBirthday());
			String[] xyz = a.split("-");
			String birthday =  xyz[2]+"-"+xyz[1];
			int age = Integer.parseInt(abc[0]) -Integer.parseInt(xyz[0]);
			if(birthday.equals(current)) {
				user.setBirthday_string(birthday);
				user.setAge(age);
				birthday_User.add(user);
			}
		}
		//Check roomcode
		List<VideoCallDTO> videoCallDTOs = videoCallService.findAll();
		for(VideoCallDTO videocall : videoCallDTOs) {
			Format formatter1 = new SimpleDateFormat("yyyy-MM-dd");
			String a = formatter1.format(videocall.getCreateAt());
			String[] xyz = a.split("-");
			String createAt =  xyz[2]+"-"+xyz[1];
			int check = Integer.parseInt(abc[2]) -Integer.parseInt(xyz[2]);
			if(check>0) {
				videoCallService.remove(videocall);
			}
		}
		
		
		List<UserDTO> birthdayList = new ArrayList<UserDTO>();
		Collections.shuffle(birthday_User);
		if(birthday_User.size() >=2) {
			for(int i = 0; i<2; i++) {
				birthdayList.add(birthday_User.get(i));
			}
		}else if(birthday_User.size() <2 && birthday_User.size()>0) {
			for(int i = 0; i<1; i++) {
				birthdayList.add(birthday_User.get(i));
			}
		}
		//Message
		List<ChatDTO> chat_sourceList = chatService.findAllBySource_id(users.getId());
		
		_mvShare.addObject("user1", new UserDTO());
		_mvShare.addObject("chat", new ChatDTO());
		_mvShare.addObject("birthday_friend", birthdayList);
		_mvShare.addObject("commet_Post", commentList);
		_mvShare.addObject("myLike", listLike);
		_mvShare.addObject("list_Image", listImage);
		session.setAttribute("Friend_post", friend_post);
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.addObject("Friend", proposeFriend);
		_mvShare.addObject("Post", new PostDTO());
		_mvShare.addObject("edit_Post", new PostDTO());
		_mvShare.addObject("like", new Like_PostDTO());
		_mvShare.addObject("comment", new Comment_PostDTO());
		_mvShare.setViewName("user/index");
	return _mvShare;
	} 
	
	//Login
	@RequestMapping(value = "/")
		public ModelAndView LogIn(HttpSession session) {
		
		session.setAttribute("User_Infor", null);
		_mvShare.addObject("user", new UserDTO());
		_mvShare.setViewName("login/login");
		return _mvShare;
	} 	
	
	
	@RequestMapping(value = "/user/video-call", method = RequestMethod.GET)
	public ModelAndView Test() {
		
		_mvShare.addObject("videocall", new VideoCallDTO());
		_mvShare.setViewName("user/videocall");
	return _mvShare;
	}
	@RequestMapping(value = "/user/chatbot", method = RequestMethod.GET)
	public ModelAndView ChatBot() {
		
		_mvShare.addObject("user_friend", new UserDTO());
		_mvShare.setViewName("user/chatbot");
	return _mvShare;
	}


	//Method Register
	@RequestMapping(value = "/register", method = RequestMethod.GET )
	public ModelAndView Register() {
		
		//Sample object
		_mvShare.addObject("user_account", new UserDTO());
		
		//dropdown
		List<FacultyDTO> facultyls = facultyService.getAll();
		Map<String,String> fac = new LinkedHashMap<String,String>();
		for(FacultyDTO item : facultyls) {
			fac.put(String.valueOf(item.getId()) , item.getFacultyName());	
		}
		_mvShare.addObject("_Faculty",fac);
		_mvShare.setViewName("login/register");
	return _mvShare;
	}
	
	
	@RequestMapping(value = "user/addfriend",method =RequestMethod.POST)
	public ModelAndView AddFriend(@RequestParam(value = "id", required = false)Long id, HttpServletRequest request,HttpSession session ) {
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		FriendDTO model = new FriendDTO();
		model.setSourceId(users.getId());
		model.setTargetId(id);
		friendService.save(model);
		
		List<UserDTO> myFriend = new ArrayList<UserDTO>();
		List<UserDTO> myFollower = new ArrayList<UserDTO>();
		List<UserDTO> follow = new ArrayList<UserDTO>();
		List<UserDTO> allUser = userService.findALl();
		List<FriendDTO> source = friendService.findAllBySource(users.getId());
		List<FriendDTO> target = friendService.findAllByTarget(users.getId());

		for(int  i = 0; i < allUser.size();i++) {
			UserDTO u = allUser.get(i);
			
			for(int s =0; s<source.size();s++ ) {
				FriendDTO sx = source.get(s);
				if(u.getId() == sx.getTargetId() && sx.getStatus() == 1) {
					myFriend.add(u);
				}
				else if(u.getId() == sx.getTargetId() && sx.getStatus() == 0) {
					follow.add(u);
				}
				
				
			}
			for(int t =0; t  < target.size();t++ ) {
				FriendDTO tx = target.get(t);
				if(u.getId() == tx.getSourceId() && tx.getStatus() == 1) {
					myFriend.add(u);
				}
				else if(u.getId() == tx.getSourceId() && tx.getStatus() == 0) {
					myFollower.add(u);
				}
			}

		}
		
		session.setAttribute("Follower", follow);
		session.setAttribute("MyFollower", myFollower);
		session.setAttribute("MyFriend", myFriend);
		_mvShare.setViewName("redirect:time-line/"+id);
		return _mvShare;
	}
	


}
