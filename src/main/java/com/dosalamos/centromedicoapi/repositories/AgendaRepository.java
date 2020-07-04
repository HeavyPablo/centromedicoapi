package com.dosalamos.centromedicoapi.repositories;

import com.dosalamos.centromedicoapi.models.Agenda;
import com.dosalamos.centromedicoapi.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
    List<Agenda> findByMedico(Medico medico);
}
