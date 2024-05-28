package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.requests.PagedList;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.Result;
import com.sinanengin.perfume.entities.Product;

import java.util.List;

public interface ProductService {
    DataResult<PagedList<Product>> getAll(Integer volumeId, Integer brandId, Integer categoryId, Integer genderId, Integer pageSize, Integer pageNo);

    DataResult<PagedList<Product>> getByProductNameContains(String productName, Integer pageSize, Integer pageNo);

    DataResult<PagedList<Product>> getByProductIsBestSeller(Integer pageSize, Integer pageNo);

    DataResult<Product> getByProductId(int id);

    DataResult<Product> addProduct(Product product);
    DataResult<Product> deleteProduct(int productId);
    DataResult<Product> updateProduct(Product product);

}
