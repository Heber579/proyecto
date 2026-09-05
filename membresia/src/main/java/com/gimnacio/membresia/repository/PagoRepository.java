package com.gimnacio.membresia.repository;

import com.gimnacio.membresia.entity.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pagos, Integer> {
}
