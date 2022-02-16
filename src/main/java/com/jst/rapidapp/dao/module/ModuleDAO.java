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
}
