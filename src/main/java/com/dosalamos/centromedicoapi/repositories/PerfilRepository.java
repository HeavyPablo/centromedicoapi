package com.dosalamos.centromedicoapi.repositories;

import com.dosalamos.centromedicoapi.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
}
