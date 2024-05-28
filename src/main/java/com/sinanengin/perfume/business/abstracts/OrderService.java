package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Order;

import java.util.List;

public interface OrderService {

    DataResult<List<Order>> getAllOrder();

    DataResult<List<Order>> getOrderByUserId(int userId);

    DataResult<Order> getOrderByOrderId(int orderId);

    DataResult<Order> getOrderByProductId(int productId);



    DataResult<Order> addOrder(Order order);
    DataResult<Order> deleteOrder(int orderId);
    DataResult<Order> updateOrder(Order order);

}
