package com.jst.rapidapp.dao.module;


import com.jst.rapidapp.beans.ModuleAttributes;
import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.repository.module.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModuleDAO {

    @Autowired
    ModuleRepository moduleRepository;


    public ModuleMaster saveModuleMaster(ModuleMaster moduleMaster){
        return moduleRepository.saveAndFlush(moduleMaster);
    }

    public ModuleMaster getModuleMasterById(long id){
        return moduleRepository.findById(id);
    }

    public List<ModuleMaster> getModuleAttributeByCompanyId(long id){
        return moduleRepository.findByCompanyId(id);
    }
    //delete module by id
    public void deleteModuleById(long id){
        moduleRepository.deleteById(id);
    }
    //get all module
    public List<ModuleMaster> getAllModules()
    {
        return moduleRepository.findAll();
    }
    //update module (only able to update status and module description)
    public ModuleMaster updateModule(long id, ModuleMaster module)
    {
        ModuleMaster exisingModule = moduleRepository.findById(id);
        exisingModule.setModuleDesc(module.getModuleDesc());
        exisingModule.setStatus(module.getStatus());
        return moduleRepository.saveAndFlush(exisingModule);

    }

    public List<ModuleMaster> findAllModulesTransCount() {
        return moduleRepository.findAllModulesTransCount();
    }
}
