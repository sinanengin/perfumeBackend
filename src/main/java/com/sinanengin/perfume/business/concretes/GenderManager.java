package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.GenderService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.SuccessDataResult;
import com.sinanengin.perfume.dataAccess.abstracts.GenderDao;
import com.sinanengin.perfume.entities.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderManager implements GenderService {

    GenderDao genderDao;

    @Autowired
    public GenderManager(GenderDao genderDao) {
        this.genderDao = genderDao;
    }

    @Override
    public DataResult<List<Gender>> getAllGender() {
        return new SuccessDataResult<>(genderDao.findAll());
    }
}
