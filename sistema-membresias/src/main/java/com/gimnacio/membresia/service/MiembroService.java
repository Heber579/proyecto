package com.gimnacio.membresia.service;

import com.gimnacio.membresia.entity.Miembro;
import com.gimnacio.membresia.repository.MiembroRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MiembroService {

    private final MiembroRepository repository;

    public MiembroService(MiembroRepository repository) {
        this.repository = repository;
    }


    public List<Miembro> listar() {
        return repository.findAll();
    }

    public Miembro buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Miembro guardar(Miembro miembro) {
        return repository.save(miembro);
    }

    public Miembro actualizar(Integer id, Miembro miembro) {

        if (!repository.existsById(id)) {
            return null;
        }

        miembro.setIdMiembro(id);

        return repository.save(miembro);
    }

    public String eliminar(Integer id) {

        if (!repository.existsById(id)) {
            return "Miembro no encontrado";
        }

        repository.deleteById(id);

        return "Miembro eliminado correctamente";
    }

    public boolean anular(Integer id) {

        Miembro miembro = repository.findById(id).orElse(null);

        if (miembro == null) {
            return false;
        }

        miembro.setEstado(false);
        repository.save(miembro);

        return true;
    }
}