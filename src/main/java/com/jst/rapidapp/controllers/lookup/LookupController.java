package com.jst.rapidapp.controllers.lookup;


import com.jst.rapidapp.beans.LookupMaster;
import com.jst.rapidapp.service.lookup.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapidapp/lookup/")
public class LookupController {

    @Autowired
    LookupService lookupService;

    @PostMapping("/create")
    public ResponseEntity<LookupMaster> saveLookupMaster(@RequestBody LookupMaster lookupMaster){
        LookupMaster lookupMasterResponse = lookupService.createLookupMaster(lookupMaster);
        return new ResponseEntity<LookupMaster>(lookupMasterResponse,HttpStatus.OK);
    }

    @GetMapping("id/{companyId}")
    public ResponseEntity<LookupMaster> getLookupMasterById(@PathVariable long id){
        LookupMaster lookupMasterResponse = lookupService.getLookupMasterById(id);
        return new ResponseEntity<LookupMaster>(lookupMasterResponse,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<LookupMaster> getLookupMasterByCompanyId(@PathVariable long companyId){
        LookupMaster lookupMasterResponse = lookupService.getLookupMasterByCompanyId(companyId);
        return new ResponseEntity<LookupMaster>(lookupMasterResponse,HttpStatus.OK);
    }

    @GetMapping("/lookups/{companyId}")
    public ResponseEntity <List<String>> getAllLookupMaster(@PathVariable long companyId){
        List<String> lookupMasterResponse = lookupService.getAllLookupMasterRefByCompany(companyId);
        return new ResponseEntity<List<String>>(lookupMasterResponse,HttpStatus.OK);
    }

    @GetMapping("ref/{lookRefId}")
    public ResponseEntity<List<LookupMaster>> getLookupMasterById(@PathVariable String lookRefId){
        List<LookupMaster> lookupMasterResponse = lookupService.getLookupMasterLookRefId(lookRefId);
        return new ResponseEntity<List<LookupMaster>>(lookupMasterResponse,HttpStatus.OK);
    }

    @PostMapping("refs/{lookRefIds}")
    public ResponseEntity<List<LookupMaster>> getLookupMasterById(@PathVariable List<String> lookRefIds){
        System.out.println("lookRefIds##"+lookRefIds.toString());
        List<LookupMaster> lookupMasterResponse = lookupService.getAllLookupMasterByLookRefIds(lookRefIds);
        System.out.println("lookupMasterResponse##"+lookupMasterResponse.toString());
        return new ResponseEntity<List<LookupMaster>>(lookupMasterResponse,HttpStatus.OK);
    }


//    @PutMapping("/update/{companyId}")
//    public  ResponseEntity<Company> updateCompany(@PathVariable long companyId,@RequestBody  Company company)
//    {
//        return new ResponseEntity<Company>(companyService.updateCompany(companyId,company), HttpStatus.OK);
//    }
//    @DeleteMapping("/delete/{companyId}")
//    public ResponseEntity<String> deleteCompany(@PathVariable long companyId) {
//        companyService.deleteCompany(companyId);
//
//        return new ResponseEntity<String>("Sucessfully deleted",HttpStatus.OK);
//
//    }
}
