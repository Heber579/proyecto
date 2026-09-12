package com.gimnacio.membresia.controller;

import com.gimnacio.membresia.entity.Membresias;
import com.gimnacio.membresia.service.MembresiaService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membresias")
public class MembresiaController {
    private final MembresiaService service;

    public MembresiaController(MembresiaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Membresias> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Membresias> crear(@RequestBody Membresias membresia) {
        return ResponseEntity.ok(service.guardar(membresia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Membresias membresia) {
        Membresias r = service.actualizar(id, membresia);
        return r == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return service.eliminar(id) ? ResponseEntity.ok("Membresia eliminada correctamente")
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/anular")
    public ResponseEntity<?> anular(@PathVariable Integer id) {
        return service.anular(id) ? ResponseEntity.ok("Membresia anulada correctamente")
                : ResponseEntity.notFound().build();
    }
}