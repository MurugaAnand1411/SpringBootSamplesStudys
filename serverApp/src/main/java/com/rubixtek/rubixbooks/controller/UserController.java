package com.rubixtek.rubixbooks.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubixtek.rubixbooks.entities.User;
import com.rubixtek.rubixbooks.service.UserService;



@RestController 
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/CreateUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
		userService.saveUser(user);
        URI uri = URI.create("/" + user.getId());
        return ResponseEntity.created(uri).body(user);
    }


	@GetMapping("/GetAllUsers")
    public ResponseEntity<List<User>> getAll() {
        List<User> c = userService.getAllUser();
        if (c == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(c);
    }

	@GetMapping("/GetUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
		User c = userService.getUserbyId(id);
        if (c == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(c);
    }
	
	@PutMapping("/UpdateUser/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long id) {
		User updUser = userService.getUserbyId(id);
		//updUser.setId(user.getId());
		updUser.setId(id);
		updUser.setFirstName(user.getFirstName());
		updUser.setLastName(user.getLastName());
		updUser.setEmail(user.getEmail());
		updUser.setPassword(user.getPassword());
		updUser.setActive(user.isActive());
		userService.updateUser(updUser, id);
        URI uri = URI.create("/" + user.getId());
        return ResponseEntity.created(uri).body(updUser);
    }
	
	 @DeleteMapping("/DeleteUser/{id}")
	    public String deleteUser(@PathVariable long id) {
		 userService.deleteUserById(id);
	        return "Deleted successfully : " + id;
	    }
}
