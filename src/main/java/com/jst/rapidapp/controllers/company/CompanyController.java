package com.jst.rapidapp.controllers.company;


import com.jst.rapidapp.beans.Company;
import com.jst.rapidapp.beans.User;
import com.jst.rapidapp.repository.company.CompanyRepository;
import com.jst.rapidapp.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rapidapp/company/")
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @PostMapping("/create")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company){
        Company companyResponse = companyRepository.saveAndFlush(company);
        return new ResponseEntity<Company>(companyResponse,HttpStatus.CREATED);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long companyId){
        Company company = companyRepository.findById(companyId);
        return new ResponseEntity<Company>(company,HttpStatus.OK);
    }

}
