package com.jst.rapidapp;

import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.dao.user.UserDAO;
import com.jst.rapidapp.repository.user.UserRepository;
import com.jst.rapidapp.service.user.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RapidappApplicationUserTests {


	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	public UserDAO userDAO;

	@Mock
	public UserRepository userRepository;


	@Test
	public void testUserService_userLogin(){
		User user = new User(1,"hari","krishnan",29,"abc@g.com");
		when(userDAO.getUserByEmail("abc@g.com")).thenReturn(user);
		User resultData = userServiceImpl.findUserByEmailId("abc@g.com");
		System.out.println(resultData);
		assertEquals("hari",resultData.getUserName());
	}

}
