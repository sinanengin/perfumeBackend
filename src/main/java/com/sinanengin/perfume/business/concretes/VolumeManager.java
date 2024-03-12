package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.VolumeService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.SuccessDataResult;
import com.sinanengin.perfume.dataAccess.abstracts.VolumeDao;
import com.sinanengin.perfume.entities.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolumeManager implements VolumeService {

    VolumeDao volumeDao;

    @Autowired
    public VolumeManager(VolumeDao volumeDao) {
        this.volumeDao = volumeDao;
    }

    @Override
    public DataResult<List<Volume>> getAllVolume() {
        return new SuccessDataResult<>(volumeDao.findAll());
    }


}
