package com.dosalamos.centromedicoapi.repositories;

import com.dosalamos.centromedicoapi.models.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
}
