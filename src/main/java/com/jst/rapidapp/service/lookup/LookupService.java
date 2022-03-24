package com.jst.rapidapp.service.lookup;


import com.jst.rapidapp.beans.LookupMaster;

import java.util.List;

public interface LookupService {

    public LookupMaster createLookupMaster (LookupMaster lookupMaster);
    public void deleteLookupMaster(long id);
    public LookupMaster getLookupMasterById(long id);
    public LookupMaster getLookupMasterByCompanyId(long companyId);
    public List<LookupMaster> getAllLookupMaster();
    public LookupMaster updateLookupMaster(long id,LookupMaster lookupMaster);
    public List<LookupMaster> getLookupMasterLookRefId(String lookRefId);
    public List<LookupMaster> getAllLookupMasterByLookRefIds(List<String> lookRefIds);
}
