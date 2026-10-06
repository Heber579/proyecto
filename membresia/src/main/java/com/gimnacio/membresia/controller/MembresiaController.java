package com.gimnacio.membresia.controller;

import com.gimnacio.membresia.entity.Membresias;
import com.gimnacio.membresia.service.MembresiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membresias")
@CrossOrigin(origins = "http://localhost:5173")
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
        return service.eliminar(id) ? ResponseEntity.ok("Membresía eliminada correctamente")
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/anular")
    public ResponseEntity<?> anular(@PathVariable Integer id) {
        return service.anular(id) ? ResponseEntity.ok("Membresía anulada correctamente")
                : ResponseEntity.notFound().build();
    }
}