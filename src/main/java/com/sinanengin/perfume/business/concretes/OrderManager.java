package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.OrderService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.ErrorDataResult;
import com.sinanengin.perfume.core.utilities.results.SuccessDataResult;
import com.sinanengin.perfume.dataAccess.abstracts.OrderDao;
import com.sinanengin.perfume.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrderManager implements OrderService {

     OrderDao orderDao;

     @Autowired
     public OrderManager(OrderDao orderDao){ this.orderDao = orderDao;}

    @Override
    public DataResult<List<Order>> getAllOrder() {
        return new SuccessDataResult<>(orderDao.findAll());
    }

    @Override
    public DataResult<List<Order>> getOrderByUserId(int userId) {
        return new SuccessDataResult<>(orderDao.getByUser_userId(userId));
    }

    @Override
    public DataResult<Order> getOrderByOrderId(int orderId) {
         if (orderDao.findById(orderId).isPresent())
            return new SuccessDataResult<>(orderDao.findById(orderId).get());
         else
             return new ErrorDataResult<>("Bir hata oluştu.");
    }

    @Override
    public DataResult<Order> getOrderByProductId(int productId) {
        return new SuccessDataResult<>(orderDao.getByProduct_productId(productId));
    }

    @Override
    public DataResult<Order> addOrder(Order order) {
         orderDao.save(order);
        return new SuccessDataResult<>(order, "Sipariş eklendi.");
    }

    @Override
    public DataResult<Order> deleteOrder(int orderId) {
         orderDao.deleteById(orderId);
        return new SuccessDataResult<>("Sipariş silindi.");
    }

    @Override
    public DataResult<Order> updateOrder(Order order) {
         orderDao.save(order);
        return new SuccessDataResult<>(order, "Sipariş güncelledi.");
    }
}
