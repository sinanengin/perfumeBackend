package com.sinanengin.perfume.business.abstracts;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Volume;

import java.util.List;

public interface VolumeService {
    DataResult<List<Volume>> getAllVolume();
}
