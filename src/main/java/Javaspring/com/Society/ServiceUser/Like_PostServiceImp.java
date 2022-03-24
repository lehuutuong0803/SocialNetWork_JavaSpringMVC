package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Javaspring.com.Society.Converter.Like_PostConverter;
import Javaspring.com.Society.DTO.Like_PostDTO;
import Javaspring.com.Society.DTO.PostDTO;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.Entities.Like_PostEntity;
import Javaspring.com.Society.Entities.PostEntity;
import Javaspring.com.Society.Entities.UserEntity;
import Javaspring.com.Society.Repository.Like_PostRepository;
import Javaspring.com.Society.Repository.PostRepository;
import Javaspring.com.Society.Repository.UserRepository;

@Service
public class Like_PostServiceImp implements Like_PostService{

	@Autowired
	private Like_PostRepository likePostRepository;
	@Autowired
	private Like_PostConverter like_PostConverter;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public List<Like_PostDTO> findAllByIdPost(long idpost) {
		List<Like_PostEntity> listLikes = likePostRepository.findAllByPost_id(idpost);
		List<Like_PostDTO> like_PostDTOs = new ArrayList<Like_PostDTO>();
		
		for(Like_PostEntity item : listLikes) {
			Like_PostDTO like_PostDTO= like_PostConverter.toModel(item);
			like_PostDTOs.add(like_PostDTO);
		}
		
		return like_PostDTOs;
	}

	@Override
	@Transactional
	public void save(Like_PostDTO like_PostDTO) {
		PostEntity postEntity = postRepository.findOneById(like_PostDTO.getIdpost());
		UserEntity  userEntity =  userRepository.findOneById(like_PostDTO.getLikeiduser());

		Like_PostEntity like_PostEntity = new Like_PostEntity();
		like_PostEntity.setPost(postEntity);
		like_PostEntity.setUser(userEntity);
		
		likePostRepository.save(like_PostEntity);
	}

	@Override
	@Transactional
	public void delete(long id) {
		likePostRepository.deleteById(id);
	}

	@Override
	public List<Like_PostDTO> findAllByIdUser(long iduser) {
		List<Like_PostEntity> listLikes = likePostRepository.findAllByUser_id(iduser);
		List<Like_PostDTO> like_PostDTOs = new ArrayList<Like_PostDTO>();
		
		for(Like_PostEntity item : listLikes) {
			Like_PostDTO like_PostDTO= like_PostConverter.toModel(item);
			like_PostDTOs.add(like_PostDTO);
		}
		
		return like_PostDTOs;
	}

	@Override
	public void deleteAllByPostId(long id) {
		List<Like_PostEntity> listLikes = likePostRepository.findAllByPost_id(id);
		for(Like_PostEntity post : listLikes) {
			likePostRepository.deleteById(post.getId());
		}
	}

}
