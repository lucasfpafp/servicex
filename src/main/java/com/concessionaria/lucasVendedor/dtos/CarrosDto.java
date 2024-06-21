package com.concessionaria.lucasVendedor.dtos;

import com.concessionaria.lucasVendedor.domain.Carros;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CarrosDto {

    private Long id;

    private String nome;

    private String modelo;

    public CarrosDto(Carros carros) {
        this.id = carros.getId();
        this.nome = carros.getNome();
        this.modelo = carros.getModelo();
    }
}
