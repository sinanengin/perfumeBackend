package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.CategoryService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.ErrorDataResult;
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

    @Override
    public DataResult<Category> addCategory(Category category) {
        if (categoryDao.findByCategoryName(category.getCategoryName()).isEmpty()){
            categoryDao.save(category);
            return new SuccessDataResult<>(category,"Kategori veritabanına başarıyla eklendi.");
        }
        else
            return new ErrorDataResult<>("Bu kategori zaten mevcut.");
    }

    @Override
    public DataResult<Category> deleteCategory(int categoryId) {
        if (categoryDao.findById(categoryId).isPresent()){
            categoryDao.deleteById(categoryId);
            return new SuccessDataResult<>("Kategori başarıyla silindi.");
        }
        else
            return new ErrorDataResult<>("Böyle bir kategori bulunmuyor.");
    }

    @Override
    public DataResult<Category> updateCategory(Category category) {
        if (categoryDao.findById(category.getCategoryId()).isPresent()){
            categoryDao.save(category);
            return new SuccessDataResult<>("Kategori başarıyla güncellendi.");
        }
        else
            return new ErrorDataResult<>("Böyle bir kategori bulunmuyor.");
    }

}
