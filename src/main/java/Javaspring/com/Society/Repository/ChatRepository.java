package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.ChatEntity;

public interface ChatRepository extends JpaRepository<ChatEntity, Long>{
	public List<ChatEntity> findAllBySource_id(long source_id);
	public List<ChatEntity> findAllByTarget_id(long target_id);
	public List<ChatEntity> findAllByBoxid(long boxid);
}
