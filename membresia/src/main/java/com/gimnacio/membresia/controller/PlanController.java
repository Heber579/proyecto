package com.gimnacio.membresia.controller;

import com.gimnacio.membresia.entity.Planes;
import com.gimnacio.membresia.service.PlanService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planes")
public class PlanController {
    private final PlanService service;

    public PlanController(PlanService service) {
        this.service = service;
    }

    @GetMapping
    public List<Planes> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Planes> crear(@RequestBody Planes plan) {
        return ResponseEntity.ok(service.guardar(plan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Planes plan) {
        Planes r = service.actualizar(id, plan);
        return r == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return service.eliminar(id) ? ResponseEntity.ok("Plan eliminado correctamente")
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/anular")
    public ResponseEntity<?> anular(@PathVariable Integer id) {
        return service.anular(id) ? ResponseEntity.ok("Plan anulado correctamente") : ResponseEntity.notFound().build();
    }
}
