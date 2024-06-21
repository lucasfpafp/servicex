package com.concessionaria.lucasVendedor.service;

import com.concessionaria.lucasVendedor.domain.Carros;
import com.concessionaria.lucasVendedor.dtos.CarrosDto;
import com.concessionaria.lucasVendedor.repository.ClienteRepository;
import com.concessionaria.lucasVendedor.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class carrosService {

    @Autowired
    private CarroRepository CarroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Carros> getAllCars() {
        return CarroRepository.findAll();
    }

    public Carros findById(Long id) {
        Optional<Carros> optionalCar = CarroRepository.findById(id);
        return optionalCar.orElse(null);
    }

    public Carros create(CarrosDto carrosDto) {
        carrosDto.setId(null);
        Carros carros = new Carros(carrosDto);
        return CarroRepository.save(carros);
    }

    public Carros updateCar(Long id, Carros carros) {
        Optional<Carros> optionalCar = CarroRepository.findById(id);
        if (optionalCar.isPresent()) {
            Carros carrosExistentes = optionalCar.get();
            BeanUtils.copyProperties(carros, carrosExistentes);
            return CarroRepository.save(carrosExistentes);
        } else {
            return null;
        }
    }

    public boolean deleteCar(Long id) {
        Optional<Carros> optionalCar = CarroRepository.findById(id);
        if (optionalCar.isPresent()) {
            CarroRepository.delete(optionalCar.get());
            return true;
        } else {
            return false;
        }
    }
}
