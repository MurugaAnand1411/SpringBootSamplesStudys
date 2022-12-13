package com.rubixtek.rubixbooks.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubixtek.rubixbooks.entities.User;
import com.rubixtek.rubixbooks.repository.UserRepository;
import com.rubixtek.rubixbooks.service.UserService;


@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();	}

	@Override
	public User getUserbyId(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public String updateUser(User user, long id) {
		user.setId(id);
		userRepository.save(user);
		return "successfully updated";	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		

	}
	
	

}
