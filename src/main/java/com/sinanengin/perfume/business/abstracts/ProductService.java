package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.Result;
import com.sinanengin.perfume.entities.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll(Integer volumeId, Integer brandId, Integer categoryId, Integer genderId);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductIsBestSeller();

    Result addProduct(Product product);
    Result deleteProduct(int productId);
    Result updateProduct(Product product);

}
