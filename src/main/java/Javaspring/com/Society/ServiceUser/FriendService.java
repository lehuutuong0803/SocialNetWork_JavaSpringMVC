package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.FriendDTO;

@Service
public interface FriendService {
	public FriendDTO save(FriendDTO friendModel);
	public List<FriendDTO> findAll(FriendDTO friendModel);
	public List<FriendDTO> findAllBySource(long id);
	public List<FriendDTO> findAllByTarget(long id);
	public void deleteById(long idFriend, long idUser);
}
