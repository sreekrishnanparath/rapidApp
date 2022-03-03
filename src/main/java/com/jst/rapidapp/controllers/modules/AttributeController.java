package com.jst.rapidapp.controllers.modules;


import com.jst.rapidapp.beans.ModuleAttributes;

import com.jst.rapidapp.service.module.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rapidapp/attr/")
public class AttributeController {

    @Autowired()
    AttributeService attributeService;

    @PostMapping("/create")
    public ResponseEntity<ModuleAttributes> saveModuleAttribute(@RequestBody ModuleAttributes moduleAttributes){
        ModuleAttributes attributeResponse = attributeService.createModuleAttribute(moduleAttributes);
        return new ResponseEntity<ModuleAttributes>(attributeResponse,HttpStatus.CREATED);
    }

    @PostMapping("/{attributeId}")
    public ResponseEntity<ModuleAttributes> getModuleAttributeById(@PathVariable long attributeId){
        ModuleAttributes attributes = attributeService.findModuleAttributeById(attributeId);
        return new ResponseEntity<ModuleAttributes>(attributes,HttpStatus.OK);
    }

    @PostMapping("module/{moduleMasterId}")
    public ResponseEntity<List<ModuleAttributes>> getModuleAttributeByModuleMasterId(@PathVariable long moduleMasterId) {
        List<ModuleAttributes> attributes = attributeService.findModuleAttributeByModuleMasterId(moduleMasterId);
        return new ResponseEntity<List<ModuleAttributes>>(attributes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{attributeId}")
    public ResponseEntity<String> deleteModule(@PathVariable long attributeId) {
        attributeService.deleteAttributeById(attributeId);
        return new ResponseEntity<String>("Sucessfully deleted",HttpStatus.OK);
    }

    @GetMapping("/attributes")
    public ResponseEntity <List<ModuleAttributes>> getAllUModules(){
        return new ResponseEntity<List<ModuleAttributes>>(attributeService.getAllAttribute(),HttpStatus.OK);
    }

    @PutMapping("/update/{attributeId}")
    public  ResponseEntity<ModuleAttributes> updateModuleAttribute(@PathVariable long attributeId,@RequestBody ModuleAttributes moduleAttributes)
    {
        return new ResponseEntity<ModuleAttributes>(attributeService.updateAttribute(attributeId,moduleAttributes), HttpStatus.OK);
    }

}
