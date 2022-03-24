package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Javaspring.com.Society.Converter.FacultyConverter;
import Javaspring.com.Society.DTO.FacultyDTO;
import Javaspring.com.Society.Entities.FacultyEntity;
import Javaspring.com.Society.Repository.FacultyRepository;

@Service
public class FacultyServiceImp implements FacultyService{

	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	private FacultyConverter facultyConverter;
	
	//getALL
	@Transactional
	public List<FacultyDTO> getAll() {
		
		List<FacultyDTO> liFacultyModels = new ArrayList<FacultyDTO>();
		List<FacultyEntity> facultyEntity = facultyRepository.findAll();
		for(FacultyEntity item : facultyEntity) {
			liFacultyModels.add(facultyConverter.toModel(item));
		}
		return liFacultyModels;
	}

	public FacultyDTO findOneById(long id) {
		FacultyEntity entity = facultyRepository.findOneById(id);
		return facultyConverter.toModel(entity);
	}

}
