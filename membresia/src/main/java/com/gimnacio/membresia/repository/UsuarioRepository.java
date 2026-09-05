package com.gimnacio.membresia.repository;

import com.gimnacio.membresia.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
}
