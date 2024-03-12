package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.CategoryService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public DataResult<List<Category>> getAllCategories(){
        return categoryService.getAllCategory();
    }

}
