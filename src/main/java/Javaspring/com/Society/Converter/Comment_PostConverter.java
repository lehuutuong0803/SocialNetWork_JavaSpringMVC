package Javaspring.com.Society.Converter;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.Comment_PostDTO;
import Javaspring.com.Society.Entities.Comment_PostEntity;

@Component
public class Comment_PostConverter {
		
	public Comment_PostDTO toModel(Comment_PostEntity comment_PostEntity) {
		Comment_PostDTO comment_PostDTO =  new Comment_PostDTO();
		comment_PostDTO.setId(comment_PostEntity.getId());
		comment_PostDTO.setPost_id(comment_PostEntity.getPost().getId());
		comment_PostDTO.setUser_id(comment_PostEntity.getUser().getId());
		comment_PostDTO.setContent(comment_PostEntity.getContent());
		comment_PostDTO.setCreateAt(comment_PostEntity.getCreateAt());
		
		return comment_PostDTO;
	}
	
	public Comment_PostEntity toEntity(Comment_PostDTO comment_PostDTO) {
		Comment_PostEntity comment_PostEntity = new Comment_PostEntity();
		comment_PostEntity.setContent(comment_PostDTO.getContent());
		comment_PostEntity.setCreateAt(comment_PostDTO.getCreateAt());
		
		return comment_PostEntity;
	}
}
