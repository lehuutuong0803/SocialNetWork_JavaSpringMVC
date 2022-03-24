package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.FacultyDTO;

@Service
public interface FacultyService {
	
	public List<FacultyDTO>  getAll();
	public FacultyDTO findOneById(long id); 
}
