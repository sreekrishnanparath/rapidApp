package com.jst.rapidapp.dao.lookup;


import com.jst.rapidapp.beans.LookupMaster;
import com.jst.rapidapp.repository.lookup.LookupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LookupDao {

    @Autowired
    LookupRepository lookupRepository;


    public LookupMaster createLookupMaster(LookupMaster lookupMaster) {
        lookupMaster.setStatus("CREATED");
        return lookupRepository.saveAndFlush(lookupMaster);
    }


    public void deleteLookupMaster(long id) {
        lookupRepository.deleteById(id);
    }


    public LookupMaster getLookupMasterById(long id) {
        return lookupRepository.findById(id);
    }


    public List<LookupMaster> getLookupMasterByCompanyId(long companyId) {
        return lookupRepository.findByCompanyIdOrderByLookRefId(companyId);
    }


    public List<String> getAllLookupMasterRefByCompany(long companyId) {
        return lookupRepository.findDistinctLookupRefs(companyId);
    }


    public List<LookupMaster> getLookupMasterByLookRefId(String lookRefId) {
        return lookupRepository.findByLookRefId(lookRefId);
    }

//    public LookupMaster updateLookupMaster(long id, LookupMaster lookupMaster) {
//        return lookupRepository.updateLookupMaster(id,lookupMaster);
//    }

    public List<LookupMaster> getAllLookupMasterByLookRefIds(List<String> lookRefIds) {
        lookRefIds = lookRefIds.stream().map(x -> x.replaceAll("\\[", "").replaceAll("\\]","")).collect(Collectors.toList());
        return lookupRepository.findAllByLookRefIdIn(lookRefIds);
    }


}
