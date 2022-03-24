package Javaspring.com.Society.ServiceUser;

import java.util.List;

import org.springframework.stereotype.Service;

import Javaspring.com.Society.DTO.UserDTO;

@Service
public interface UserService {
		public List<UserDTO> findALl();
		public UserDTO save(UserDTO userModel);
		public UserDTO update(UserDTO userModel);
		public UserDTO login(UserDTO userModel);
		public List<UserDTO> findFacultyID(long id);
		public UserDTO findOneById(long id);
}
