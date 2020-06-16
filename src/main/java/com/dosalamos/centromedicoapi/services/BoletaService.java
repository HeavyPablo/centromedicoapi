package com.dosalamos.centromedicoapi.services;

import com.dosalamos.centromedicoapi.models.Boleta;
import com.dosalamos.centromedicoapi.repositories.BoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    public List<Boleta> findAll() {
        return boletaRepository.findAll();
    }

    public Optional<Boleta> findById(int id) {
        return boletaRepository.findById(id);
    }

    public Boleta save(Boleta boleta) {
        return boletaRepository.save(boleta);
    }
}
