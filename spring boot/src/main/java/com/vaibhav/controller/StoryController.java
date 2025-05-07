//package com.vaibhav.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.vaibhav.exception.StoryException;
//import com.vaibhav.exception.UserException;
//import com.vaibhav.model.Story;
//import com.vaibhav.model.User;
//import com.vaibhav.service.StoryService;
//import com.vaibhav.service.UserService;
//
//@RestController
//@RequestMapping("/api/stories")
//public class StoryController {
//
//	@Autowired
//	private StoryService storyService;
//
//	@Autowired
//	private UserService userService;
//
//	@PostMapping("/create")
//	public ResponseEntity<Story> createStoryHandler(@RequestBody Story story, @RequestHeader("Authorization") String token) throws UserException {
//		User reqUser = userService.findUserProfileByJwt(token);
//		Story createdStory = storyService.createStory(story, reqUser.getId());
//		return new ResponseEntity<>(createdStory, HttpStatus.CREATED);
//	}
//
//	@GetMapping("/{userId}")
//	public ResponseEntity<List<Story>> findAllStoryByUserIdHandler(@PathVariable Integer userId) throws UserException, StoryException {
//		List<Story> stories = storyService.findStoryByUserId(userId);
//		return new ResponseEntity<>(stories, HttpStatus.OK);
//	}
//
//	@GetMapping("/all")  // This endpoint fetches all stories for display
//	public ResponseEntity<List<Story>> getAllStories() {
//		List<Story> stories = storyService.findAllStories();
//		return new ResponseEntity<>(stories, HttpStatus.OK);
//	}
//}


package com.vaibhav.controller;

import com.vaibhav.exception.StoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vaibhav.exception.UserException;
import com.vaibhav.model.Story;
import com.vaibhav.model.User;
import com.vaibhav.service.StoryService;
import com.vaibhav.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/stories")
public class StoryController {

	@Autowired
	private StoryService storyService;

	@Autowired
	private UserService userService;

	// POST endpoint to create a story
	@PostMapping("/create")
	public ResponseEntity<Story> createStoryHandler(
			@RequestBody Story story,  // Request body contains the story data (image URL and captions)
			@RequestHeader("Authorization") String token  // Authorization header contains the JWT token
	) throws UserException {
		// Extract the user from the JWT token
		User reqUser = userService.findUserProfileByJwt(token);

		// Set user and timestamp for the story
		story.setUser(reqUser);
		story.setTimestamp(LocalDateTime.now());

		// Save the story in the database
		Story createdStory = storyService.createStory(story, reqUser.getId());

		return new ResponseEntity<>(createdStory, HttpStatus.CREATED);  // Return the created story with status 201
	}

	// GET endpoint to fetch stories by user ID
	@GetMapping("/{userId}")
	public ResponseEntity<List<Story>> findAllStoryByUserIdHandler(
			@PathVariable Integer userId
	) throws UserException, StoryException {
		List<Story> stories = storyService.findStoryByUserId(userId);
		return new ResponseEntity<>(stories, HttpStatus.OK);
	}

	// GET endpoint to fetch all stories (for displaying)
	@GetMapping("/all")
	public ResponseEntity<List<Story>> getAllStories() {
		List<Story> stories = storyService.findAllStories();
		return new ResponseEntity<>(stories, HttpStatus.OK);
	}
}
