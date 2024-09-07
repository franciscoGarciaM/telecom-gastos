package com.telecom.gastos.repository;

import com.telecom.gastos.model.Viatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ViaticoRepository extends JpaRepository<Viatico, Integer> {

    Viatico findByUuidViatico(UUID uuidViatico);
}
