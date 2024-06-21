package com.concessionaria.lucasVendedor.repository;

import com.concessionaria.lucasVendedor.domain.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carros,Long> {
}
