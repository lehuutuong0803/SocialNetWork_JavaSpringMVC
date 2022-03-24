package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.Comment_PostEntity;

public interface Comment_PostRepository extends JpaRepository<Comment_PostEntity, Long>{
	public List<Comment_PostEntity> findAllByPost_id (long post_id);
}
