package com.gimnacio.membresia.repository;

import com.gimnacio.membresia.entity.Membresias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembresiaRepository extends JpaRepository<Membresias, Integer> {
}
