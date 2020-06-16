package com.dosalamos.centromedicoapi.repositories;

import com.dosalamos.centromedicoapi.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
}
