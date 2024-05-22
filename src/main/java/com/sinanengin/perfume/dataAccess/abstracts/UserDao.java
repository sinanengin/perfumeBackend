package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}