package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Brand;
import com.sinanengin.perfume.entities.Category;

import java.util.List;

public interface CategoryService {
    DataResult<List<Category>> getAllCategory();
}
