package com.jst.rapidapp.controllers.product;


import com.jst.rapidapp.beans.ProductMaster;
import com.jst.rapidapp.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vansales/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("")
    public ResponseEntity<ProductMaster> saveProductMaster(@RequestBody ProductMaster productMaster){
        ProductMaster productMasterResponse = productService.createProductMaster(productMaster);
        return new ResponseEntity<ProductMaster>(productMasterResponse,HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductMaster> getProductMasterById(@PathVariable long productId){
        ProductMaster productMasterResponse = productService.getProductMasterById(productId);
        return new ResponseEntity<ProductMaster>(productMasterResponse,HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductMaster>> getProductMasterList(){
        List<ProductMaster> productMasterResponse = productService.getProductMasterList();
        return new ResponseEntity<List<ProductMaster>>(productMasterResponse,HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity <HttpStatus> deleteProductMasterByProductId(@PathVariable long productId){
        productService.deleteProductMaster(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
