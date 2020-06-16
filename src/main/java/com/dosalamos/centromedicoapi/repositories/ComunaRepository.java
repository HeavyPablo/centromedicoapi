package com.dosalamos.centromedicoapi.repositories;

import com.dosalamos.centromedicoapi.models.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {
}
