package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface UserService  {

	List<User> fetchUserDetails();

	User getDetailsById(Integer id);

	User addUserDetail(User user);

	User updateUser(User user);

	String deleteUser(Integer id);

}
