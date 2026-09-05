package com.gimnacio.membresia.service;

import com.gimnacio.membresia.entity.Pagos;
import com.gimnacio.membresia.repository.PagoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PagoService {
    private final PagoRepository repository;
    public PagoService(PagoRepository repository) { this.repository = repository; }
    public List<Pagos> listar() { return repository.findAll(); }
    public Pagos guardar(Pagos pago) { return repository.save(pago); }
    public Pagos actualizar(Integer id, Pagos pago) {
        if (!repository.existsById(id)) return null;
        pago.setIdPago(id); return repository.save(pago);
    }
    public boolean eliminar(Integer id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id); return true;
    }
}
