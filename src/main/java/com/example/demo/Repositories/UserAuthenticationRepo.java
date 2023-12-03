package com.example.demo.Repositories;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Classes.UserAuthentication;

public interface UserAuthenticationRepo extends CrudRepository<UserAuthentication, Long> {
	
	List<UserAuthentication> findByUsernameAndPassword(String username, String password);
	
}
