package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.CategoryService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.SuccessDataResult;
import com.sinanengin.perfume.dataAccess.abstracts.CategoryDao;
import com.sinanengin.perfume.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public DataResult<List<Category>> getAllCategory() {
        return new SuccessDataResult<>(categoryDao.findAll());
    }
}
