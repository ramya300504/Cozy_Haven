package com.hexaware.cozyhaven.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.cozyhaven.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u")
	List<User> getallUsers();
	
	@Query("select count(u) from User u")
	long countTotalUsers();
	
	Optional<User> findByEmail(String email);

}
