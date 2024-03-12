package com.sinanengin.perfume.dataAccess.abstracts;
import com.sinanengin.perfume.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>, ProductDaoCustom {
    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductIsBestSeller(boolean productIsBestSeller);



}
