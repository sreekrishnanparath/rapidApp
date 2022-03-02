package com.jst.rapidapp.service.module;


import com.jst.rapidapp.beans.ModuleAttributes;
import com.jst.rapidapp.beans.ModuleMaster;

import java.util.List;


public interface AttributeService {

    public ModuleAttributes createModuleAttribute(ModuleAttributes moduleAttributes);
    public ModuleAttributes updateModuleAttribute(long id, ModuleAttributes moduleAttributes);
    public void deleteModuleAttribute(long id);
    public List<ModuleAttributes> getAllModuleAttribute();
    public ModuleAttributes findModuleAttributeById(long id);
    public List<ModuleAttributes> findModuleAttributeByModuleMasterId(long id);
    public List <ModuleAttributes> getAllAttribute();
    public ModuleAttributes updateAttribute(long attributeId,ModuleAttributes moduleAttributes);
    public void deleteAttributeById(long id);
}
