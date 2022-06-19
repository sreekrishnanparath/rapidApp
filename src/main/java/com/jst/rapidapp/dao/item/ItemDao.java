package com.jst.rapidapp.dao.item;

import com.jst.rapidapp.beans.ItemMaster;
import com.jst.rapidapp.beans.ProductMaster;
import com.jst.rapidapp.repository.item.ItemRepository;
import com.jst.rapidapp.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemDao {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ProductRepository productRepository;


    public ItemMaster createItemMaster(ItemMaster itemMaster, long productId) {
        ProductMaster productMaster = productRepository.findById(productId);
        itemMaster.setProduct(productMaster);
        itemMaster.setStatus("CREATED");
        return itemRepository.saveAndFlush(itemMaster);
    }


    public void deleteItemMaster(long id) {

        itemRepository.deleteById(id);
    }


    public ItemMaster getItemMasterById(long id) {
        return itemRepository.findById(id);
    }


    public List<ItemMaster> getItemMasterList() {
        return itemRepository.findAll();
    }

    public void updateItemMaster(long id, ItemMaster itemMaster){
        ItemMaster existingItemMaster = itemRepository.findById(id);
        if(existingItemMaster != null){
            itemRepository.save(itemMaster);
        }

    }

}
