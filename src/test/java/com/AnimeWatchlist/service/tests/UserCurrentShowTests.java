package com.AnimeWatchlist.service.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.AnimeWatchlist.entities.Show;
import com.AnimeWatchlist.entities.User;
import com.AnimeWatchlist.entities.UserCurrentShow;
import com.AnimeWatchlist.services.ShowServices;
import com.AnimeWatchlist.services.UserCurrentShowServices;
import com.AnimeWatchlist.services.UserServices;

@SpringBootTest
class UserCurrentShowTests {

	@Autowired
	UserCurrentShowServices ucss;
	@Autowired
	UserServices us;
	@Autowired
	ShowServices ss;
	
	UserCurrentShow testUserCurrentShow;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception{
		User test = us.addUser(new User("testUser", "testPassword"));
		us.addUser(test);
		ss.addShow(new Show("testShow", 1));
		testUserCurrentShow = new UserCurrentShow("testUser","testShow",1,0);
		ucss.saveUserCurrentShow(testUserCurrentShow);
	}
	@Test
	void testSaveUserCurrentShow() {
		UserCurrentShow actual = ucss.getUserCurrentShow("testUser", "testShow");
		assertEquals(testUserCurrentShow, actual);
	}

	@Test
	@Transactional
	void testLinkUserCurrentShowToUser() {
		UserCurrentShow actual = ucss.linkUserCurrentShowToUser("testUser", "testShow", 1, 0);
		assertEquals(testUserCurrentShow, actual);
	}
	
	@Test
	@Transactional
	void testUpdateShowCurrentEpisode() {
		assertNotNull(ucss.updateShowCurrentEpisode("testUser", "testShow", 1));
	}
	@Test
	@Transactional
	void testGetAllUserCurrentShowByUsername() {
		assertNotNull(ucss.getAllUserCurrentShowByUsername("testUser"));
	}

}
