package com.vaibhav.service;

import java.util.List;

import com.vaibhav.exception.StoryException;
import com.vaibhav.exception.UserException;
import com.vaibhav.model.Story;

public interface StoryService {

	public Story createStory(Story story,Integer userId) throws UserException;
	
	public List<Story> findStoryByUserId(Integer userId) throws UserException, StoryException;

	public List<Story> findAllStories();
	
}
