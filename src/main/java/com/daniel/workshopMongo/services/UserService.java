package com.daniel.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.workshopMongo.domain.User;
import com.daniel.workshopMongo.dto.UserDTO;
import com.daniel.workshopMongo.repository.UserRepository;
import com.daniel.workshopMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll()
	{
		return repo.findAll();
	}
	
	public User findById(String id)
	{
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object No Found"));
	}
	
	// Insert new user in database
	public User insert(User obj)
	{
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO obj)
	{
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	
}
