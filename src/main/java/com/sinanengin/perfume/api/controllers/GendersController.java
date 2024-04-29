package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.GenderService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genders")
@CrossOrigin(origins = "http://localhost:5173/")
public class GendersController {
    GenderService genderService;

    @Autowired
    public GendersController(GenderService genderService) {
        this.genderService = genderService;
    }

    @GetMapping
    public DataResult<List<Gender>> getAllGenders(){
        return genderService.getAllGender();
    }
}
