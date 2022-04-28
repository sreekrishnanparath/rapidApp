package com.jst.rapidapp;

import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.dao.user.UserDAO;
import com.jst.rapidapp.repository.user.UserRepository;
import com.jst.rapidapp.service.user.UserServiceImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

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
	public void test_findUserByEmail(){
		User user = new User(1,"hari","krishnan",29,
				"abc@g.com",0,"123");
		when(userDAO.getUserByEmail("abc@g.com")).thenReturn(user);
		User resultData = userServiceImpl.findUserByEmailId("abc@g.com");
		System.out.println(resultData);
		assertEquals("hari",user.getUserName());
	}
	@Test
	public void test_getAllUsers()
	{
		List<User> users = new ArrayList<User>();
		users.add(new User(1,"bob","davis",20,"bob@asd.com",0,"asd"));
		users.add(new User(2,"chris","davis",20,"chris@asd.com",0,"asd"));
		when(userDAO.getUsers()).thenReturn(users);
		List<User> resultData = userServiceImpl.getAllUsers();
		assertEquals(users,resultData);
	}
	@Ignore
	@Test
	public void getUserByEmail()
	{

	}
	@Ignore
	@Test
	public void getUserById()
	{
		User user = new User (1,"bob","",19,"asd@asd.com",1,"asd");
		when(userDAO.getUserById(1)).thenReturn(user);

	}
	@Ignore
	@Test
	public void getUserByEmailAndPassword()
	{

	}
}
