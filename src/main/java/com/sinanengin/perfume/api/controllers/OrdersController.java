package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.OrderService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5173/")
public class OrdersController {
    private final OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping()
    public DataResult<List<Order>> getAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public DataResult<Order> getOrderByOrderId(@PathVariable int id){
        return orderService.getOrderByOrderId(id);
    }

    @GetMapping("/user/{id}")
    public DataResult<List<Order>> getOrderByUserId(@PathVariable int id){
        return orderService.getOrderByUserId(id);
    }

    @GetMapping("/product/{id}")
    public DataResult<Order> getOrderByProductId(@PathVariable int id){
        return orderService.getOrderByProductId(id);
    }

    @PostMapping()
    public DataResult<Order> addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
    @DeleteMapping()
    public DataResult<Order> deleteOrder(@RequestParam int id){
        return orderService.deleteOrder(id);
    }

    @PutMapping
    public DataResult<Order> updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }
}
