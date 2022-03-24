package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.VideoCallDTO;

@Service
public interface VideoCallService {
	public VideoCallDTO findOneByRoomcode (String roomcode);
	public List<VideoCallDTO> findAll();
	public void save(VideoCallDTO videoCallDTO);
	public void remove(VideoCallDTO videoCallDTO);
	public void update(VideoCallDTO videoCallDTO);
	public void delete(VideoCallDTO videoCallDTO);

}
