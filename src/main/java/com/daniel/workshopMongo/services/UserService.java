package com.daniel.workshopMongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.workshopMongo.domain.User;
import com.daniel.workshopMongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll()
	{
		return repo.findAll();
	}
	
}
