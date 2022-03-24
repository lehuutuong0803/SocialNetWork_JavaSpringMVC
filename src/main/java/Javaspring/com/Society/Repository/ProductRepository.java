package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	public List<ProductEntity> findAllByUser_id (long user_id);
	public ProductEntity findOneById (long id);

}
