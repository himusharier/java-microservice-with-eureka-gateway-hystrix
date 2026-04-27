package com.himusharier.order_service.controller;

import com.himusharier.order_service.entity.Order;
import com.himusharier.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("book-order")
    public Order bookOrder(@RequestBody Order order) {
        return service.saveOrder(order);
    }
}
