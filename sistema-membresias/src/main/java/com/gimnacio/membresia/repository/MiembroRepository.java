package com.gimnacio.membresia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gimnacio.membresia.entity.Miembro;

@Repository
public interface MiembroRepository extends JpaRepository<Miembro, Integer> {

}