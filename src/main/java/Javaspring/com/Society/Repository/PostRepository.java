package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>{
	public PostEntity findOneById(long id);
	public List<PostEntity> findAllByUser_idOrderByIdDesc(long user_id);
}
