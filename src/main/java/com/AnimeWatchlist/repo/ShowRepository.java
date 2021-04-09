package com.AnimeWatchlist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AnimeWatchlist.entities.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, String> {

	Show getShowByShowName(String showname);
}
