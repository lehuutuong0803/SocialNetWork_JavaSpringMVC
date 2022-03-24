package Javaspring.com.Society.ServiceUser;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Javaspring.com.Society.Converter.UserConverter;
import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.Entities.FacultyEntity;
import Javaspring.com.Society.Entities.UserEntity;
import Javaspring.com.Society.Repository.FacultyRepository;
import Javaspring.com.Society.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FacultyRepository facultyRepository;
	@Autowired
	private UserConverter userConverter;
	
	public List<UserDTO> findALl() {
		List<UserDTO> userModels = new ArrayList<UserDTO>();
		List<UserEntity> entities = userRepository.findAll();
		for(UserEntity userEntity : entities) {
			UserDTO userModel =  userConverter.toModel(userEntity);
			userModels.add(userModel);
		}	
		return userModels;
	}

	@Transactional
	public UserDTO save(UserDTO userModel) {
		UserEntity checkuser = userRepository.findOneByUsername(userModel.getUsername());
		if(checkuser != null) {
			return null;
		}
		FacultyEntity faculty = facultyRepository.findOneById(userModel.getId_Faculty());
		UserEntity userEntity = new UserEntity();
		userEntity = userConverter.toEntity(userModel);
		userEntity.setFaculty(faculty);
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userEntity.setCreateAt(date);
		userEntity.setPassword(BCrypt.hashpw(userModel.getPassword(), BCrypt.gensalt(12)));
		
		if(userModel.getId()!= 0) {
			userEntity.setId(userModel.getId());
			userEntity.setCreateAt(userModel.getCreateAt());
			userEntity.setPassword(userModel.getPassword());
		}
		
		return userConverter.toModel(userRepository.save(userEntity));
	}
	@Transactional
	public UserDTO login(UserDTO userModel) {
		UserEntity checkuser = userRepository.findOneByUsername(userModel.getUsername());
		if(checkuser != null) {
			if(BCrypt.checkpw(userModel.getPassword(), checkuser.getPassword())) {
				return userConverter.toModel(checkuser);
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

	public List<UserDTO> findFacultyID(long id) {
		List<UserDTO> userModels = new ArrayList<UserDTO>();
		List<UserEntity> entities = userRepository.findAllByFaculty_id(id);
		
		for(UserEntity userEntity : entities) {
			UserDTO userModel =  userConverter.toModel(userEntity);
			userModels.add(userModel);
		}	
		return userModels;
	}

	public UserDTO findOneById(long id) {
		UserEntity entity = userRepository.findOneById(id);
		return userConverter.toModel(entity);
	}

	@Override
	public UserDTO update(UserDTO userModel) {
		UserEntity userEntity = userRepository.findOneById(userModel.getId());
		userEntity.setAvatar(userModel.getAvatar());
		return userConverter.toModel(userRepository.save(userEntity));
	}

}
