package com.jst.rapidapp.repository.item;


import com.jst.rapidapp.beans.ItemMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemMaster, Long> {

    ItemMaster saveAndFlush(ItemMaster itemMaster);

    ItemMaster findById(long id);

    List<ItemMaster> findAll();

    void deleteById(long id);
}
