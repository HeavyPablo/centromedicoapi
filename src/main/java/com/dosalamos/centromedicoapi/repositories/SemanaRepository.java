package com.dosalamos.centromedicoapi.repositories;

import com.dosalamos.centromedicoapi.models.Semana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemanaRepository extends JpaRepository<Semana, Integer> {
}
