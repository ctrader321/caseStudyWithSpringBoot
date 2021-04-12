package com.AnimeWatchlist.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AnimeWatchlist.entities.UserCurrentShow;
import com.AnimeWatchlist.repo.UserCurrentShowRepository;

@Service
public class UserCurrentShowServices {

	@Autowired
	UserCurrentShowRepository ucsr;
	
	@Autowired
	UserServices us;
	
	@Autowired
	ShowServices shs;
		
	// Saves a UserCurrentShow entity to Database
	public UserCurrentShow saveUserCurrentShow(UserCurrentShow currentShow) {
		return ucsr.save(currentShow);
	}
	
	// Queries Db for a UserCurrentShow by username and showName
	public UserCurrentShow getUserCurrentShow(String username, String showName) {
		return ucsr.getUserCurrentShowByUsernameAndShowName(username, showName);
	}
	
	public UserCurrentShow linkUserCurrentShowToUser(String username, String showName, int totalEpisodes, int currentEpisode) {
		UserCurrentShow userCurrentShow = new UserCurrentShow(username, showName, totalEpisodes, currentEpisode);
		return ucsr.save(userCurrentShow);
	}
	
	// Queries Db for UserCurrentShow and sets their current episode, repersists the entity afterward with update.
	public UserCurrentShow updateShowCurrentEpisode(String username, String showName, int currentEpisode) {
		UserCurrentShow showToUpdate = ucsr.getUserCurrentShowByUsernameAndShowName(username, showName);
		showToUpdate.setCurrentEpisode(currentEpisode);
		return ucsr.save(showToUpdate);
	}
	
	// Queries Db for a list of UserCurrentShow entities by username.
	public List<UserCurrentShow> getAllUserCurrentShowByUsername(String username){
		return ucsr.findAllByUsernameOrderByCompletionPercentageAscTotalEpisodesDesc(username);
		
	}
	
	
	@Transactional
	public void removeUserCurrentShowByUser(String username, String showName) {
		us.getUser(username).getCurrentShowList().remove(shs.getShow(showName));
		ucsr.deleteUserCurrentShowByUsernameAndShowName(username, showName);
	}
}
