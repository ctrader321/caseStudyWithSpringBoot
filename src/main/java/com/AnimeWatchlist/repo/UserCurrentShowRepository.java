package com.AnimeWatchlist.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AnimeWatchlist.entities.UserCurrentShow;

public interface UserCurrentShowRepository extends JpaRepository<UserCurrentShow, String>{

	UserCurrentShow getUserCurrentShowByUsernameAndShowName(String username, String showName);
	
	void deleteUserCurrentShowByUsernameAndShowName(String username, String showName);
	
	List<UserCurrentShow> findAllByUsernameOrderByCompletionPercentageAscTotalEpisodesDesc(String username);
	
}
