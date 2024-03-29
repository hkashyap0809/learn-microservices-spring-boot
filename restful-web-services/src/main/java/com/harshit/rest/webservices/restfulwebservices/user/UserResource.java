package com.harshit.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	
	@Autowired
	private UserDaoService userDaoService;
	
	//constructor injection for userDaoService
	public UserResource(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable Integer id) {
		User user =  userDaoService.findOne(id);
		
		if( user == null )	throw new UserNotFoundException("id:"+id);
		
		return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<User> createuser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		// /users/4 => /users/{id}  
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userDaoService.deleteById(id);
	}
	
	

}
