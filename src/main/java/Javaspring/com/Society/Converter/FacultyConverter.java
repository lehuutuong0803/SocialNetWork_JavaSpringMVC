package Javaspring.com.Society.Converter;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.FacultyDTO;
import Javaspring.com.Society.Entities.FacultyEntity;

@Component
public class FacultyConverter {
	
	public FacultyDTO toModel(FacultyEntity facultyEntity) {
		FacultyDTO facultyModel = new FacultyDTO();
		facultyModel.setId(facultyEntity.getId());
		facultyModel.setFacultyName(facultyEntity.getFacultyname());
		return facultyModel;
	}
}
