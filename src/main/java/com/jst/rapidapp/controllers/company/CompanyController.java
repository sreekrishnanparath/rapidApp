package com.jst.rapidapp.controllers.company;


import com.jst.rapidapp.beans.Company;
import com.jst.rapidapp.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapidapp/company/")
public class CompanyController{

    @Autowired
    CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company){
        Company companyResponse = companyService.createCompany(company);
        return new ResponseEntity<Company>(companyResponse,HttpStatus.OK);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long companyId){
        Company company = companyService.getCompanyById(companyId);
        return new ResponseEntity<Company>(company,HttpStatus.OK);
    }

    @GetMapping("/companies")
    public ResponseEntity <List<Company>> getAllCompanies(){
        return new ResponseEntity<List<Company>>(companyService.getAllCompanies(),HttpStatus.OK);
    }
    @PutMapping("/update/{companyId}")
    public  ResponseEntity<Company> updateCompany(@PathVariable long companyId,@RequestBody  Company company)
    {
        return new ResponseEntity<Company>(companyService.updateCompany(companyId,company), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable long companyId) {
        companyService.deleteCompany(companyId);

        return new ResponseEntity<String>("Sucessfully deleted",HttpStatus.OK);

    }
}
