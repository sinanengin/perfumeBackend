package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.Product;

import java.util.List;

public interface ProductDaoCustom {

    List<Product> findProduct(Integer volumeId, Integer brandId, Integer categoryId, Integer genderId);
}
