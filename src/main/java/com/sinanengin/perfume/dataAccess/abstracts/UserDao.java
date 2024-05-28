package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.Permission;
import com.sinanengin.perfume.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    User getByUsername(String username);
    User getByUsernameOrEmail(String username, String email);
    User getByEmail(String Email);
    @Query("SELECT up.permission FROM UserPermission up WHERE up.user.userId = :userId")
    List<Permission> getClaims(@Param("userId") int userId);
}