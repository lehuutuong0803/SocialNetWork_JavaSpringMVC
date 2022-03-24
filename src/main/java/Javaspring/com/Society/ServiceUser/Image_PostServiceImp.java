package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Javaspring.com.Society.Converter.Image_PostConverter;
import Javaspring.com.Society.DTO.Image_postDTO;
import Javaspring.com.Society.Entities.Image_PostEntity;
import Javaspring.com.Society.Repository.Image_PostRepository;
import Javaspring.com.Society.Repository.PostRepository;

@Service
public class Image_PostServiceImp implements Image_PostService{

	@Autowired
	private Image_PostRepository image_PostRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private Image_PostConverter image_PostConverter;
	
	@Transactional
	public Image_postDTO save(Image_postDTO image_postModel) {
		Image_PostEntity image_PostEntity= new Image_PostEntity();
		image_PostEntity.setImage(image_postModel.getImage());
		image_PostEntity.setPost(postRepository.findOneById(image_postModel.getId_post()));
		return image_PostConverter.toModel(image_PostRepository.save(image_PostEntity));
	}
	@Transactional
	public List<Image_postDTO> findAll() {
		List<Image_postDTO> list_post = new ArrayList<Image_postDTO>();
		List<Image_PostEntity> list_entities = image_PostRepository.findAll();
		for(Image_PostEntity item : list_entities) {
			list_post.add(image_PostConverter.toModel(item));
		}
		return list_post;
	}
	
	@Override
	@Transactional
	public List<Image_postDTO> findAllByPost_id(long id) {
		List<Image_postDTO> list_post = new ArrayList<Image_postDTO>();
		List<Image_PostEntity> list_entities = image_PostRepository.findAllByPost_id(id);
		for(Image_PostEntity item : list_entities) {
			list_post.add(image_PostConverter.toModel(item));
		}
		return list_post;
	}
	@Override
	@Transactional
	public void remove(long id) {
		image_PostRepository.deleteById(id);
	}
	@Override
	public void deleteAllByPostId(long id) {
		List<Image_PostEntity> listentities = image_PostRepository.findAllByPost_id(id);
		for(Image_PostEntity post : listentities) {
			image_PostRepository.deleteById(post.getId());
		}
		
	}
	
	

}
