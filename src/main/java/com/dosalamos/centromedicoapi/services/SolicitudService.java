package com.dosalamos.centromedicoapi.services;

import com.dosalamos.centromedicoapi.models.Solicitud;
import com.dosalamos.centromedicoapi.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    public Optional<Solicitud> findById(int id) {
        return solicitudRepository.findById(id);
    }

    public Solicitud save(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }
}
