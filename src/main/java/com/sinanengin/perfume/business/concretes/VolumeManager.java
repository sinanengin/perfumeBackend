package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.VolumeService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.ErrorDataResult;
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

    @Override
    public DataResult<Volume> addVolume(Volume volume) {
        if (volumeDao.findById(volume.getVolumeId()).isEmpty()){
            volumeDao.save(volume);
            return new SuccessDataResult<>("Hacim başarıyla eklendi.");
        }
        else
            return new ErrorDataResult<>("Böyle bir hacim zaten bulunuyor.");
    }


    @Override
    public DataResult<Volume> deleteVolume(int volumeId) {
        if (volumeDao.findById(volumeId).isPresent()){
            volumeDao.deleteById(volumeId);
            return new SuccessDataResult<>("Hacim başarıyla silindi.");
        }
        else
            return new ErrorDataResult<>("Böyle bir hacim bulunmuyor.");
    }


    @Override
    public DataResult<Volume> updateVolume(Volume volume) {
        if (volumeDao.findById(volume.getVolumeId()).isPresent()){
            volumeDao.save(volume);
            return new SuccessDataResult<>("Hacim başarıyla güncellendi.");
        }
        else
            return new ErrorDataResult<>("Böyle bir hacim bulunmuyor.");
    }
    }



