package com.jst.rapidapp.controllers.item;


import com.jst.rapidapp.beans.ItemMaster;
import com.jst.rapidapp.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vansales")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity<ItemMaster> saveItemMaster(@RequestBody ItemMaster itemMaster){
        ItemMaster itemMasterResponse = itemService.createItemMaster(itemMaster);
        return new ResponseEntity<ItemMaster>(itemMasterResponse,HttpStatus.OK);
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity<ItemMaster> getItemMasterById(@PathVariable long itemId){
        ItemMaster itemMasterResponse = itemService.getItemMasterById(itemId);
        return new ResponseEntity<ItemMaster>(itemMasterResponse,HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemMaster>> getItemMasterList(){
        List<ItemMaster> itemMasterResponse = itemService.getItemMasterList();
        return new ResponseEntity<List<ItemMaster>>(itemMasterResponse,HttpStatus.OK);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity <HttpStatus> deleteItemMasterByProductId(@PathVariable long itemId){
        itemService.deleteItemMaster(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/items/{itemId}")
    public ResponseEntity <HttpStatus> updateItemMasterByProductId(@PathVariable long itemId, @RequestBody ItemMaster itemMaster){
        itemService.updateItemMaster(itemId, itemMaster);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
