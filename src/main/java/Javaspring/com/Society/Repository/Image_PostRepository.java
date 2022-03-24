package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.Image_PostEntity;

public interface Image_PostRepository extends JpaRepository<Image_PostEntity, Long>{
	public List<Image_PostEntity> findAllByPost_id(long post_id);
}
