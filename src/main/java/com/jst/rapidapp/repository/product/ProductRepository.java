package com.jst.rapidapp.repository.product;


import com.jst.rapidapp.beans.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductMaster, Long> {

    ProductMaster saveAndFlush(ProductMaster productMaster);

    ProductMaster findById(long id);

    List<ProductMaster> findAll();

    void deleteById(long id);
}
