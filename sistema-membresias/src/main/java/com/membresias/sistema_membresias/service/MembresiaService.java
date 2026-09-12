package com.gimnacio.membresia.service;

import com.gimnacio.membresia.entity.Membresias;
import com.gimnacio.membresia.repository.MembresiaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MembresiaService {
    private final MembresiaRepository repository;
    public MembresiaService(MembresiaRepository repository) { this.repository = repository; }
    public List<Membresias> listar() { return repository.findAll(); }
    public Membresias guardar(Membresias membresia) { return repository.save(membresia); }
    public Membresias actualizar(Integer id, Membresias membresia) {
        if (!repository.existsById(id)) return null;
        membresia.setIdMembresia(id); return repository.save(membresia);
    }
    public boolean eliminar(Integer id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id); return true;
    }
    public boolean anular(Integer id) {
        Membresias m = repository.findById(id).orElse(null);
        if (m == null) return false;
        m.setEstado(false); repository.save(m); return true;
    }
}