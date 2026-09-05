package com.gimnacio.membresia.service;

import com.gimnacio.membresia.entity.Perfiles;
import com.gimnacio.membresia.repository.PerfilRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {
    private final PerfilRepository repository;
    public PerfilService(PerfilRepository repository) { this.repository = repository; }
    public List<Perfiles> listar() { return repository.findAll(); }
    public Perfiles guardar(Perfiles perfil) { return repository.save(perfil); }
    public Perfiles actualizar(Integer id, Perfiles perfil) {
        if (!repository.existsById(id)) return null;
        perfil.setIdPerfil(id); return repository.save(perfil);
    }
    public boolean eliminar(Integer id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id); return true;
    }
    public boolean anular(Integer id) {
        Perfiles p = repository.findById(id).orElse(null);
        if (p == null) return false;
        p.setEstado(false); repository.save(p); return true;
    }
}
