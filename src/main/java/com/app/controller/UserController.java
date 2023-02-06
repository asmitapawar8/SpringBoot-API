package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService us;
	
	@GetMapping
	public List<User> getUsers()
	{
		return us.fetchUserDetails();
	}
	
	@GetMapping("/{id}")
	public User getDetailsById(@PathVariable Integer id)
	{
		return us.getDetailsById(id);
		
	}
	
	@PostMapping
	public User addUser(@RequestBody User user)
	{
		return us.addUserDetail(user);
		
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user)
	{
		return us.updateUser(user);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Integer id)
	{
		return us.deleteUser(id);
	}
}
