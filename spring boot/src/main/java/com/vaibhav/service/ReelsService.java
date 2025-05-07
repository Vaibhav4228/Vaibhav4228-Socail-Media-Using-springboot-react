package com.vaibhav.service;

import java.util.List;

import com.vaibhav.exception.UserException;
import com.vaibhav.model.Reels;
import com.vaibhav.model.User;

public interface ReelsService {
	
	public Reels createReel(Reels reel,User user);
	public List<Reels> findAllReels();
	public List<Reels> findUsersReel(Integer userId) throws UserException;

}
