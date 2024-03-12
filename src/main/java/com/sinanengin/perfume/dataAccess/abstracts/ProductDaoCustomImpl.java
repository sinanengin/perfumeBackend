package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductDaoCustomImpl implements ProductDaoCustom{
    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> findProduct(Integer volumeId, Integer brandId, Integer categoryId, Integer genderId) {
        String jpql = "SELECT p FROM Product p WHERE 1=1";

        if (volumeId != null) {
            jpql += " AND p.volume.volumeId = :volumeId";
        }
        if (brandId != null) {
            jpql += " AND p.brand.brandId = :brandId";
        }
        if (categoryId != null) {
            jpql += " AND p.category.categoryId = :categoryId";
        }
        if (genderId != null) {
            jpql += " AND p.gender.genderId = :genderId";
        }

        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);

        if (volumeId != null) {
            query.setParameter("volumeId", volumeId);
        }
        if (brandId != null) {
            query.setParameter("brandId", brandId);
        }
        if (categoryId != null) {
            query.setParameter("categoryId", categoryId);
        }
        if (genderId != null) {
            query.setParameter("genderId", genderId);
        }

        return query.getResultList();
    }
}
