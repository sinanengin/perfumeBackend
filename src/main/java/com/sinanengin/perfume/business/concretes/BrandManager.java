package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.BrandService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
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
}
