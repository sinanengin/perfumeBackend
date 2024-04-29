package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Brand;
import com.sinanengin.perfume.entities.Product;

import java.util.List;

public interface BrandService {

    DataResult<List<Brand>> getAllBrand();

    DataResult<Brand> addBrand(Brand brand);
    DataResult<Brand> deleteBrand(int brandId);
    DataResult<Brand> updateBrand(Brand brand);
}
