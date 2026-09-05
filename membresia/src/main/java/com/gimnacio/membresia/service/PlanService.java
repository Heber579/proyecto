package com.gimnacio.membresia.service;

import com.gimnacio.membresia.entity.Planes;
import com.gimnacio.membresia.repository.PlanRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PlanService {
    private final PlanRepository repository;
    public PlanService(PlanRepository repository) { this.repository = repository; }
    public List<Planes> listar() { return repository.findAll(); }
    public Planes guardar(Planes plan) { return repository.save(plan); }
    public Planes actualizar(Integer id, Planes plan) {
        if (!repository.existsById(id)) return null;
        plan.setIdPlan(id); return repository.save(plan);
    }
    public boolean eliminar(Integer id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id); return true;
    }
    public boolean anular(Integer id) {
        Planes p = repository.findById(id).orElse(null);
        if (p == null) return false;
        p.setEstado(false); repository.save(p); return true;
    }
}
