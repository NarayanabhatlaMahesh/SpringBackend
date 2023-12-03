package com.example.demo.Controllers;

import java.util.List;
//import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Classes.UserAuthentication;
import com.example.demo.Repositories.UserAuthenticationRepo;

//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

@Controller
@RestController
public class UserController {

	@Autowired
	public UserAuthenticationRepo userauthrepo;

	@GetMapping(path = "/")
	public String Getlogin()
	{
		return "redirect:login";
	}
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Postlogin(@RequestBody Map<String, String> data)
	{
		List<UserAuthentication> val = userauthrepo.findByUsernameAndPassword(data.get("username"),data.get("password"));
		val.get(0).display();
		if (val.size()>0)
		return "success";
		else return "nope";
	}
	
	@GetMapping(path = "/userinfo")
	public @ResponseBody Iterable<UserAuthentication> getUserList()
	{
		return userauthrepo.findAll();
	}
	
	
	@PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String reisterUser(@RequestBody Map<String,String> data)
	{
		String username = data.get("username");
		String password = data.get("password");
		String location = data.get("location");
		long phoneNumber = Long.parseLong(data.get("phonenumber"));
		System.out.println(username+" "+password+" "+location+" "+phoneNumber);
		UserAuthentication ua = new UserAuthentication(username, password, location, phoneNumber);
		System.out.println(ua);
		userauthrepo.save(ua);
		
		return "success";
	}
}