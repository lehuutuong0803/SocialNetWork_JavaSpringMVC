package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.Like_PostEntity;

public interface Like_PostRepository extends JpaRepository<Like_PostEntity, Long>{
		public List<Like_PostEntity> findAllByPost_id (long post_id );
		public List<Like_PostEntity> findAllByUser_id (long user_id );
		public void deleteAllByPost_id(long post_id);
}
