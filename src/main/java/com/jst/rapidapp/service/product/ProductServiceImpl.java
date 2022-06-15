package com.jst.rapidapp.service.product;


import com.jst.rapidapp.beans.ProductMaster;
import com.jst.rapidapp.dao.product.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductDao productDao;

    @Override
    public ProductMaster createProductMaster(ProductMaster productMaster) {
        return productDao.createProductMaster(productMaster);
    }

    @Override
    public void deleteProductMaster(long id) {
        productDao.deleteProductMaster(id);
    }

    @Override
    public ProductMaster getProductMasterById(long id) {
        return productDao.getProductMasterById(id);
    }

    @Override
    public List<ProductMaster> getProductMasterList() {
        return productDao.getProductMasterList();
    }


}

