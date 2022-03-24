package Javaspring.com.Society.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.Entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	public UserEntity findOneByUsername(String username);
	public UserEntity findOneById(long id);
	public List<UserEntity> findAllByFaculty_id(long faculty_id);
}
