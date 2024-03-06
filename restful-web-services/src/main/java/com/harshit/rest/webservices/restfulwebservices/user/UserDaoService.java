package com.harshit.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	//implement methods to perform operations on the user
	//we will use JPA / Hibernate later
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add( new User(1,"Adam", LocalDate.now().minusYears(30)));
		users.add( new User(2,"Niggesh", LocalDate.now().minusYears(31)));
		users.add( new User(3,"Ramesh", LocalDate.now().minusYears(25)));
		users.add( new User(4,"Jim Bro", LocalDate.now().minusYears(28)));
		users.add( new User(5,"Latifi", LocalDate.now().minusYears(26)));
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(Integer id) {
		users
		.stream()
		.filter(user -> user.getId().equals(id))
		.findFirst()
		.get();
	}
}
