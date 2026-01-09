package com.aadiandjava.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aadiandjava.Enitiy.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	Optional<User>findByUsername(String username);
}
