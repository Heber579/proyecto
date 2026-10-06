package com.gimnacio.membresia.repository;

import com.gimnacio.membresia.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
    Optional<Usuarios> findByUsuario(String usuario);
}