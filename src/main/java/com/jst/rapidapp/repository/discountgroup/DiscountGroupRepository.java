package com.jst.rapidapp.repository.discountgroup;


import com.jst.rapidapp.beans.DiscountGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountGroupRepository extends JpaRepository<DiscountGroup, Long> {

    DiscountGroup saveAndFlush(DiscountGroup company);

    DiscountGroup findById(long id);

    List<DiscountGroup> findAll();

    void deleteById(long id);
}
