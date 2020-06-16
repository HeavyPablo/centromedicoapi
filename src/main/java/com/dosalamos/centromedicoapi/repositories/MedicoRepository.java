package com.dosalamos.centromedicoapi.repositories;

import com.dosalamos.centromedicoapi.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
