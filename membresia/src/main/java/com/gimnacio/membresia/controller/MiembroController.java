package com.gimnacio.membresia.controller;

import com.gimnacio.membresia.entity.Miembros;
import com.gimnacio.membresia.service.MiembroService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/miembros")
public class MiembroController {
    private final MiembroService service;

    public MiembroController(MiembroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Miembros> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Miembros> crear(@RequestBody Miembros miembro) {
        return ResponseEntity.ok(service.guardar(miembro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Miembros miembro) {
        Miembros r = service.actualizar(id, miembro);
        return r == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return service.eliminar(id) ? ResponseEntity.ok("Miembro eliminado correctamente")
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/anular")
    public ResponseEntity<?> anular(@PathVariable Integer id) {
        return service.anular(id) ? ResponseEntity.ok("Miembro anulado correctamente")
                : ResponseEntity.notFound().build();
    }
}
