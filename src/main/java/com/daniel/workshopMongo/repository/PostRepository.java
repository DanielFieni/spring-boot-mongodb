package com.daniel.workshopMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.daniel.workshopMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
	List<Post> searchByTitle(String text);
	List<Post> findByTitleContainingIgnoreCase(String text);

}
