package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Javaspring.com.Society.Converter.PostConverter;
import Javaspring.com.Society.DTO.PostDTO;
import Javaspring.com.Society.Entities.PostEntity;
import Javaspring.com.Society.Repository.PostRepository;
import Javaspring.com.Society.Repository.UserRepository;

@Service
public class PostServiceImp implements PostService{
	@Autowired
	private PostConverter postConverter;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public PostDTO save(PostDTO postModel) {
		PostEntity postEntity = new PostEntity();
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		postEntity.setCreateAt(date);
		postEntity.setContent(postModel.getContent());
		postEntity.setStatus(postModel.getStatus());
		postEntity.setUser(userRepository.findOneById(postModel.getUserID()));
		if(postModel.getId() != 0) {
			postEntity.setId(postModel.getId());
			postEntity.setCreateAt(postModel.getCreateAt());
		}
		return postConverter.toModel(postRepository.save(postEntity));
	}
	
	@Transactional
	public List<PostDTO> findAllByUserid(long id) {
		List<PostDTO> postDTOs= new ArrayList<PostDTO>();
		List<PostEntity> postEntities = postRepository.findAllByUser_idOrderByIdDesc(id);
		for(PostEntity item : postEntities) {
			postDTOs.add(postConverter.toModel(item));
		}
		return postDTOs;
	}

	@Override
	@Transactional
	public List<PostDTO> findAll() {
		List<PostDTO> postDTOs= new ArrayList<PostDTO>();
		List<PostEntity> postEntities = postRepository.findAll();
		for(PostEntity item : postEntities) {
			postDTOs.add(postConverter.toModel(item));
		}
		return postDTOs;
	}

	@Override
	@Transactional
	public PostDTO findById(long id) {
		PostEntity postEntity=  postRepository.findOneById(id);
		return postConverter.toModel(postEntity);
	}

	@Override
	public void delete(long id) {
		postRepository.deleteById(id);
	}
	

}
