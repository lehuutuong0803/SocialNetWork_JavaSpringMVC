package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.VideoCallEntity;

public interface VideoCallRepository extends JpaRepository<VideoCallEntity, Long>{
	public VideoCallEntity findOneByRoomcode(String roomcode);
	public List<VideoCallEntity> findAllByUser_id(long user_id);

}
