package com.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;
import com.pizzeria.persistence.entity.PizzaEntity;

public interface IPizzaRepository extends ListCrudRepository<PizzaEntity, Integer>{
}
