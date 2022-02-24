package com.jst.rapidapp.dao.module;


import com.jst.rapidapp.beans.ModuleAttributes;
import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.repository.module.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AttributeDAO {

    @Autowired
    AttributeRepository moduleAttributeRepository;


    public ModuleAttributes saveModuleMaster(ModuleAttributes moduleAttributes){
        return moduleAttributeRepository.saveAndFlush(moduleAttributes);
    }

    public ModuleAttributes getModuleAttributeById(long id){
        return moduleAttributeRepository.findById(id);
    }

    public List<ModuleAttributes> getModuleAttributeByModuleMasterId(long id){
        return moduleAttributeRepository.findByModuleMasterId(id);
    }
    //get all the attribute
    public List <ModuleAttributes> getAllAttribute() {
        return moduleAttributeRepository.findAll();
    }

    //update attribute (only attribute desc)
    public ModuleAttributes updateAttribute(long attributeId, ModuleAttributes moduleAttributes) {
        ModuleAttributes existingModuleAttributes = moduleAttributeRepository.findById(attributeId);
        existingModuleAttributes.setAttrDesc(moduleAttributes.getAttrDesc());

        moduleAttributeRepository.saveAndFlush(existingModuleAttributes);
        return existingModuleAttributes;
    }
    //delete attribute by id
    public void deleteAttributeById (long attributeId)
    {
        moduleAttributeRepository.deleteById(attributeId);
    }
}
