package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Javaspring.com.Society.Converter.VideoCallConverter;
import Javaspring.com.Society.DTO.VideoCallDTO;
import Javaspring.com.Society.Entities.UserEntity;
import Javaspring.com.Society.Entities.VideoCallEntity;
import Javaspring.com.Society.Repository.UserRepository;
import Javaspring.com.Society.Repository.VideoCallRepository;

@Service
public class VideoCallServiceImp implements VideoCallService {

	@Autowired
	public VideoCallRepository videoCallRepository;
	@Autowired
	public VideoCallConverter videoCallConverter;
	@Autowired
	public UserRepository userRepository;
	@Override
	public VideoCallDTO findOneByRoomcode(String roomcode) {
		VideoCallEntity videoCallEntity = videoCallRepository.findOneByRoomcode(roomcode);
		if(videoCallEntity == null) {
			return null;
		}else {
			return videoCallConverter.toModel(videoCallEntity) ;
		}
		
	}

	@Override
	public List<VideoCallDTO> findAll() {
		List<VideoCallEntity> listVideoCallEntities = videoCallRepository.findAll();
		List<VideoCallDTO> listVideoCallDTOs = new ArrayList<VideoCallDTO>();
		for(VideoCallEntity userEntity : listVideoCallEntities) {
			VideoCallDTO userModel =  videoCallConverter.toModel(userEntity);
			listVideoCallDTOs.add(userModel);
		}	
		return listVideoCallDTOs;
	}

	@Override
	public void save(VideoCallDTO videoCallDTO) {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		videoCallDTO.setAmount(1);
		videoCallDTO.setCreateAt(date);
		VideoCallEntity newVideocall = videoCallConverter.toEntity(videoCallDTO);
		UserEntity userEntity = userRepository.findOneById(videoCallDTO.getUser_id());
		newVideocall.setUser(userEntity);
		videoCallRepository.save(newVideocall);	
	}

	@Override
	public void remove(VideoCallDTO videoCallDTO) {
		videoCallRepository.deleteById(videoCallDTO.getId());
		
	}

	@Override
	public void update(VideoCallDTO videoCallDTO) {
		VideoCallEntity videoCallEntity = videoCallRepository.findOneByRoomcode(videoCallDTO.getRoomcode());
		videoCallEntity.setAmount(2);
		videoCallRepository.save(videoCallEntity);
		
	}

	@Override
	public void delete(VideoCallDTO videoCallDTO) {
		List<VideoCallEntity> videoCallEntityList = videoCallRepository.findAllByUser_id(videoCallDTO.getUser_id());
		for(VideoCallEntity video : videoCallEntityList) {
			if(video.getStatus() == 2) {
				videoCallRepository.deleteById(video.getId());
			}
		}
		
	}

}
