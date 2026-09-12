package com.gimnacio.membresia.service;

import org.springframework.stereotype.Service;

import com.gimnacio.membresia.entity.Usuario;
import com.gimnacio.membresia.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> mostrarActivos() {
        return usuarioRepository.findByEstadoTrue();
    }

    public List<Usuario> mostrarActivosFiltro(String nombre) {
        return usuarioRepository.findByEstadoTrueAndNombreContainingIgnoreCase(nombre);
    }

    public List<Usuario> mostrarActivosFiltroTop(String nombre) {
        return usuarioRepository.findTop2ByEstadoTrueAndNombreContainingIgnoreCase(nombre);
    }
}
