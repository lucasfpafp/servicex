package com.concessionaria.lucasVendedor.controller;


import com.concessionaria.lucasVendedor.domain.Carros;
import com.concessionaria.lucasVendedor.domain.Client;
import com.concessionaria.lucasVendedor.dtos.CarrosDto;
import com.concessionaria.lucasVendedor.service.carrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carro")
public class CarroController {


    @Autowired
    private carrosService carrosService;

    @GetMapping
    public ResponseEntity<List<CarrosDto>> findAll(){
        List<Carros> carros = carrosService.getAllCars();
        List<CarrosDto> carrostDTOS = carros.stream()
                .map(CarrosDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(carrostDTOS);
    }

    @PostMapping
    public ResponseEntity<Carros> save(@RequestBody CarrosDto carrosDto) {
        Carros carros = carrosService.create(carrosDto);
        return new ResponseEntity<>(carros, HttpStatus.CREATED);
    }
}
