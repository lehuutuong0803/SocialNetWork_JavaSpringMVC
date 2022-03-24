package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.FriendEntity;

public interface FriendRepository extends JpaRepository<FriendEntity, Long>{
	public List<FriendEntity> findAllBySource_id(long source_id);
	public List<FriendEntity> findAllByTarget_id(long target_id);
}
