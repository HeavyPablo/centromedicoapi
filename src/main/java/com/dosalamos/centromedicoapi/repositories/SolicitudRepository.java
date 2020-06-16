package com.dosalamos.centromedicoapi.repositories;

import com.dosalamos.centromedicoapi.models.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
}
