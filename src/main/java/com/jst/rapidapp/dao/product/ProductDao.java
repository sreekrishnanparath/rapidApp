package com.jst.rapidapp.dao.product;

import com.jst.rapidapp.beans.ProductMaster;
import com.jst.rapidapp.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductDao {
    @Autowired
    ProductRepository productRepository;


    public ProductMaster createProductMaster(ProductMaster productMaster) {
        productMaster.setStatus("CREATED");
        return productRepository.saveAndFlush(productMaster);
    }


    public void deleteProductMaster(long id) {

        productRepository.deleteById(id);
    }


    public ProductMaster getProductMasterById(long id) {
        return productRepository.findById(id);
    }


    public List<ProductMaster> getProductMasterList() {
        return productRepository.findAll();
    }

}
