package com.jst.rapidapp;

import com.jst.rapidapp.beans.Company;
import com.jst.rapidapp.beans.ModuleAttributes;
import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.dao.comapany.CompanyDao;
import com.jst.rapidapp.service.company.CompanyServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
public class RapidappApplicationCompanyTests {


    @InjectMocks
    CompanyServiceImpl companyServiceImpl;

    @Mock
    public CompanyDao companyDao;

    Company company ;
    Company simpleCompany;
    List <Company> listOfCompany = new ArrayList<>();;
    @Before
    public void setup()
    {
        List <User> users = new ArrayList<User>();
        users.add(new User(1,"bob","davis",20,"bob@asd.com",0,"asd"));
        users.add(new User(2,"chris","davis",20,"chris@asd.com",0,"asd"));
        List<ModuleMaster> listOfModule = new ArrayList<ModuleMaster>();
        listOfModule.add(new ModuleMaster(1,1,"Survey 1","created",false,null,0));
        listOfModule.add(new ModuleMaster(2,1,"Survey 2","created",false,null,0));
        List<ModuleAttributes> atrributes = new ArrayList<>();

        company = new Company(1,"Google","Chris","created",true,
                users,listOfModule,atrributes);
        System.out.println(company);

        simpleCompany = new Company(1,"Amazon","chris","created",true);

        listOfCompany.add(new Company(1,"Amazon","chris","created",true));
        listOfCompany.add(new Company(1,"Google","bob","created",true));
    }
    @After
    public void teardown()
    {
        company = null;
        simpleCompany= null;
        listOfCompany = null;
    }
    @Test
    public void test_getCompanyById_exist(){

        when(companyDao.getCompanyById(1)).thenReturn(company);
        Company resultData = companyServiceImpl.getCompanyById(1);
        assertEquals(company,resultData);
    }
    @Test
    public void test_getCompanyById_notExist(){
        when(companyDao.getCompanyById(1)).thenReturn(null);
        Company resultData = companyServiceImpl.getCompanyById(1);
        assertEquals(null,resultData);

    }
    @Test
    public void test_createCompanyFail()
    {
        when(companyDao.createCompany(simpleCompany)).thenReturn(null);
        Company resultData = companyServiceImpl.createCompany(simpleCompany);
        assertEquals(null,resultData);
    }
    @Test
    public void test_createCompanySuccess()
    {
        when(companyDao.createCompany(simpleCompany)).thenReturn(simpleCompany);
        Company resultData = companyServiceImpl.createCompany(simpleCompany);
        assertEquals(simpleCompany,resultData);
    }
    @Test
    public void test_updateCompanyInfo()
    {
        simpleCompany.setCompanyName("new Company name");
        System.out.println(simpleCompany);
        when(companyDao.updateCompany(simpleCompany.getCompanyId(),simpleCompany)).thenReturn(simpleCompany);
        Company resultData = companyServiceImpl.updateCompany(simpleCompany.getCompanyId(),simpleCompany);
        assertEquals("new Company name",resultData.getCompanyName());

    }

    @Test
    public void test_getAllCompany()
    {
        when(companyDao.getAllCompanies()).thenReturn(listOfCompany);
        List<Company> resultData = companyServiceImpl.getAllCompanies();
        assertEquals(listOfCompany.size(),resultData.size());
        assertEquals(listOfCompany,resultData);
    }

    @Test
    public void test_getAllCompany_emptyList()
    {
        List<Company> empty = new ArrayList<>();
        when(companyDao.getAllCompanies()).thenReturn(empty);
        List<Company> resultData = companyServiceImpl.getAllCompanies();
        assertEquals(0,resultData.size());
        assertTrue(resultData.isEmpty());

    }

}
