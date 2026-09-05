package com.gimnacio.membresia.repository;

import com.gimnacio.membresia.entity.Miembros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiembroRepository extends JpaRepository<Miembros, Integer> {
}
