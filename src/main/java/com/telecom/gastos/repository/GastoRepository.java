package com.telecom.gastos.repository;

import com.telecom.gastos.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Integer> {
    /*
    List<Gasto> findByIdViaticoId(Integer idViatico);
    Gasto findByUuidGasto(UUID uuidGasto);

     */


}
