package com.membresias.sistema_membresias.repository;

import com.membresias.sistema_membresias.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByEstadoTrue();

    List<Usuario> findByEstadoTrueAndNombreContainingIgnoreCase(String nombre);

    List<Usuario> findTop2ByEstadoTrueAndNombreContainingIgnoreCase(String nombre);
}