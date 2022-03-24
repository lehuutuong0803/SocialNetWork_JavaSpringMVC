package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.ChatDTO;

@Service
public interface ChatService {
	public List<ChatDTO> findAllBySource_id(long id);
	public List<ChatDTO> findAllByTarget_id(long id);
	public List<ChatDTO> findAllByBox_id(long id);
	public ChatDTO save(ChatDTO chatDTO);
}
