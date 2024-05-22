package com.sinanengin.perfume.dataAccess.abstracts;

import com.sinanengin.perfume.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
    Customer getByUser_userId(int userId);
}