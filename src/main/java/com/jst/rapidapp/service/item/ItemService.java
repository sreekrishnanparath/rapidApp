package com.jst.rapidapp.service.item;


import com.jst.rapidapp.beans.ItemMaster;
import com.jst.rapidapp.beans.ProductMaster;

import java.util.List;

public interface ItemService {

    ItemMaster createItemMaster(ItemMaster itemMaster, long productId);
    void deleteItemMaster(long id);
    ItemMaster getItemMasterById(long id);
    List<ItemMaster> getItemMasterList();
    void updateItemMaster(long id, ItemMaster itemMaster);

}
