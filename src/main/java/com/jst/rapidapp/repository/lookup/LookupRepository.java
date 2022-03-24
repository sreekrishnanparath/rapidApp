package com.jst.rapidapp.repository.lookup;



import com.jst.rapidapp.beans.LookupMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookupRepository extends JpaRepository<LookupMaster, Long> {

    LookupMaster saveAndFlush(LookupMaster lookupMaster);

    LookupMaster findById(long id);

    List<LookupMaster> findAllByLookRefIdIn(List<String> lookRefIds);

    List<LookupMaster> findAll();

    void deleteById(long id);

    LookupMaster findByCompanyId(long companyId);

    List<LookupMaster> findByLookRefId(String lookRefId);




}
