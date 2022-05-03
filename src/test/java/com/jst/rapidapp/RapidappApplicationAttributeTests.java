package com.jst.rapidapp;

import com.jst.rapidapp.beans.Company;
import com.jst.rapidapp.beans.ModuleAttributes;
import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.dao.comapany.CompanyDao;
import com.jst.rapidapp.dao.module.AttributeDAO;
import com.jst.rapidapp.service.company.CompanyServiceImpl;
import com.jst.rapidapp.service.module.AttributeService;
import com.jst.rapidapp.service.module.AttributeService;
import com.jst.rapidapp.service.module.AttributeServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.print.attribute.Attribute;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RapidappApplicationAttributeTests {

    @InjectMocks
    AttributeServiceImpl attributeServiceImpl;

    @Mock
    public AttributeDAO attributeDAO;

    ModuleAttributes attribute ;
    List<ModuleAttributes> ListOfAttributes = new ArrayList<>();
    @Before
    public void setup()
    {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        attribute = new ModuleAttributes(1,1,2, "Question1",1,1, 1,"style","create",false,timestamp, 1,1,"city");
        ListOfAttributes.add(new ModuleAttributes(1,1,1,"Question2",1,1,1,"style","create",false,timestamp,1,1,"city"));
        ListOfAttributes.add(new ModuleAttributes(2,1,1,"Question3",1,1,1,"style","create",false,timestamp,1,1,"city"));
        ListOfAttributes.add(new ModuleAttributes(3,1,1,"Button",1,1,1,"style","create",false,timestamp,1,1,"city"));

    }
    @After
    public void teardown()
    {
        ListOfAttributes = new ArrayList<>();
        attribute = null;
    }

    @Test
    public void test_getModuleAttributeByModuleMasterId()
    {
        when(attributeDAO.getModuleAttributeByModuleMasterId(1)).thenReturn(ListOfAttributes);
        List <ModuleAttributes> resultData = attributeServiceImpl.findModuleAttributeByModuleMasterId(1);
        assertEquals(ListOfAttributes,resultData);
    }
    @Test
    public void test_getModuleAttributeByModuleMasterId_emptyList(){
        List<ModuleAttributes> empty = new ArrayList<>();
        when(attributeDAO.getModuleAttributeByModuleMasterId(1)).thenReturn(empty);
        List <ModuleAttributes> resultData = attributeServiceImpl.findModuleAttributeByModuleMasterId(1);
        assertEquals(empty.size(),resultData.size());
    }
    @Test
    public void test_getAllAttributes(){
        when(attributeDAO.getAllAttribute()).thenReturn(ListOfAttributes);
        List <ModuleAttributes> resultData = attributeServiceImpl.getAllAttribute();
        assertEquals(ListOfAttributes.size(),resultData.size());
    }
    @Test
    public void test_getAllAttributesEmptyList(){
        List<ModuleAttributes> empty = new ArrayList<>();
        when(attributeDAO.getAllAttribute()).thenReturn(empty);
        List <ModuleAttributes> resultData = attributeServiceImpl.getAllAttribute();
        assertEquals(empty.size(),resultData.size());
    }
    @Test
    public void test_updateAttributeDesc(){
        attribute.setAttrDesc("this is your updated question");

        when(attributeDAO.updateAttribute(attribute.getAttributeId(),attribute)).thenReturn(attribute);
        ModuleAttributes resultData = attributeServiceImpl.updateAttribute(attribute.getAttributeId(),attribute);
        assertEquals("this is your updated question",resultData.getAttrDesc());
    }
    @Test
    public void test_getOneAttributesByAttributeId(){
        when(attributeDAO.getModuleAttributeById(1)).thenReturn(attribute);
        ModuleAttributes resultData = attributeServiceImpl.findModuleAttributeById(attribute.getAttributeId());
        assertEquals(attribute, resultData);
    }
    @Test
    public void test_createAttributeSuccess(){
        when(attributeDAO.saveModuleMaster(attribute)).thenReturn(attribute);
        ModuleAttributes resultData = attributeServiceImpl.createModuleAttribute(attribute);
        assertEquals(attribute,resultData);
    }
    @Test
    public void test_createAttributeFail(){
        when(attributeDAO.saveModuleMaster(attribute)).thenReturn(null);
        ModuleAttributes resultData = attributeServiceImpl.createModuleAttribute(attribute);
        assertEquals(null,resultData);
    }

}
