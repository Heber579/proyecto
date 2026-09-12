package com.gimnacio.membresia.service;

import com.gimnacio.membresia.entity.Membresia;
import com.gimnacio.membresia.repository.MembresiaRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MembresiaService {

    private final MembresiaRepository repository;

    public MembresiaService(MembresiaRepository repository) {
        this.repository = repository;
    }

    public List<Membresia> listar() {
        return repository.findAll();
    }

    public Membresia guardar(Membresia membresia) {
        return repository.save(membresia);
    }

    public Membresia actualizar(Integer id, Membresia membresia) {

        if (!repository.existsById(id)) {
            return null;
        }

        membresia.setIdMembresia(id);

        return repository.save(membresia);
    }

    public boolean eliminar(Integer id) {

        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }

    public boolean anular(Integer id) {

        Membresia membresia = repository.findById(id).orElse(null);

        if (membresia == null) {
            return false;
        }

       membresia.setEstado("Anulada");

        repository.save(membresia);

        return true;
    }
}