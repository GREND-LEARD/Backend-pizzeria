package com.pizzeria.persistence.repository;
import org.springframework.data.repository.ListCrudRepository;
import com.pizzeria.persistence.entity.OrderEntity;
public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer>{
}
