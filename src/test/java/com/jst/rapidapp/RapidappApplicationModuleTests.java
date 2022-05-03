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
import org.junit.Before;
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

	@Test
	public void test_getModuleById_ModuleExist(){
		ModuleMaster module = new ModuleMaster(1,1,"New Survey Module 2","created",false,null,0);
		when(moduleDAO.getModuleMasterById(1)).thenReturn(module);
		ModuleMaster resultData = moduleServiceImpl.findModuleMasterById(1);
		assertEquals("New Survey Module 2",resultData.getModuleDesc());
	}
	@Test
	public void test_getModuleById_NoModuleExist(){
		ModuleMaster module = new ModuleMaster(1,1,"New Survey Module 2","created",false,null,0);
		when(moduleDAO.getModuleMasterById(1)).thenReturn(module);
		ModuleMaster resultData = moduleServiceImpl.findModuleMasterById(2);
		assertNull(null,resultData);
	}
	@Test
	public void test_getModulesByCompanyId_CompanyIdExist() {
		int companyId = 1;
		List<ModuleMaster> listOfModule = new ArrayList<ModuleMaster>();
		listOfModule.add(new ModuleMaster(1,companyId,"Survey 1","created",false,null,0));
		listOfModule.add(new ModuleMaster(2,companyId,"Survey 2","created",false,null,0));
		listOfModule.add(new ModuleMaster(3,companyId,"Survey 3","created",false,null,0));
		 ModuleMaster expectModule =new ModuleMaster(2,companyId,"Survey 2","created",false,null,0);
		when(moduleDAO.getModuleAttributeByCompanyId(companyId)).thenReturn(listOfModule);
		List<ModuleMaster> resultData = moduleServiceImpl.findModuleByCompanyId(companyId);
		assertEquals(3,resultData.size());
		assertEquals(expectModule,resultData.get(1));
	}
	@Test
	public void test_getListOfModulesByCompanyId_NoCompanyIdExist() {
		int companyId = 1;
		List<ModuleMaster> listOfModule = new ArrayList<ModuleMaster>();
		listOfModule.add(new ModuleMaster(1,companyId,"Survey 1","created",false,null,0));
		listOfModule.add(new ModuleMaster(2,companyId,"Survey 2","created",false,null,0));
		listOfModule.add(new ModuleMaster(3,companyId,"Survey 3","created",false,null,0));
		when(moduleDAO.getModuleAttributeByCompanyId(companyId)).thenReturn(listOfModule);
		List<ModuleMaster> expectList = new ArrayList<ModuleMaster>();
		List<ModuleMaster> resultData = moduleServiceImpl.findModuleByCompanyId(2);
		assertEquals(0,resultData.size());
		assertEquals(expectList,resultData);
	}

	@Test
	public void test_getAllModules_dataExist() {
		List<ModuleMaster> listOfModule = new ArrayList<ModuleMaster>();
		listOfModule.add(new ModuleMaster(1,1,"Survey 1","created",false,null,0));
		listOfModule.add(new ModuleMaster(2,2,"Survey 2","created",false,null,0));
		listOfModule.add(new ModuleMaster(3,3,"Survey 3","created",false,null,0));
		when(moduleDAO.getAllModules()).thenReturn(listOfModule);
		List<ModuleMaster> resultData = moduleServiceImpl.getAllModules();
		assertEquals(3,resultData.size());
	}
	@Test
	public void test_getAllModules_EmptyList() {
		List<ModuleMaster> listOfModule = new ArrayList<ModuleMaster>();
		when(moduleDAO.getAllModules()).thenReturn(listOfModule);
		List<ModuleMaster> resultData = moduleServiceImpl.getAllModules();
		assertEquals(true,resultData.isEmpty());
	}
	@Test
	public void test_updateModuleDescription()
	{
		ModuleMaster module = new ModuleMaster(1,1,"Survey 2","created",false,null,0);
		when(moduleDAO.updateModule(module.getModuleId(),module)).thenReturn(module);
		module.setModuleDesc("New survery description");
		ModuleMaster resultData = moduleServiceImpl.updateModule(1,module);
		assertEquals("New survery description",resultData.getModuleDesc());
	}
	@Test
	public void test_updateModuleStatus()
	{
		ModuleMaster module = new ModuleMaster(1,1,"Survey 2","created",false,null,0);
		when(moduleDAO.updateModule(module.getModuleId(),module)).thenReturn(module);
		//update status
		module.setStatus("update");
		ModuleMaster resultData = moduleServiceImpl.updateModule(1,module);
		System.out.println(resultData);
		assertEquals("update",resultData.getStatus());
	}
	@Test
	public void test_CreateModule()
	{
		ModuleMaster module = new ModuleMaster(1,1,"Survey 3","created",false,null,0);

		//CREATE MODULE
		when(moduleDAO.saveModuleMaster(module)).thenReturn(module);
		//CHECK DOES IT CREATE
		ModuleMaster resultData =  moduleServiceImpl.createModuleMaster(module);
		assertEquals(module,resultData);


	}
}
