package Javaspring.com.Society.Converter;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.PostDTO;
import Javaspring.com.Society.Entities.PostEntity;

@Component
public class PostConverter {

	public PostDTO toModel(PostEntity postEntity) {
		PostDTO model = new PostDTO();
		model.setId(postEntity.getId());
		model.setUserID(postEntity.getUser().getId());
		model.setContent(postEntity.getContent());
		model.setCreateAt(postEntity.getCreateAt());
		model.setStatus(postEntity.getStatus());
		return model;
	}
	
	public PostEntity toEntity(PostDTO postModel) {
		PostEntity entity = new PostEntity();
		entity.setContent(postModel.getContent());
		entity.setCreateAt(postModel.getCreateAt());
		entity.setStatus(postModel.getStatus());
		return entity;
	}
}
