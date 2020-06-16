package com.dosalamos.centromedicoapi.services;

import com.dosalamos.centromedicoapi.models.Semana;
import com.dosalamos.centromedicoapi.repositories.SemanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemanaService {

    @Autowired
    private SemanaRepository semanaRepository;

    public List<Semana> findAll() {
        return semanaRepository.findAll();
    }

     public Optional<Semana> findById(int id) {
        return semanaRepository.findById(id);
     }

     public Semana save(Semana semana) {
        return semanaRepository.save(semana);
     }
}
