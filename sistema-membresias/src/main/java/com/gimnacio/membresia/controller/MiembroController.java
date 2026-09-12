package com.gimnacio.membresia.controller;

import com.gimnacio.membresia.entity.Miembro;
import com.gimnacio.membresia.service.MiembroService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/miembros")
public class MiembroController {

    private final MiembroService miembroService;

    public MiembroController(MiembroService miembroService) {
        this.miembroService = miembroService;
    }

    @GetMapping
    public List<Miembro> listar() {
        return miembroService.listar();
    }

    @GetMapping("/{id}")
    public Miembro buscar(@PathVariable Integer id) {
        return miembroService.buscar(id);
    }

    @PostMapping
    public Miembro guardar(@RequestBody Miembro miembro) {
        return miembroService.guardar(miembro);
    }

    @PutMapping("/{id}")
    public Miembro actualizar(
            @PathVariable Integer id,
            @RequestBody Miembro miembro) {

        return miembroService.actualizar(id, miembro);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        return miembroService.eliminar(id);
    }
}