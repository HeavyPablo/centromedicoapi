package com.dosalamos.centromedicoapi.services;

import com.dosalamos.centromedicoapi.models.Comuna;
import com.dosalamos.centromedicoapi.repositories.ComunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComunaService {

    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> findAll() {
        return comunaRepository.findAll();
    }

    public Optional<Comuna> findById(int id) {
        return comunaRepository.findById(id);
    }

    public Comuna save(Comuna comuna) {
        return comunaRepository.save(comuna);
    }
}
