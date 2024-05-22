package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPermissionDao extends JpaRepository<UserPermission, Integer> {
    List<UserPermission> getByUser_userId(int userId);
}
