package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.Like_PostDTO;

@Service
public interface Like_PostService {
	public List<Like_PostDTO> findAllByIdPost(long idpost);
	public List<Like_PostDTO> findAllByIdUser(long iduser);
	public void save(Like_PostDTO like_PostDTO);
	public void delete(long id);
	public void deleteAllByPostId(long id);
}
