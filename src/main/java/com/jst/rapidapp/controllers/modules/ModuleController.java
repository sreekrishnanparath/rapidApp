package com.jst.rapidapp.controllers.modules;


import com.jst.rapidapp.beans.ModuleAttributes;
import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.service.module.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rapidapp/module/")
public class ModuleController {

    @Autowired
    ModuleService moduleService;

    @PostMapping("/create")
    public ResponseEntity<ModuleMaster> saveModuleMaster(@RequestBody ModuleMaster moduleMaster){
        ModuleMaster moduleResponse = moduleService.createModuleMaster(moduleMaster);
        return new ResponseEntity<ModuleMaster>(moduleResponse,HttpStatus.CREATED);
    }

    @PostMapping("/{moduleMasterId}")
    public ResponseEntity<ModuleMaster> getModuleMasterById(@PathVariable long moduleMasterId){
        ModuleMaster ModuleMaster = moduleService.findModuleMasterById(moduleMasterId);
        return new ResponseEntity<ModuleMaster>(ModuleMaster,HttpStatus.OK);
    }


    @PostMapping("company/{companyId}")
    public ResponseEntity<List<ModuleMaster>> getModuleAttributeByModuleMasterId(@PathVariable long companyId){
        System.out.println(companyId);
        List<ModuleMaster> moduleMasters = moduleService.findModuleByCompanyId(companyId);
        return new ResponseEntity<List<ModuleMaster>>(moduleMasters,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{moduleId}")
    public ResponseEntity<String> deleteModule(@PathVariable long moduleId) {
        moduleService.deleteModule(moduleId);
        return new ResponseEntity<String>("Sucessfully deleted",HttpStatus.OK);
    }
    @GetMapping("/modules")
    public ResponseEntity <List<ModuleMaster>> getAllUModules(){
        return new ResponseEntity<List<ModuleMaster>>(moduleService.getAllModules(),HttpStatus.OK);
    }

    @PutMapping("/update/{moduleId}")
    public  ResponseEntity<ModuleMaster> updateUser(@PathVariable long moduleId,@RequestBody ModuleMaster module)
    {
        return new ResponseEntity<ModuleMaster>(moduleService.updateModule(moduleId,module), HttpStatus.OK);
    }

    @PostMapping("/trans/{companyId}")
    public ResponseEntity <List<ModuleMaster>> findAllModulesTransCount(@PathVariable long companyId){
        return new ResponseEntity<List<ModuleMaster>>(moduleService.findAllModulesTransCount(),HttpStatus.OK);
    }
}
