package com.AnimeWatchlist.service.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.AnimeWatchlist.entities.User;
import com.AnimeWatchlist.repo.UserRepository;
import com.AnimeWatchlist.services.UserServices;


@SpringBootTest
class UserServicesTests {
	
	@Autowired
	UserServices us;
	
	@Autowired
	UserRepository ur;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddUser() {
		User user = new User("testUser", "testPassword");
		User saved = us.addUser(user);
		assertNotNull(saved);
	}

	@Test
	@Transactional
	void testGetUser() {
		String name = "testUser";
		User user = us.getUser(name);
		assertNotNull(user);
	}

	@Test
	@Transactional
	void testGetAllUsers() {
		List<User> all = us.getAllUsers();
		assertNotNull("list is null", all);
	}

	@Test
	@Transactional
	void testValidateUser() {
		User validated = us.validateUser("testUser", "testPassword");
		User expected = us.getUser("testUser");
		assertEquals(expected, validated);
	}

}
