package Javaspring.com.Society.Converter;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.FriendDTO;
import Javaspring.com.Society.Entities.FriendEntity;

@Component
public class FriendConverter {
	
	public FriendDTO toModel(FriendEntity friendEntity) {
		FriendDTO model = new FriendDTO();
		model.setId(friendEntity.getId());
		model.setSourceId(friendEntity.getSource().getId());
		model.setTargetId(friendEntity.getTarget().getId());
		model.setCreateAt(friendEntity.getCreateAt());
		model.setStatus(friendEntity.getStatus());
		return model;
	}
	public FriendEntity toEntity(FriendDTO friendModel) {
		FriendEntity entity =  new FriendEntity();
		entity.setCreateAt(friendModel.getCreateAt());
		entity.setStatus(friendModel.getStatus());
		return entity;
	}
}
