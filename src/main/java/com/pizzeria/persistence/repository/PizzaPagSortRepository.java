package com.pizzeria.persistence.repository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import com.pizzeria.persistence.entity.PizzaEntity;


public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer> {
}
