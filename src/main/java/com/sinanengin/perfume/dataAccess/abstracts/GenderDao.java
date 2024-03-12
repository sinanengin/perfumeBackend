package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderDao extends JpaRepository<Gender,Integer> {
}
