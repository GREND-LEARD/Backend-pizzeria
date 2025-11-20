package com.pizzeria.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.pizzeria.persistence.entity.PizzaEntity;
import com.pizzeria.persistence.repository.IPizzaRepository;
import com.pizzeria.persistence.repository.PizzaPagSortRepository;
import org.springframework.data.domain.Pageable;

@Service
public class PizzaService {
    private final IPizzaRepository pizzaRepository;
    private final PizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaService(IPizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
    }

    public Page<PizzaEntity> getAll(int page, int elements){
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.pizzaPagSortRepository.findAll(pageRequest);
    }
    public PizzaEntity get(Integer idPizza){
        return this.pizzaRepository.findById(idPizza).orElse(null);
    }
    public List<PizzaEntity> getAvailable(){
        this.pizzaRepository.countByVeganTrue();
        return this.pizzaRepository.findByAvailableTrueOrderByPrice();
    }

    public PizzaEntity getByName(String name){
        return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(() -> new RuntimeException("La pizza no existe"));
    }

    public List<PizzaEntity> getWith(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }
    public List<PizzaEntity> getWithout(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getCheapest (double price){
        return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
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
