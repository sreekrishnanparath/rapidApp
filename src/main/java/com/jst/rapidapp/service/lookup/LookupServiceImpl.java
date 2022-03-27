package com.jst.rapidapp.service.lookup;


import com.jst.rapidapp.beans.LookupMaster;
import com.jst.rapidapp.dao.lookup.LookupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookupServiceImpl implements LookupService {


    @Autowired
    LookupDao lookupDAO;

    @Override
    public LookupMaster createLookupMaster(LookupMaster lookupMaster) {
        return lookupDAO.createLookupMaster(lookupMaster);
    }

    @Override
    public void deleteLookupMaster(long id) {
        lookupDAO.deleteLookupMaster(id);
    }

    @Override
    public LookupMaster getLookupMasterById(long id) {
        return lookupDAO.getLookupMasterById(id);
    }

    @Override
    public LookupMaster getLookupMasterByCompanyId(long companyId) {
        return lookupDAO.getLookupMasterByCompanyId(companyId);
    }

    @Override
    public List<String> getAllLookupMasterRefByCompany(long companyId) {
        return lookupDAO.getAllLookupMasterRefByCompany(companyId);
    }

    @Override
    public LookupMaster updateLookupMaster(long id, LookupMaster lookupMaster) {
        return null;
    }

    @Override
    public List<LookupMaster> getLookupMasterLookRefId(String lookRefId) {
        return lookupDAO.getLookupMasterByLookRefId(lookRefId);
    }

    @Override
    public List<LookupMaster> getAllLookupMasterByLookRefIds(List<String> lookRefIds) {
        return lookupDAO.getAllLookupMasterByLookRefIds(lookRefIds);
    }

}

