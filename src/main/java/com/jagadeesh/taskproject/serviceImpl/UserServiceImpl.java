package com.jagadeesh.taskproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jagadeesh.taskproject.entity.Users;
import com.jagadeesh.taskproject.payload.UserDto;
import com.jagadeesh.taskproject.repository.UserRepository;
import com.jagadeesh.taskproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		Users users = userDtoToEntity(userDto);
		Users saveUser = userRepository.save(users);
		UserDto usersToUserDto = usersToUserDto(saveUser);
		return usersToUserDto;
	}
	
	private Users userDtoToEntity(UserDto userDto) {
		Users users = new Users();
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		return users;
	}
	
	private UserDto usersToUserDto(Users user) {
		UserDto userDto = new UserDto();
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

}
