package com.gimnacio.membresia.service;

import com.gimnacio.membresia.entity.Usuarios;
import com.gimnacio.membresia.repository.UsuarioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    public UsuarioService(UsuarioRepository repository) { this.repository = repository; }
    public List<Usuarios> listar() { return repository.findAll(); }
    public Usuarios guardar(Usuarios usuario) { return repository.save(usuario); }
    public Usuarios actualizar(Integer id, Usuarios usuario) {
        if (!repository.existsById(id)) return null;
        usuario.setIdUsuario(id); return repository.save(usuario);
    }
    public boolean eliminar(Integer id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id); return true;
    }
    public boolean anular(Integer id) {
        Usuarios u = repository.findById(id).orElse(null);
        if (u == null) return false;
        u.setEstado(false); repository.save(u); return true;
    }
}
