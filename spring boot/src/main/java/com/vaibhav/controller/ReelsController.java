package com.vaibhav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vaibhav.dto.ReelsDto;
import com.vaibhav.mapper.ReelsDtoMapper;
import com.vaibhav.exception.UserException;
import com.vaibhav.model.Reels;
import com.vaibhav.model.User;
import com.vaibhav.service.ReelsService;
import com.vaibhav.service.UserService;

@RestController
@RequestMapping("/api/reels")
public class ReelsController {
	
	@Autowired
	private ReelsService reelsService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<ReelsDto> createReels(@RequestBody Reels reel,
			@RequestHeader("Authorization") String jwt) throws UserException{
		User user =userService.findUserProfileByJwt(jwt);
		Reels newReels=reelsService.createReel(reel, user);
		
		ReelsDto reelsDto=ReelsDtoMapper.toReelsDto(newReels);
		
		return new ResponseEntity<>(reelsDto,HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public ResponseEntity<List<ReelsDto>> getAllReels(
			@RequestHeader("Authorization") String jwt) throws UserException{
		User user =userService.findUserProfileByJwt(jwt);
		List<Reels> reels=reelsService.findAllReels();
		
		List<ReelsDto> reelsDtos=ReelsDtoMapper.toReelsDtos(reels);
		
		return new ResponseEntity<>(reelsDtos,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<ReelsDto>> getUsersReels(
			@RequestHeader("Authorization") String jwt,@PathVariable Integer userId) throws UserException{
		User user =userService.findUserProfileByJwt(jwt);
		List<Reels> reels=reelsService.findUsersReel(userId);
		
		List<ReelsDto> reelsDtos=ReelsDtoMapper.toReelsDtos(reels);
		
		return new ResponseEntity<>(reelsDtos,HttpStatus.ACCEPTED);
	}
}
