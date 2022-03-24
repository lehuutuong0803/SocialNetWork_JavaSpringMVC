package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Javaspring.com.Society.Converter.ChatConverter;
import Javaspring.com.Society.DTO.ChatDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.Entities.ChatEntity;
import Javaspring.com.Society.Entities.UserEntity;
import Javaspring.com.Society.Repository.ChatRepository;
import Javaspring.com.Society.Repository.UserRepository;

@Service
public class ChatServiceImp implements ChatService{
	
	@Autowired
	private ChatRepository chatRepository;
	@Autowired
	private ChatConverter chatConverter;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<ChatDTO> findAllBySource_id(long id) {
		List<ChatEntity> sourceList = chatRepository.findAllBySource_id(id);
		List<ChatDTO> dtoList = new ArrayList<ChatDTO>();
		for(ChatEntity item : sourceList) {
			dtoList.add(chatConverter.toModel(item));
		}
		return dtoList;
	}

	@Override
	public List<ChatDTO> findAllByTarget_id(long id) {
		List<ChatEntity> sourceList = chatRepository.findAllByTarget_id(id);
		List<ChatDTO> dtoList = new ArrayList<ChatDTO>();
		for(ChatEntity item : sourceList) {
			dtoList.add(chatConverter.toModel(item));
		}
		return dtoList;
	}

	@Override
	public List<ChatDTO> findAllByBox_id(long id) {
		List<ChatEntity> sourceList = chatRepository.findAllByBoxid(id);
		List<ChatDTO> dtoList = new ArrayList<ChatDTO>();
		for(ChatEntity item : sourceList) {
			dtoList.add(chatConverter.toModel(item));
		}
		return dtoList;
	}

	@Override
	public ChatDTO save(ChatDTO chatDTO) {
		ChatEntity chatEntity = new ChatEntity();
		UserEntity user = userRepository.findOneById(chatDTO.getSource_id());
		UserEntity friend = userRepository.findOneById(chatDTO.getTarget_id());
		chatEntity.setSource(user);
		chatEntity.setTarget(friend);
		chatEntity.setBoxid(chatDTO.getBox_id());
		chatEntity.setCreateAt(chatDTO.getCreateAt());
		chatEntity.setContent(chatDTO.getContent());
		return chatConverter.toModel(chatRepository.save(chatEntity));
	}

}
