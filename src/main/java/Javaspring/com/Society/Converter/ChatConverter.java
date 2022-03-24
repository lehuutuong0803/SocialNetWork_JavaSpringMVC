package Javaspring.com.Society.Converter;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.ChatDTO;
import Javaspring.com.Society.Entities.ChatEntity;

@Component
public class ChatConverter {
	
		public ChatDTO toModel(ChatEntity chatEntity) {
			ChatDTO chatDTO = new ChatDTO();
			chatDTO.setId(chatEntity.getId());
			chatDTO.setSource_id(chatEntity.getSource().getId());
			chatDTO.setTarget_id(chatEntity.getTarget().getId());
			chatDTO.setCreateAt(chatEntity.getCreateAt());
			chatDTO.setContent(chatEntity.getContent());
			return chatDTO;
		}
		
		public ChatEntity  toEntity(ChatDTO chatDTO) {
			ChatEntity chatEntity = new ChatEntity();
			chatEntity.setContent(chatDTO.getContent());
			chatEntity.setCreateAt(chatDTO.getCreateAt());
			return chatEntity;
		}
}
