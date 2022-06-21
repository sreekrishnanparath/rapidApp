package com.jst.rapidapp.service.discountgroup;


import com.jst.rapidapp.beans.DiscountGroup;
import com.jst.rapidapp.dao.discountgroup.DiscountGroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountGroupImpl implements DiscountGroupService {


    @Autowired
    DiscountGroupDao discountGroupDao;

    @Override
    public DiscountGroup createDiscountGroup(DiscountGroup discountGroup, long productId) {
        return discountGroupDao.createDiscountGroup(discountGroup, productId);
    }


    @Override
    public void deleteDiscountGroup(long id) {
        discountGroupDao.deleteDiscountGroup(id);
    }

    @Override
    public DiscountGroup getDiscountGroupById(long id) {
        return discountGroupDao.getDiscountGroupById(id);
    }

    @Override
    public List<DiscountGroup> getDiscountGroupList() {
        return discountGroupDao.getDiscountGroupList();
    }

    @Override
    public void updateDiscountGroup(long id, DiscountGroup discountGroup) {
        discountGroupDao.updateDiscountGroup(id, discountGroup);
    }


}

