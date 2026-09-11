package com.membresias.sistema_membresias.service;

import com.membresias.sistema_membresias.entity.Usuario;
import com.membresias.sistema_membresias.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

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
