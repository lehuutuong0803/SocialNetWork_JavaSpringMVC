package Javaspring.com.Society.Converter;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.Image_postDTO;
import Javaspring.com.Society.Entities.Image_PostEntity;

@Component
public class Image_PostConverter {
	
		public Image_postDTO toModel(Image_PostEntity image_PostEntity) {
			Image_postDTO model = new Image_postDTO();
			model.setId(image_PostEntity.getId());
			model.setId_post(image_PostEntity.getPost().getId());
			model.setImage(image_PostEntity.getImage());
			return model;
		}
		
		public Image_PostEntity toEntity(Image_postDTO image_postModel) {
			Image_PostEntity entitty = new Image_PostEntity();
			entitty.setImage(image_postModel.getImage());
			return entitty;
		}
	
}
