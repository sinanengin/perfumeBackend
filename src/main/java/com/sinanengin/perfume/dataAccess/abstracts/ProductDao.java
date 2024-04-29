package com.sinanengin.perfume.dataAccess.abstracts;
import com.sinanengin.perfume.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>, ProductDaoCustom {
    Page<Product> getByProductNameContains(String productName, Pageable pageable);

    Page<Product> getByProductIsBestSeller(boolean productIsBestSeller, Pageable pageable);

    @Query("SELECT p FROM Product p " +
            "WHERE (:volumeId IS NULL OR p.volume.volumeId = :volumeId) " +
            "AND (:brandId IS NULL OR p.brand.brandId = :brandId) " +
            "AND (:categoryId IS NULL OR p.category.categoryId = :categoryId)" +
            "AND (:genderId IS NULL OR p.gender.genderId = :genderId)" )
    Page<Product> findAllWithFilters(Integer volumeId, Integer brandId, Integer categoryId, Integer genderId, Pageable pageable);

}
