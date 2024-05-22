package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.Brand;
import com.sinanengin.perfume.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    Optional<Category> findByCategoryName(String categoryName);
}
