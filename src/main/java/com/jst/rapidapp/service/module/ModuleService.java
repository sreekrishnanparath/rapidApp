package com.jst.rapidapp.service.module;


import com.jst.rapidapp.beans.ModuleAttributes;
import com.jst.rapidapp.beans.ModuleMaster;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ModuleService {

    public ModuleMaster createModuleMaster(ModuleMaster moduleMaster);
    public ModuleMaster updateModuleMaster(long id, ModuleMaster moduleMaster);
    public void deleteModuleMaster(long id);
    public List<ModuleMaster> getAllModuleMaster();
    public ModuleMaster findModuleMasterById(long id);
    public List<ModuleMaster> findModuleByCompanyId(long id);
    public void deleteModule(long id);
    public List<ModuleMaster> getAllModules();
    public ModuleMaster updateModule(long id,ModuleMaster module);
    public List<ModuleMaster> findAllModulesTransCount();
}
