package Javaspring.com.Society.API;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.DTO.VideoCallDTO;
import Javaspring.com.Society.ServiceUser.VideoCallService;

@RestController(value = "videocallAPIOfAdmin")
public class VideoCallAPI {
	public ModelAndView _mvShare = new ModelAndView();
	@Autowired
	public VideoCallService videoCallService;

	@PostMapping("api/user/videocall")
	public int createRoom(@RequestBody VideoCallDTO videoCallDTO, HttpSession session) {
		UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		VideoCallDTO video = videoCallService.findOneByRoomcode(videoCallDTO.getRoomcode());
		
		
		if(video == null) {
			videoCallDTO.setStatus(1);
			videoCallDTO.setUser_id(users.getId());
			videoCallService.save(videoCallDTO);
			return 1;
		}else {
			return 0;
		}
		
	}
	@GetMapping("api/user/videocalltest")
	public String test(HttpSession session) {
		
		double randomDouble = Math.random();
        randomDouble = randomDouble * 100 + 1;
        int randomInt = (int) randomDouble;
        UserDTO users = (UserDTO) session.getAttribute("User_Infor");
        String roomcode = users.getUsername()+randomInt;
        
        VideoCallDTO video = videoCallService.findOneByRoomcode(roomcode);
		
		if(video == null) {
			video = new VideoCallDTO();
			video.setStatus(2);
			video.setUser_id(users.getId());
			video.setRoomcode(roomcode);
			videoCallService.save(video);
			return roomcode;
		}else {
			return "false";
		}
        
		
	}
	@GetMapping("api/user/researchrandomroom")
	public String research_RandomRoom(HttpSession session) {
		 UserDTO users = (UserDTO) session.getAttribute("User_Infor");
		 VideoCallDTO video = new VideoCallDTO();
		 video.setUser_id(users.getId());
		videoCallService.delete(video);
		
		return "success";
        
		
	}
	@PostMapping("api/user/joinroom")
	public int joinRoom(@RequestBody VideoCallDTO videoCallDTO) {
		VideoCallDTO video = videoCallService.findOneByRoomcode(videoCallDTO.getRoomcode());
		
		if(video != null) {
			if(video.getAmount()<2) {
				videoCallService.update(videoCallDTO);
				return 1;
			}
			return 2;
			
		}else {
			return 0;
		}
		
	}
	@PostMapping("api/user/availableroom")
	public String availableRoom(@RequestBody VideoCallDTO videoCallDTO) {
		List<VideoCallDTO> videoCallDTOs = videoCallService.findAll();
		List<VideoCallDTO> checks = new ArrayList<VideoCallDTO>();
		for(VideoCallDTO video : videoCallDTOs) {
			if(video.getAmount()<2&&video.getStatus()==2) {
				checks.add(video);
			}
		}
		Collections.shuffle(checks);
		if(checks.isEmpty()) {
			return "false";
		}
		
		return checks.get(0).getRoomcode();
		
	}
	@PostMapping("api/user/joinrandomroom")
	public String joinRandomRoom(@RequestBody String roomcode) {
		 String[] arrOfStr = roomcode.split("=");
	     String room = arrOfStr[0];
		VideoCallDTO video = videoCallService.findOneByRoomcode(room);
		videoCallService.update(video);
		
		return "Thanh cong";
		
	}
	
}
