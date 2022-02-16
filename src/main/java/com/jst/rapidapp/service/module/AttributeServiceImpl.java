package com.jst.rapidapp.service.module;


import com.jst.rapidapp.beans.ModuleAttributes;
import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.dao.module.AttributeDAO;
import com.jst.rapidapp.dao.module.ModuleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService{

    @Autowired
    AttributeDAO attributeDAO;

    @Override
    public ModuleAttributes createModuleAttribute(ModuleAttributes moduleAttributes) {
        return attributeDAO.saveModuleMaster(moduleAttributes);
    }

    @Override
    public ModuleAttributes updateModuleAttribute(long id, ModuleAttributes moduleAttributes) {
        return null;
    }

    @Override
    public void deleteModuleAttribute(long id) {

    }

    @Override
    public List<ModuleAttributes> getAllModuleAttribute() {
        return null;
    }

    @Override
    public ModuleAttributes findModuleAttributeById(long id) {
        return attributeDAO.getModuleAttributeById(id);
    }

    @Override
    public List<ModuleAttributes> findModuleAttributeByModuleMasterId(long id) {
        return attributeDAO.getModuleAttributeByModuleMasterId(id);
    }


}
