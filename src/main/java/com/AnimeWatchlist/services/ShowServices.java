package com.AnimeWatchlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AnimeWatchlist.entities.Show;
import com.AnimeWatchlist.repo.ShowRepository;

@Service
public class ShowServices {
	
	@Autowired
	ShowRepository sr;
	
	// Saves show entity to Db
	public Show addShow(Show show) {
		return sr.save(show);
	}
	
	// Queries Db for Show entity by showname
	public Show getShow(String showname) {
		return sr.getShowByShowName(showname);
	}
	
	// Returns a list of all Show entities in the Db
	public List<Show> getAllShows(){
		return sr.findAll();
	}
}
