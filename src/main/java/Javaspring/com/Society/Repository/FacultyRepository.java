package Javaspring.com.Society.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Javaspring.com.Society.Entities.FacultyEntity;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Long>{
	public FacultyEntity findOneById(long id);
}
