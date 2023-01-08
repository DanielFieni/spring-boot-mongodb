package com.daniel.workshopMongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.workshopMongo.domain.Post;
import com.daniel.workshopMongo.repository.PostRepository;
import com.daniel.workshopMongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	// Find post by id
	public Post findById(String id)
	{
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	// Find text in a title
	public List<Post> findTitle(String text)
	{
		return repository.searchByTitle(text);
	}
	
	public List<Post> searchAllTitle(String text, Date minDate, Date maxDate)
	{
		return repository.findAllTitle(text, minDate, maxDate);
	}
	
}
