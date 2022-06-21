package com.jst.rapidapp.controllers.discountgroup;


import com.jst.rapidapp.beans.DiscountGroup;
import com.jst.rapidapp.service.discountgroup.DiscountGroupService;
import com.jst.rapidapp.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vansales/discountGroup")
public class DiscountGroupController {

    @Autowired
    DiscountGroupService discountGroupService;

    @Autowired
    ProductService productService;

    @PostMapping("")
    public ResponseEntity<DiscountGroup> saveDiscountGroup(@PathVariable long productId, @RequestBody DiscountGroup discountGroup){

        DiscountGroup discountGroupResponse = discountGroupService.createDiscountGroup(discountGroup, productId);
        return new ResponseEntity<DiscountGroup>(discountGroupResponse,HttpStatus.OK);
    }

    @GetMapping("/{discountGroupId}")
    public ResponseEntity<DiscountGroup> getDiscountGroupById(@PathVariable long discountGroupId){
        DiscountGroup discountGroupResponse = discountGroupService.getDiscountGroupById(discountGroupId);
        return new ResponseEntity<DiscountGroup>(discountGroupResponse,HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<DiscountGroup>> getDiscountGroupList(){
        List<DiscountGroup> discountGroupResponse = discountGroupService.getDiscountGroupList();
        return new ResponseEntity<List<DiscountGroup>>(discountGroupResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{discountGroupId}")
    public ResponseEntity <HttpStatus> deleteDiscountGroupByProductId(@PathVariable long discountGroupId){
        discountGroupService.deleteDiscountGroup(discountGroupId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{discountGroupId}")
    public ResponseEntity <HttpStatus> updateDiscountGroupByProductId(@PathVariable long discountGroupId, @RequestBody DiscountGroup discountGroup){
        discountGroupService.updateDiscountGroup(discountGroupId, discountGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
