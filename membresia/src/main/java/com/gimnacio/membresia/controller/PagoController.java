package com.gimnacio.membresia.controller;

import com.gimnacio.membresia.entity.Pagos;
import com.gimnacio.membresia.service.PagoService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class PagoController {
    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pagos> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Pagos> crear(@RequestBody Pagos pago) {
        return ResponseEntity.ok(service.guardar(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Pagos pago) {
        Pagos r = service.actualizar(id, pago);
        return r == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return service.eliminar(id) ? ResponseEntity.ok("Pago eliminado correctamente")
                : ResponseEntity.notFound().build();
    }
}
