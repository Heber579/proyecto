package com.gimnacio.membresia.controller;

import com.gimnacio.membresia.entity.Perfiles;
import com.gimnacio.membresia.service.PerfilService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {
    private final PerfilService service;

    public PerfilController(PerfilService service) {
        this.service = service;
    }

    @GetMapping
    public List<Perfiles> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Perfiles> crear(@RequestBody Perfiles perfil) {
        return ResponseEntity.ok(service.guardar(perfil));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Perfiles perfil) {
        Perfiles r = service.actualizar(id, perfil);
        return r == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return service.eliminar(id) ? ResponseEntity.ok("Perfil eliminado correctamente")
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/anular")
    public ResponseEntity<?> anular(@PathVariable Integer id) {
        return service.anular(id) ? ResponseEntity.ok("Perfil anulado correctamente")
                : ResponseEntity.notFound().build();
    }
}
