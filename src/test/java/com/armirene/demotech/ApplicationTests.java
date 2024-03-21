package com.armirene.demotech;

import com.armirene.demotech.controller.UsersController;
import com.armirene.demotech.entity.Users;
import com.armirene.demotech.service.UsersService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
class ApplicationTests {


	private static Users users1;

	@Mock
	private UsersService usersService;

	@InjectMocks
	private UsersController usersController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeAll
	public static void init() {
		users1 = new Users(97,"mickey","mouse","mickey@disney.com");
	}

	@Test
	public void contextLoads() {
	}
	@Test
	void create() {


	}

}


