package com.pizzeria.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pizzeria.service.OrdersService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.pizzeria.persistence.entity.OrderEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    private final OrdersService orderService;
    
    @Autowired
    public OrderController(OrdersService ordersService) {
        this.orderService = ordersService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll(){
        return ResponseEntity.ok(this.orderService.getAll());
    }

    @GetMapping("/outside")
    public ResponseEntity<List<OrderEntity>> getOutside(){
        return ResponseEntity.ok(this.orderService.getOutsideOrders());
    }

    @GetMapping("/today")
    public ResponseEntity<List<OrderEntity>> getTodayOrders(){
        return ResponseEntity.ok(this.orderService.getTodayOrders());
     }
    }

