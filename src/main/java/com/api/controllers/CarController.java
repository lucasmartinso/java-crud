package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.model.Car; 
import com.api.dto.CarDTO;
import com.api.repositories.CarRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/")
public class CarController {

    @Autowired
    private CarRepository repository;

    @GetMapping 
    public List<Car> listAll() { 
        return repository.findAll();
    }
    
    @PostMapping
    public void Car(@RequestBody CarDTO req) { 
        System.out.println(req);
        repository.save(new Car(req));
    }

    @DeleteMapping("/{id}") 
    public void delete(@PathVariable Long id) { 
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody CarDTO req) {
        repository.findById(id).map(car -> { 
            car.setModelo(req.modelo());
            car.setFabricante(req.fabricante());
            car.setDataFabricacao(req.dataFabricacao());
            car.setValor(req.valor());
            car.setAnoModelo(req.anoModelo());
            return repository.save(car);
        });
    }
}
