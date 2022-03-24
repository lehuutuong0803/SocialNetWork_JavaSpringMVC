package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.Image_postDTO;



@Service
public interface Image_PostService {
	public Image_postDTO save(Image_postDTO image_postModel);
	public List<Image_postDTO> findAll();
	public List<Image_postDTO> findAllByPost_id(long id);
	public void remove(long id);
	public void deleteAllByPostId(long id);
}
