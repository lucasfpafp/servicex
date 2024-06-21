package com.concessionaria.lucasVendedor.domain;

import com.concessionaria.lucasVendedor.dtos.CarrosDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Carros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String modelo;

    public Carros(CarrosDto carrosDto) {
        super();
        this.id = carrosDto.getId();
        this.nome = carrosDto.getNome();
        this.modelo = carrosDto.getModelo();
    }
}
