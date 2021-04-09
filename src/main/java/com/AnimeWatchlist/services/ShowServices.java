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
	
	public Show addShow(Show show) {
		return sr.save(show);
	}
	
	public Show getShow(String showname) {
		return sr.getShowByShowName(showname);
	}
	
	public List<Show> getAllShows(){
		return sr.findAll();
	}
}
