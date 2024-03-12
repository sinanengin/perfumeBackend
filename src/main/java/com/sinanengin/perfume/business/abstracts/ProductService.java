package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll(Integer volumeId, Integer brandId, Integer categoryId, Integer genderId);
}
