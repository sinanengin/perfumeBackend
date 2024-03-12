package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Gender;

import java.util.List;

public interface GenderService {
    DataResult<List<Gender>> getAllGender();
}
