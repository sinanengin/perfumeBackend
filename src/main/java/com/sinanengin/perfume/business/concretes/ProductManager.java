package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.ProductService;
import com.sinanengin.perfume.dataAccess.abstracts.ProductDao;
import com.sinanengin.perfume.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll(Integer volumeId, Integer brandId, Integer categoryId, Integer genderId) {

        return productDao.findProduct(volumeId, brandId, categoryId, genderId);
    }
}
