package com.jst.rapidapp.service.product;


import com.jst.rapidapp.beans.ProductMaster;

import java.util.List;

public interface ProductService {

    public ProductMaster createProductMaster(ProductMaster productMaster);
    public void deleteProductMaster(long id);
    public ProductMaster getProductMasterById(long id);
    public List<ProductMaster> getProductMasterList();

}
