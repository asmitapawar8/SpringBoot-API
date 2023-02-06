package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customexceptions.EntityException;
import com.app.pojos.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> fetchUserDetails() {

		return userRepo.findAll();
	}

	@Override
	public User getDetailsById(Integer id) {
		return userRepo.findById(id).orElseThrow(()->new EntityException("ID doesn't exists!!"));
	}

	@Override
	public User addUserDetail(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		if(userRepo.findById(user.getId())!=null)
			return userRepo.save(user);
		else
			throw new EntityException("Invalid Id");
	}

	@Override
	public String deleteUser(Integer id) {
		if(userRepo.findById(id)!=null)
			{
			userRepo.deleteById(id);
			return "user deleted having id: "+id;
			}
		
		else
			throw new EntityException("Invalid Id");
	}

	
}
