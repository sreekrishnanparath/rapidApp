package com.jst.rapidapp.service.item;


import com.jst.rapidapp.beans.ItemMaster;

import java.util.List;

public interface ItemService {

    public ItemMaster createItemMaster(ItemMaster itemMaster);
    public void deleteItemMaster(long id);
    public ItemMaster getItemMasterById(long id);
    public List<ItemMaster> getItemMasterList();
    public void updateItemMaster(long id, ItemMaster itemMaster);

}
