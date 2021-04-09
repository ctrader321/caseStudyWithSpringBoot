package com.AnimeWatchlist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnimeWatchlist.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User getUserByUsername(String username);

}
