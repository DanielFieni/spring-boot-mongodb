package com.daniel.workshopMongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.workshopMongo.domain.Post;
import com.daniel.workshopMongo.resources.util.URL;
import com.daniel.workshopMongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id)
	{
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text)
	{
		text = URL.decodeURL(text);
		List<Post> listPost = service.findTitle(text);
		return ResponseEntity.ok().body(listPost);
	}
	
	@GetMapping(value="/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text", defaultValue = "") String text,
			@RequestParam(value="minDate", defaultValue="") String minDate,
			@RequestParam(value="maxDate", defaultValue="") String maxDate)
	{
		text = URL.decodeURL(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		List<Post> listPost = service.searchAllTitle(text, min, max);
		return ResponseEntity.ok().body(listPost);
				
	}
	
//	@GetMapping(value="/fullsearch")
// 	public ResponseEntity<List<Post>> fullSearcha(
// 			@RequestParam(value="text", defaultValue="") String text,
// 			@RequestParam(value="minDate", defaultValue="") String minDate,
// 			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
//		text = URL.decodeParam(text);
//		Date min = URL.convertDate(minDate, new Date(0L));
//		Date max = URL.convertDate(maxDate, new Date());
//		List<Post> list = service.fullSearch(text, min, max);
//		return ResponseEntity.ok().body(list);
//	}
	
}
