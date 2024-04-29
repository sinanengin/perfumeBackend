package com.sinanengin.perfume.business.abstracts;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Product;
import com.sinanengin.perfume.entities.Volume;

import java.util.List;

public interface VolumeService {
    DataResult<List<Volume>> getAllVolume();

    DataResult<Volume> addVolume(Volume volume);
    DataResult<Volume> deleteVolume(int volumeId);
    DataResult<Volume> updateVolume(Volume volume);
}
