package com.jst.rapidapp.service.company;

import com.jst.rapidapp.beans.Company;

import java.util.List;

public interface CompanyService {
    public Company createCompany (Company company);
    public void deleteCompany(long id);
    public Company getCompanyById(long id);
    public List<Company> getAllCompanies();
    public Company updateCompany(long id,Company company);
}
