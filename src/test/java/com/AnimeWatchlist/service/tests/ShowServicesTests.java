package com.AnimeWatchlist.service.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.AnimeWatchlist.entities.Show;
import com.AnimeWatchlist.services.ShowServices;

@SpringBootTest
class ShowServicesTests {

	@Autowired
	ShowServices ss;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testAddShow() {
		Show test = ss.addShow(new Show("testShow", 1));
		assertNotNull(test);
	}
	
	@Transactional
	@Test
	void testGetShow() {
		String name = "testShow";
		Show found = ss.getShow(name);
		assertNotNull(found);
	}
	
	@Transactional
	@Test
	void testGetAllShows() {
		List<Show> all = ss.getAllShows();
		assertNotNull(all);
	}
}
