package com.pizzeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pizzeria.persistence.entity.OrderEntity;
import com.pizzeria.persistence.repository.OrderRepository;

@Service
public class OrdersService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> getAll(){
        List<OrderEntity> orders = this.orderRepository.findAll();
        orders.forEach(order -> System.out.println(order.getCustomer().getName()));
        return orders;
    }
}
