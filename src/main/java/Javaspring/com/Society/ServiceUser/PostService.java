package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.PostDTO;

@Service
public interface PostService {
	public PostDTO save(PostDTO postModel);
	public List<PostDTO> findAll();
	public List<PostDTO> findAllByUserid(long id);
	public PostDTO findById(long id);
	public void delete(long id);
}
