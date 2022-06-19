package com.jst.rapidapp.service.item;


import com.jst.rapidapp.beans.ItemMaster;
import com.jst.rapidapp.dao.item.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    ItemDao itemDao;

    @Override
    public ItemMaster createItemMaster(ItemMaster productMaster) {
        return itemDao.createItemMaster(productMaster);
    }


    @Override
    public void deleteItemMaster(long id) {
        itemDao.deleteItemMaster(id);
    }

    @Override
    public ItemMaster getItemMasterById(long id) {
        return itemDao.getItemMasterById(id);
    }

    @Override
    public List<ItemMaster> getItemMasterList() {
        return itemDao.getItemMasterList();
    }

    @Override
    public void updateItemMaster(long id, ItemMaster itemMaster) {
        itemDao.updateItemMaster(id, itemMaster);
    }


}

