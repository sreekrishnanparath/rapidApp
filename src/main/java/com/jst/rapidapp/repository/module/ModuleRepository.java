package com.jst.rapidapp.repository.module;


import com.jst.rapidapp.beans.Company;
import com.jst.rapidapp.beans.ModuleAttributes;
import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleMaster, Long> {

    ModuleMaster saveAndFlush(ModuleMaster moduleMaster);

    ModuleMaster findById(long id);

    List<ModuleMaster> findByCompanyId(long id);

    List <ModuleMaster> findAll();

    void deleteById(long id);
}
