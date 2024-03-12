package com.sinanengin.perfume.dataAccess.abstracts;
import com.sinanengin.perfume.entities.Volume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolumeDao extends JpaRepository<Volume,Integer> {
}
