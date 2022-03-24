package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.Comment_PostDTO;

@Service
public interface Comment_PostService {
	public Comment_PostDTO save (Comment_PostDTO comment_PostDTO);
	public List<Comment_PostDTO> findAllByPostid (long id);
	public List<Comment_PostDTO> findAll();
	public void deleteAllByPostId(long id);
	
}
