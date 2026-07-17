package com.ecommerce.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.userservice.dto.UserInternalResponseDTO;
import com.ecommerce.userservice.dto.UserRequestDTO;
import com.ecommerce.userservice.dto.UserResponseDTO;
import com.ecommerce.userservice.dto.UserUpdateRequestDTO;
import com.ecommerce.userservice.entity.User;
import com.ecommerce.userservice.exception.UserNotFoundException;
import com.ecommerce.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserResponseDTO createUser(UserRequestDTO request) {
		User user = new User();
		user.setFullName(request.getFullName());
		user.setEmail(request.getEmail());
		user.setPhone(request.getPhone());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		
		User savedUser = userRepository.save(user);
		return mapToResponse(savedUser);
	}

	@Override
	public UserResponseDTO getUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
		
		return mapToResponse(user);

	}

	@Override
	public List<UserResponseDTO> getAllUsers() {
		return userRepository.findAll()
				.stream()
				.map(this::mapToResponse)
				.toList();
	}
	
	@Override
	public UserResponseDTO updateUser(Long id, UserUpdateRequestDTO request) {
		
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
		
		user.setFullName(request.getFullName());
		user.setPhone(request.getPhone());
		user.setRole(request.getRole());
		
		if (request.getActive() != null) {
			user.setActive(request.getActive());
		}
		
		User updatedUser = userRepository.save(user);
		return mapToResponse(updatedUser);
	}

	@Override
	public void deleteUser(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
		
		user.setActive(false);
		userRepository.save(user);
	}
	
	private UserResponseDTO mapToResponse(User user) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setId(user.getId());
		dto.setFullName(user.getFullName());
		dto.setEmail(user.getEmail());
		dto.setRole(user.getRole());
		dto.setPhone(user.getPhone());
		dto.setActive(user.getActive());
		dto.setCreatedAt(user.getCreatedAt());
		
		return dto;
	}

	@Override
	public UserInternalResponseDTO getUserInternal(Long userId) {

	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found"));

	    UserInternalResponseDTO dto = new UserInternalResponseDTO();
	    dto.setId(user.getId());
	    dto.setFullName(user.getFullName());
	    dto.setEmail(user.getEmail());
	    dto.setActive(user.getActive());

	    return dto;
	}

}
