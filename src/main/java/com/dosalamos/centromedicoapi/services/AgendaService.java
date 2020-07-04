package com.dosalamos.centromedicoapi.services;

import com.dosalamos.centromedicoapi.models.Agenda;
import com.dosalamos.centromedicoapi.models.Medico;
import com.dosalamos.centromedicoapi.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    public Optional<Agenda> findById(int id) {
        return agendaRepository.findById(id);
    }

    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public List<Agenda> findByMedico(Medico medico) { return agendaRepository.findByMedico(medico); }
}
