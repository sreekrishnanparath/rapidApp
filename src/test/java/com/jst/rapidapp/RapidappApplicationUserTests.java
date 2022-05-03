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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RapidappApplicationUserTests {

	@Mock
	PasswordEncoder passwordEncoder;
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
		assertEquals("hari",resultData.getUserName());
	}
	@Test
	public void test_findUserByEmailWithInvalidEmail(){
		User user = new User(1,"hari","krishnan",29,
				"abc@g.com",0,"123");
		when(userDAO.getUserByEmail("abc@g.com")).thenReturn(user);
		User resultData = userServiceImpl.findUserByEmailId("abcd@g.com");
		System.out.println(resultData);
		assertNull(null,resultData);
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

	@Test
	public void test_getUserById()
	{
		User user = new User (1,"bob","",19,"asd@asd.com",1,"asd");
		when(userDAO.getUserById(1)).thenReturn(user);
		User resultData = userServiceImpl.findUserMasterById(1);
		assertEquals("bob",resultData.getUserName());
	}
	@Test
	public void test_getUserById_idDoesNotExist()
	{
		User user = new User (1,"bob","",19,"asd@asd.com",1,"asd");
		when(userDAO.getUserById(1)).thenReturn(null);
		User resultData = userServiceImpl.findUserMasterById(1);
		assertEquals(null,resultData);
	}
	@Test
	public void test_getUserByEmailAndPassword_exist()
	{

		User user = new User (1,"bob","",19,"asd@asd.com",1,"asd");
		when(userDAO.getUserByEmailAndPassword(user.getUserEmail(),user.getPassword())).thenReturn(user);
		User resultData = userServiceImpl.findUserByEmailIdAndPassword("asd@asd.com","asd");
		assertEquals(user.getUserName(),resultData.getUserName());
	}
	@Test
	public void test_getUserByEmailAndPassword_doesNotExist()
	{
		User user = new User (1,"bob","",19,"asd@asd.com",1,"asd");
		when(userDAO.getUserByEmailAndPassword(user.getUserEmail(),user.getPassword())).thenReturn(null);
		User resultData = userServiceImpl.findUserByEmailIdAndPassword("asd@asd.com","asd");
		assertNull(null,resultData);
	}
	@Ignore
	@Test
	public void test_updatePasswordAndPasswordShouldBeEncode()
	{
		String pass = passwordEncoder.encode("asd");
		System.out.println(pass+"pass");
		User user = new User (1,"bob","",19,"asd@asd.com",1,"asd");
		User afterUpdateUser = new User (1,"bob","",19,"asd@asd.com",1,pass);
		when(userDAO.saveUserMaster(user)).thenReturn(afterUpdateUser);
		User resultData = userServiceImpl.updateUser(user,1);
		System.out.println(resultData);

		assertEquals(afterUpdateUser.getPassword(),resultData.getPassword());
		//		assertEquals("asd" , resultData.getPassword());
	}
	@Test
	public void test_createUser()
	{
		User user = new User (1,"bob","",19,"asd@asd.com",1,"asd");
		when(userDAO.saveUserMaster(user)).thenReturn(user);
		User resultData = userServiceImpl.createUserMaster(user);
		System.out.println(resultData);
		assertEquals("bob",resultData.getUserName());
	}
}
