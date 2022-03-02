package com.jst.rapidapp.service.module;


import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.dao.module.ModuleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService{

    @Autowired
    ModuleDAO moduleDAO;

    @Override
    public ModuleMaster createModuleMaster(ModuleMaster moduleMaster) {
        return moduleDAO.saveModuleMaster(moduleMaster);
    }

    @Override
    public ModuleMaster updateModuleMaster(long id, ModuleMaster moduleMaster) {
        return null;
    }

    @Override
    public void deleteModuleMaster(long id) {

    }

    @Override
    public List<ModuleMaster> getAllModuleMaster() {
        return null;
    }

    @Override
    public ModuleMaster findModuleMasterById(long id) {
        return moduleDAO.getModuleMasterById(id);
    }

    @Override
    public List<ModuleMaster> findModuleByCompanyId(long id) {
        return moduleDAO.getModuleAttributeByCompanyId(id);
    }

    @Override
    public void deleteModule(long moduleId) {
        moduleDAO.deleteModuleById(moduleId);
    }

    @Override
    public List<ModuleMaster> getAllModules() {
        return moduleDAO.getAllModules();
    }

    @Override
    public ModuleMaster updateModule(long id,ModuleMaster module) {
        return moduleDAO.updateModule(id,module);
    }

}
