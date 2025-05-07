package com.vaibhav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.model.Comments;


public interface CommentRepository extends JpaRepository<Comments, Integer> {

}
