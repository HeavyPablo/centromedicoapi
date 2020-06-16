package com.dosalamos.centromedicoapi.services;

import com.dosalamos.centromedicoapi.models.Perfil;
import com.dosalamos.centromedicoapi.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    public Optional<Perfil> findById(int id) {
        return perfilRepository.findById(id);
    }

    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }
}
