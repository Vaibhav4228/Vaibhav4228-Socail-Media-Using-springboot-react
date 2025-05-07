package com.vaibhav.service;

import com.vaibhav.exception.CommentException;
import com.vaibhav.exception.PostException;
import com.vaibhav.exception.UserException;
import com.vaibhav.model.Comments;

public interface CommentService {
	
	public Comments createComment(Comments comment,Integer postId,Integer userId) throws PostException, UserException;

	public Comments findCommentById(Integer commentId) throws CommentException;
	public Comments likeComment(Integer CommentId,Integer userId) 
			throws UserException, CommentException;
}
