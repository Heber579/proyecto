package com.gimnacio.membresia.service;

import com.gimnacio.membresia.entity.Miembros;
import com.gimnacio.membresia.repository.MiembroRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MiembroService {
    private final MiembroRepository repository;
    public MiembroService(MiembroRepository repository) { this.repository = repository; }
    public List<Miembros> listar() { return repository.findAll(); }
    public Miembros guardar(Miembros miembro) { return repository.save(miembro); }
    public Miembros actualizar(Integer id, Miembros miembro) {
        if (!repository.existsById(id)) return null;
        miembro.setIdMiembro(id); return repository.save(miembro);
    }
    public boolean eliminar(Integer id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id); return true;
    }
    public boolean anular(Integer id) {
        Miembros m = repository.findById(id).orElse(null);
        if (m == null) return false;
        m.setEstado(false); repository.save(m); return true;
    }
}
