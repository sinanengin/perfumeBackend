package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.VolumeService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/volumes")
@CrossOrigin(origins = "http://localhost:5173/")
public class VolumesController {
    VolumeService volumeService;

    @Autowired
    public VolumesController(VolumeService volumeService) {
        this.volumeService = volumeService;
    }

    @GetMapping
    public DataResult<List<Volume>> getAllVolumes(){
        return volumeService.getAllVolume();
    }
}
