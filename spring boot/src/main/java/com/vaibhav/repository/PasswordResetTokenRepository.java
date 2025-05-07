package com.vaibhav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {

	PasswordResetToken findByToken(String token);

}
