package com.harshit.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	//implement methods to perform operations on the user
	//we will use JPA / Hibernate later
	
	private static List<User> users = new ArrayList<>();
	private static Integer usersCount = 0;
	
	static {
		users.add( new User(++usersCount,"Adam", LocalDate.now().minusYears(30)));
		users.add( new User(++usersCount,"Niggesh", LocalDate.now().minusYears(31)));
		users.add( new User(++usersCount,"Ramesh", LocalDate.now().minusYears(25)));
		users.add( new User(++usersCount,"Jim Bro", LocalDate.now().minusYears(28)));
		users.add( new User(++usersCount,"Latifi", LocalDate.now().minusYears(26)));
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users
		.stream()
//		.filter(user -> user.getId().equals(id))
		.filter(predicate)
		.findFirst()
		.get();
	}


	public void save(User user) {
		user.setId(++usersCount);
		users.add( user);	
	}
	 
}
