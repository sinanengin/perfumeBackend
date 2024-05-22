package com.sinanengin.perfume.dataAccess.abstracts;
import com.sinanengin.perfume.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDao extends JpaRepository<Permission, Integer> {
}
