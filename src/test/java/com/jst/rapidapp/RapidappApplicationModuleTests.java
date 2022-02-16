package com.jst.rapidapp;

import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.dao.module.ModuleDAO;
import com.jst.rapidapp.dao.user.UserDAO;
import com.jst.rapidapp.repository.module.ModuleRepository;
import com.jst.rapidapp.repository.user.UserRepository;
import com.jst.rapidapp.service.module.ModuleServiceImpl;
import com.jst.rapidapp.service.user.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
 import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RapidappApplicationModuleTests {


	@InjectMocks
	ModuleServiceImpl moduleServiceImpl;

	@Mock
	public ModuleDAO moduleDAO;

	@Mock
	public ModuleRepository moduleRepository;


	@Test
	public void testModuleService_userLogin(){
		ModuleMaster module = new ModuleMaster(3,1,"New Survery Module 2","created",false,null,0);
		when(moduleDAO.getModuleMasterById(1)).thenReturn(module);
		ModuleMaster resultData = moduleServiceImpl.findModuleMasterById(1);
		System.out.println(resultData);
		assertEquals("New Survery Module 2",resultData.getModuleDesc());
	}

}
