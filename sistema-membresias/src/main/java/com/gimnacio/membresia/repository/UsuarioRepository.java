package com.gimnacio.membresia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gimnacio.membresia.entity.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByEstadoTrue();

    List<Usuario> findByEstadoTrueAndNombreContainingIgnoreCase(String nombre);

    List<Usuario> findTop2ByEstadoTrueAndNombreContainingIgnoreCase(String nombre);
}