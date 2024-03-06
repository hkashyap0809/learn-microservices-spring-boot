package com.harshit.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
		return userDaoService.findOne(id);
	}
	
	@PostMapping(path="/users")
	public void createuser(@RequestBody User user) {
		userDaoService.save(user);
		
	}

}
