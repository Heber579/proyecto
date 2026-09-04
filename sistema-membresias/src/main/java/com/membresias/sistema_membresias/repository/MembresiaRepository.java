package com.membresias.sistema_membresias.repository;

import com.membresias.sistema_membresias.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
}