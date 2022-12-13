package com.rubixtek.rubixbooks.service;

import java.util.List;

import com.rubixtek.rubixbooks.entities.User;


public interface UserService {

	 public User saveUser(User user);
		
		public List<User> getAllUser();
		
		public User getUserbyId(Long id);
		
		public String updateUser(User user,long id);
		
		public void deleteUserById(Long id);
}
