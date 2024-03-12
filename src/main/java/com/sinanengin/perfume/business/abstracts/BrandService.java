package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Brand;

import java.util.List;

public interface BrandService {

    DataResult<List<Brand>> getAllBrand();
}
