package com.dosalamos.centromedicoapi.repositories;

import com.dosalamos.centromedicoapi.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
