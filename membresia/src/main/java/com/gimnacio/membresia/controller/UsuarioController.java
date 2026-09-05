package com.gimnacio.membresia.controller;

import com.gimnacio.membresia.entity.Usuarios;
import com.gimnacio.membresia.service.UsuarioService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuarios> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Usuarios> crear(@RequestBody Usuarios usuario) {
        return ResponseEntity.ok(service.guardar(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Usuarios usuario) {
        Usuarios r = service.actualizar(id, usuario);
        return r == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return service.eliminar(id) ? ResponseEntity.ok("Usuario eliminado correctamente")
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/anular")
    public ResponseEntity<?> anular(@PathVariable Integer id) {
        return service.anular(id) ? ResponseEntity.ok("Usuario anulado correctamente")
                : ResponseEntity.notFound().build();
    }
}
