package com.jst.rapidapp.controllers.modules;


import com.jst.rapidapp.beans.ModuleAttributes;
import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.service.module.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
