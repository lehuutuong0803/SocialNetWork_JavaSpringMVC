package Javaspring.com.Society.API;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Javaspring.com.Society.DTO.FriendDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.FriendService;
import Javaspring.com.Society.ServiceUser.UserService;

@RestController(value = "newAPIOfAdmin")
public class UserAPI {
	
	public ModelAndView _mvShare = new ModelAndView();
	@Autowired
	private UserService userService;
	@Autowired
	private FriendService friendService;
	
	//API Create Account
	@PostMapping("/api/user")
	public UserDTO createUser(@RequestBody UserDTO userModel,HttpSession session) {
		UserDTO model = userService.save(userModel);

		return model;
	}
	
	
	//API Login
	@PostMapping("/api/user/login")
	public UserDTO Login(@RequestBody UserDTO userModel,HttpSession session) {
		UserDTO model = userService.login(userModel);
		

		
		//my friend
		List<UserDTO> myFriend = new ArrayList<UserDTO>();
		List<UserDTO> myFollower = new ArrayList<UserDTO>();
		List<UserDTO> following = new ArrayList<UserDTO>();
		List<UserDTO> allUser = userService.findALl();
		List<FriendDTO> source = friendService.findAllBySource(model.getId());
		List<FriendDTO> target = friendService.findAllByTarget(model.getId());

		for(int  i = 0; i < allUser.size();i++) {
			UserDTO u = allUser.get(i);
			
			for(int s =0; s<source.size();s++ ) {
				FriendDTO sx = source.get(s);
				if(u.getId() == sx.getTargetId() && sx.getStatus() == 1) {
					myFriend.add(u);
				}
				else if(u.getId() == sx.getTargetId() && sx.getStatus() == 0) {
					following.add(u);
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
		
		
		session.setAttribute("Follower", following);
		session.setAttribute("MyFollower", myFollower);
		session.setAttribute("MyFriend", myFriend);
		session.setAttribute("User_Infor", model);
		return model;
	}
	
	@PutMapping("/api/user")
	public UserDTO updateUser(@RequestBody UserDTO userModel) {

		return userModel;
	}
	
	@DeleteMapping("/api/user")
	public void deleteUser(@RequestBody long[] id) {

		System.out.print("Ok");
	}
}
