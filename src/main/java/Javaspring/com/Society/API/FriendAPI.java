package Javaspring.com.Society.API;


import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Javaspring.com.Society.DTO.FacultyDTO;
import Javaspring.com.Society.DTO.FriendDTO;
import Javaspring.com.Society.DTO.SearchDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.ServiceUser.FacultyService;
import Javaspring.com.Society.ServiceUser.FriendService;
import Javaspring.com.Society.ServiceUser.UserService;



@RestController(value = "friendAPIOfAdmin")
public class FriendAPI {
	@Autowired
	private FriendService friendService;
	@Autowired
	private UserService  userService;
	@Autowired
	private FacultyService facultyService;
	
	@PostMapping("/api/friend")
	public FriendDTO createFriend(@RequestBody UserDTO userModel,HttpSession session) {
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		FriendDTO model = new FriendDTO();
		model.setSourceId(users.getId());
		model.setTargetId(userModel.getId());
		FriendDTO check = friendService.save(model);
		
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
			
		return check;
	}
	
	@DeleteMapping("/api/friend")
	public void deleteFriend(@RequestBody UserDTO friend,HttpSession session) {
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		friendService.deleteById(friend.getId(),users.getId());
		
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
		
	}
	@PutMapping("/api/friend")
	public void AcceptFriend(@RequestBody UserDTO friend,HttpSession session) {
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		List<FriendDTO> waiting = friendService.findAllByTarget(users.getId());
		for( FriendDTO item : waiting ) {
			if(item.getSourceId() == friend.getId()) {
				item.setStatus(1);
				friendService.save(item);
			}
		}
		
		
		
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
		
	}
	@PostMapping("/api/friend/search")
	public List<UserDTO> SearchFriend(@RequestBody SearchDTO searchDTO,HttpSession session) {
		UserDTO userDTO = userService.findOneById(searchDTO.getId_user());
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
		
		for(int i=0; i<searchs.size(); i++) {
			UserDTO user = searchs.get(i);
			for(FacultyDTO faculty : facultyls) {
				if(user.getId_Faculty() == faculty.getId()) {
					searchs.get(i).setFaculty_name(faculty.getFacultyName());
				}
			}
		}
		
	
		return searchs;
	}
	
	public static String unAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
}

}
