package com.pizzeria.controller;


import org.springframework.web.bind.annotation.*;
import com.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import com.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @RequestMapping
    public ResponseEntity<List<PizzaEntity>> getAll(){
        return ResponseEntity.ok(pizzaService.getAll());
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> get(@PathVariable int idPizza){
            return ResponseEntity.ok(pizzaService.get(idPizza));
        }

    @PostMapping
    public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizza){
        if (pizza.getIdPizza()==null || !this.pizzaService.exists(pizza.getIdPizza())){
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza){
        if (pizza.getIdPizza()!=null && this.pizzaService.exists(pizza.getIdPizza())){
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> delete(@PathVariable int idPizza){
        if (pizzaService.exists(idPizza)){
            pizzaService.delete(idPizza);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
