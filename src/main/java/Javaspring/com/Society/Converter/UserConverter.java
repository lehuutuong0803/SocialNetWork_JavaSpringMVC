package Javaspring.com.Society.Converter;

import org.springframework.stereotype.Component;

import Javaspring.com.Society.DTO.UserDTO;
import Javaspring.com.Society.Entities.UserEntity;

@Component
public class UserConverter {
	
	public UserDTO toModel (UserEntity userEntity) {
		UserDTO userModel = new UserDTO();
		userModel.setId(userEntity.getId());
		userModel.setUsername(userEntity.getUsername());
		userModel.setPassword(userEntity.getPassword());
		userModel.setName(userEntity.getName());
		userModel.setPhone(userEntity.getPhone());
		userModel.setEmail(userEntity.getEmail());
		userModel.setBirthday(userEntity.getBirthday());
		userModel.setIntro(userEntity.getIntro());
		userModel.setGender(userEntity.getGender());
		userModel.setCreateAt(userEntity.getCreateAt());
		userModel.setAvatar(userEntity.getAvatar());
		userModel.setId_Faculty(userEntity.getFaculty().getId());
		userModel.setStudent_number(userEntity.getStudent_number());
		return userModel;
	}
	
	public UserEntity toEntity(UserDTO userModel) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(userModel.getUsername());
		userEntity.setPassword(userModel.getPassword());
		userEntity.setName(userModel.getName());
		userEntity.setPhone(userModel.getPhone());
		userEntity.setEmail(userModel.getEmail());
		userEntity.setBirthday(userModel.getBirthday());
		userEntity.setIntro(userModel.getIntro());
		userEntity.setGender(userModel.getGender());
		userEntity.setCreateAt(userModel.getCreateAt());
		userEntity.setAvatar(userModel.getAvatar());
		userEntity.setStudent_number(userModel.getStudent_number());
		return userEntity;
	}
}
