package com.jst.rapidapp.dao.comapany;

import com.jst.rapidapp.beans.Company;
import com.jst.rapidapp.repository.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyDao {
    @Autowired
    CompanyRepository companyRepository;
    public Company createCompany(Company company)
    {
        company.setActive(true);
        company.setStatus("Created");
        return companyRepository.saveAndFlush(company);
    }
    public Company getCompanyById(long id)
    {
        return companyRepository.findById(id);
    }
    //get all company
    public List<Company> getAllCompanies ()
    {
        return companyRepository.findAll();
    }
    //update company
    public Company updateCompany(long id,Company company)
    {
        Company existingCompany = companyRepository.findById(id);
        existingCompany.setCompanyName(company.getCompanyName());
        existingCompany.setCompanyUser(company.getCompanyUser());
        existingCompany.setStatus(company.getStatus());
        existingCompany.setActive(company.isActive());
        return companyRepository.saveAndFlush(existingCompany);
    }
    //delete company
    public void deleteCompanyById(long id)
    {
        companyRepository.deleteById(id);
    }
}
