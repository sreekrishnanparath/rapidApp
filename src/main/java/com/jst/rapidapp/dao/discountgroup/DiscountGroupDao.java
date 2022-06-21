package com.jst.rapidapp.dao.discountgroup;

import com.jst.rapidapp.beans.DiscountGroup;
import com.jst.rapidapp.repository.discountgroup.DiscountGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiscountGroupDao {
    @Autowired
    DiscountGroupRepository discountGroupRepository;


    public DiscountGroup createDiscountGroup(DiscountGroup itemMaster, long productId) {
        itemMaster.setStatus("CREATED");
        return discountGroupRepository.saveAndFlush(itemMaster);
    }


    public void deleteDiscountGroup(long id) {

        discountGroupRepository.deleteById(id);
    }


    public DiscountGroup getDiscountGroupById(long id) {
        return discountGroupRepository.findById(id);
    }


    public List<DiscountGroup> getDiscountGroupList() {
        return discountGroupRepository.findAll();
    }

    public void updateDiscountGroup(long id, DiscountGroup itemMaster){
        DiscountGroup existingDiscountGroup = discountGroupRepository.findById(id);
        if(existingDiscountGroup != null){
            discountGroupRepository.save(itemMaster);
        }

    }

}
