package Javaspring.com.Society.Converter;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.VideoCallDTO;
import Javaspring.com.Society.Entities.VideoCallEntity;


@Component
public class VideoCallConverter {
	
	public VideoCallDTO toModel(VideoCallEntity videoCallEntity) {
		VideoCallDTO videocall = new VideoCallDTO();
		videocall.setId(videoCallEntity.getId());
		videocall.setRoomcode(videoCallEntity.getRoomcode());
		videocall.setCreateAt(videoCallEntity.getCreateAt());
		videocall.setAmount(videoCallEntity.getAmount());
		videocall.setStatus(videoCallEntity.getStatus());
		videocall.setUser_id(videoCallEntity.getUser().getId());
		
		return videocall;
	}
	
	public VideoCallEntity toEntity(VideoCallDTO videoCallDTO) {
		VideoCallEntity videoCallEntity = new VideoCallEntity();
		videoCallEntity.setRoomcode(videoCallDTO.getRoomcode());
		videoCallEntity.setCreateAt(videoCallDTO.getCreateAt());
		videoCallEntity.setAmount(videoCallDTO.getAmount());
		videoCallEntity.setStatus(videoCallDTO.getStatus());
		
		return videoCallEntity;
	}
}
