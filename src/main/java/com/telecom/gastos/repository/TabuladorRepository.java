package com.telecom.gastos.repository;


import com.telecom.gastos.model.Tabulador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabuladorRepository extends JpaRepository<Tabulador, Integer> {

}