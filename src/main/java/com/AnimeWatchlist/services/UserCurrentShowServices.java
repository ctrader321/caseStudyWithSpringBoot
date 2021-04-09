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
		
	public UserCurrentShow saveUserCurrentShow(UserCurrentShow currentShow) {
		return ucsr.save(currentShow);
	}
	
	public UserCurrentShow getUserCurrentShow(String username, String showName) {
		return ucsr.getUserCurrentShowByUsernameAndShowName(username, showName);
	}
	
	public UserCurrentShow linkUserCurrentShowToUser(String username, String showName, int totalEpisodes, int currentEpisode) {
		UserCurrentShow userCurrentShow = new UserCurrentShow(username, showName, totalEpisodes, currentEpisode);
		return ucsr.save(userCurrentShow);
	}
	
	public UserCurrentShow updateShowCurrentEpisode(String username, String showName, int currentEpisode) {
		UserCurrentShow showToUpdate = ucsr.getUserCurrentShowByUsernameAndShowName(username, showName);
		showToUpdate.setCurrentEpisode(currentEpisode);
		return ucsr.save(showToUpdate);
	}
	
	public List<UserCurrentShow> getAllUserCurrentShowByUsername(String username){
		return ucsr.findAllByUsernameOrderByCompletionPercentageAscTotalEpisodesDesc(username);
		
	}
	
	@Transactional
	public void removeUserCurrentShowByUser(String username, String showName) {
		us.getUser(username).getCurrentShowList().remove(shs.getShow(showName));
		ucsr.deleteUserCurrentShowByUsernameAndShowName(username, showName);
	}
}
