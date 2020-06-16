package com.dosalamos.centromedicoapi.repositories;

import com.dosalamos.centromedicoapi.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
}
