package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandDao extends JpaRepository<Brand,Integer> {


        Optional<Brand> findByBrandName(String brandName);



}
