package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Javaspring.com.Society.Converter.Comment_PostConverter;
import Javaspring.com.Society.DTO.Comment_PostDTO;
import Javaspring.com.Society.Entities.Comment_PostEntity;
import Javaspring.com.Society.Entities.PostEntity;
import Javaspring.com.Society.Entities.UserEntity;
import Javaspring.com.Society.Repository.Comment_PostRepository;
import Javaspring.com.Society.Repository.PostRepository;
import Javaspring.com.Society.Repository.UserRepository;

@Service
public class Comment_PostServiceImp implements Comment_PostService{
	@Autowired
	private Comment_PostRepository comment_PostRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Comment_PostConverter comment_PostConverter;
	
	@Override
	public Comment_PostDTO save(Comment_PostDTO comment_PostDTO) {
		Comment_PostEntity comment_PostEntity = new Comment_PostEntity();
		PostEntity postEntity = postRepository.findOneById(comment_PostDTO.getPost_id());
		UserEntity  userEntity =  userRepository.findOneById(comment_PostDTO.getUser_id());

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		comment_PostEntity.setPost(postEntity);
		comment_PostEntity.setUser(userEntity);
		comment_PostEntity.setContent(comment_PostDTO.getContent());
		comment_PostEntity.setCreateAt(date);
		
		
		return comment_PostConverter.toModel(comment_PostRepository.save(comment_PostEntity));
	}

	@Override
	public List<Comment_PostDTO> findAllByPostid(long id) {
		List<Comment_PostEntity> listEntities = comment_PostRepository.findAllByPost_id(id);
		List<Comment_PostDTO> listDTO = new ArrayList<Comment_PostDTO>();
		for(Comment_PostEntity item : listEntities) {
			listDTO.add(comment_PostConverter.toModel(item));
		}
		
		return listDTO;
	}

	@Override
	public List<Comment_PostDTO> findAll() {
		List<Comment_PostEntity> listEntities =comment_PostRepository.findAll();
		List<Comment_PostDTO> listDTO = new ArrayList<Comment_PostDTO>();
		for(Comment_PostEntity item : listEntities) {
			listDTO.add(comment_PostConverter.toModel(item));
		}
		
		return listDTO;
	}

	@Override
	public void deleteAllByPostId(long id) {
		List<Comment_PostEntity> listEntities = comment_PostRepository.findAllByPost_id(id);
		for(Comment_PostEntity post : listEntities) {
			comment_PostRepository.deleteById(post.getId());
		}
	}

}
