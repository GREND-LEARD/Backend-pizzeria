package com.pizzeria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pizzeria.persistence.entity.PizzaEntity;
import com.pizzeria.persistence.repository.IPizzaRepository;

@Service
public class PizzaService {
    private final IPizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(IPizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll(){
        return this.pizzaRepository.findAll();
    }
    public PizzaEntity get(Integer idPizza){
        return this.pizzaRepository.findById(idPizza).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza){
        return this.pizzaRepository.save(pizza);
    }
    public boolean exists(Integer idPizza){
        return this.pizzaRepository.existsById(idPizza);
    }

    public void delete(Integer idPizza){
        this.pizzaRepository.deleteById(idPizza);
    }
    
}
