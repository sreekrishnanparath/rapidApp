package com.jst.rapidapp;

import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.dao.module.AttributeDAO;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RapidappApplicationModuleTests {


	@InjectMocks
	ModuleServiceImpl moduleServiceImpl;

	@Mock
	public ModuleDAO moduleDAO;

	@Mock
	public AttributeDAO attributeDAO;
	@Mock
	public ModuleRepository moduleRepository;


	@Test
	public void test_getModuleById(){
		ModuleMaster module = new ModuleMaster(1,1,"New Survery Module 2","created",false,null,0);
		when(moduleDAO.getModuleMasterById(1)).thenReturn(module);
		ModuleMaster resultData = moduleServiceImpl.findModuleMasterById(1);
		assertEquals("New Survery Module 2",resultData.getModuleDesc());
	}
	@Test
	public void test_getModuleById_WithNoIDExist(){
		ModuleMaster module = new ModuleMaster(1,1,"New Survery Module 2","created",false,null,0);
		when(moduleDAO.getModuleMasterById(1)).thenReturn(module);
		ModuleMaster resultData = moduleServiceImpl.findModuleMasterById(1);
		assertEquals(null,resultData.getModuleDesc());
	}
	@Test
	public void test_getModulesByCompanyId() {
		int companyId = 1;
		List<ModuleMaster> listOfModule = new ArrayList<ModuleMaster>();
		listOfModule.add(new ModuleMaster(1,companyId,"Survey 1","created",false,null,0));
		listOfModule.add(new ModuleMaster(2,companyId,"Survey 2","created",false,null,0));
		listOfModule.add(new ModuleMaster(3,companyId,"Survey 3","created",false,null,0));
		when(moduleDAO.getModuleAttributeByCompanyId(companyId)).thenReturn(listOfModule);
		List<ModuleMaster> resultData = moduleServiceImpl.findModuleByCompanyId(companyId);
		assertEquals(resultData,listOfModule);
	}
	@Test
	public void test_getAllModules() {
		List<ModuleMaster> listOfModule = new ArrayList<ModuleMaster>();
		listOfModule.add(new ModuleMaster(1,1,"Survey 1","created",false,null,0));
		listOfModule.add(new ModuleMaster(2,2,"Survey 2","created",false,null,0));
		listOfModule.add(new ModuleMaster(3,3,"Survey 3","created",false,null,0));
		when(moduleDAO.getAllModules()).thenReturn(listOfModule);
		List<ModuleMaster> resultData = moduleServiceImpl.getAllModules();
		assertEquals(listOfModule,resultData);
	}
	@Test
	public void test_updateModuleDescription()
	{
		ModuleMaster module = new ModuleMaster(1,1,"Survery 2","created",false,null,0);
		when(moduleDAO.updateModule(module.getModuleId(),module)).thenReturn(module);
		//update description
		module.setModuleDesc("New survery description");
		when(moduleDAO.saveModuleMaster(module)).thenReturn(module);
		ModuleMaster resultData = moduleServiceImpl.updateModule(1,module);
		assertEquals(resultData,module);
	}
	@Test
	public void test_updateModuleStatus()
	{
		ModuleMaster module = new ModuleMaster(1,1,"Survery 2","created",false,null,0);
		when(moduleDAO.updateModule(module.getModuleId(),module)).thenReturn(module);
		//update status
		module.setStatus("created");
		when(moduleDAO.updateModule(module.getModuleId(),module)).thenReturn(module);
		ModuleMaster resultData = moduleServiceImpl.updateModule(1,module);
		assertEquals(resultData,module);
	}
	@Test
	public void test_deleteModuleById()
	{
		ModuleMaster module = new ModuleMaster(1,1,"Survery 3","created",false,null,0);

		when(moduleDAO.getModuleMasterById(module.getModuleId())).thenReturn(module);
		moduleDAO.deleteModuleById(1);
		boolean resultData = moduleServiceImpl.existModule(1);
		assertTrue(resultData==moduleDAO.existModule(1));
	}
}
