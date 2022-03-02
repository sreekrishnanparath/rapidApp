package com.jst.rapidapp.service.company;

import com.jst.rapidapp.beans.Company;
import com.jst.rapidapp.dao.comapany.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    CompanyDao companyDao;

    @Override
    public Company createCompany(Company company) {
        return companyDao.createCompany(company);
    }

    @Override
    public void deleteCompany(long id) {
         companyDao.deleteCompanyById(id);
    }

    @Override
    public Company getCompanyById(long id) {
        return companyDao.getCompanyById(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    @Override
    public Company updateCompany(long id, Company company) {
        return companyDao.updateCompany(id,company);
    }
}
