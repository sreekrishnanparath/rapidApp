package com.jst.rapidapp.service.discountgroup;


import com.jst.rapidapp.beans.DiscountGroup;

import java.util.List;

public interface DiscountGroupService {

    DiscountGroup createDiscountGroup(DiscountGroup discountGroup, long id);
    void deleteDiscountGroup(long id);
    DiscountGroup getDiscountGroupById(long id);
    List<DiscountGroup> getDiscountGroupList();
    void updateDiscountGroup(long id, DiscountGroup discountGroup);

}
