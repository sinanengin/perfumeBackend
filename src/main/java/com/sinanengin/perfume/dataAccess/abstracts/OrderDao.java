package com.sinanengin.perfume.dataAccess.abstracts;


import com.sinanengin.perfume.entities.Order;
import com.sinanengin.perfume.entities.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {
    List<Order> getByUser_userId(int userId);
    Order getByProduct_productId(int productId);
}
