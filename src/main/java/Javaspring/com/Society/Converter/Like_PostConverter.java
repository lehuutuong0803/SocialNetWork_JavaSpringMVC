package Javaspring.com.Society.Converter;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.Like_PostDTO;
import Javaspring.com.Society.Entities.Like_PostEntity;

@Component
public class Like_PostConverter {
		
	public Like_PostDTO toModel(Like_PostEntity likePostEntity) {
		Like_PostDTO like_PostDTO = new Like_PostDTO();
		like_PostDTO.setId(likePostEntity.getId());
		like_PostDTO.setIdpost(likePostEntity.getPost().getId());
		like_PostDTO.setLikeiduser(likePostEntity.getUser().getId());
		return like_PostDTO;
	}
	

}
