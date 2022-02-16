package com.jst.rapidapp.repository.module;


import com.jst.rapidapp.beans.ModuleAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<ModuleAttributes, Long> {

    ModuleAttributes saveAndFlush(ModuleAttributes moduleAttributes);

    ModuleAttributes findById(long id);

    List<ModuleAttributes> findByModuleMasterId(long id);
}
