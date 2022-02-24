package com.jst.rapidapp.repository.company;


import com.jst.rapidapp.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company saveAndFlush(Company company);

    Company findById(long id);

    List<Company> findAll();

    void deleteById(long id);
}
