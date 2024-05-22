package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.BrandService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.ErrorDataResult;
import com.sinanengin.perfume.core.utilities.results.SuccessDataResult;
import com.sinanengin.perfume.dataAccess.abstracts.BrandDao;
import com.sinanengin.perfume.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {

    BrandDao brandDao;

    @Autowired
    public BrandManager(BrandDao brandDao) {
        this.brandDao = brandDao;
    }


    @Override
    public DataResult<List<Brand>> getAllBrand() {
        return new SuccessDataResult<>(brandDao.findAll());
    }

    @Override
    public DataResult<Brand> addBrand(Brand brand) {
        if (brandDao.findByBrandName(brand.getBrandName()).isEmpty()){
            brandDao.save(brand);
            return new SuccessDataResult<>(brand,"Marka veritabanına başarıyla eklendi.");
        }
        else
            return new ErrorDataResult<>("Bu marka zaten mevcut");
    }

    @Override
    public DataResult<Brand> deleteBrand(int brandId) {
        if (brandDao.findById(brandId).isPresent()) {
            brandDao.deleteById(brandId);
            return new SuccessDataResult<>("Marka başarıyla silindi.");
        }
        else
            return new ErrorDataResult<>("Silmek istediğiniz ID'ye sahip bir marka bulunamadı.");
    }

    @Override
    public DataResult<Brand> updateBrand(Brand brand) {
        if (brandDao.findById(brand.getBrandId()).isPresent()){
            brandDao.save(brand);
            return new SuccessDataResult<>(brand, "Marka başarıyla güncellendi.");
        }
        else
            return new ErrorDataResult<>(brand,"Böyle bir marka bulunmuyor.");
    }
}
