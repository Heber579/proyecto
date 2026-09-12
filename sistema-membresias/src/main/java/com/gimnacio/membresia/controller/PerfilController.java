package com.gimnacio.membresia.controller;

import org.springframework.web.bind.annotation.*;

import com.gimnacio.membresia.entity.Perfil;
import com.gimnacio.membresia.repository.PerfilRepository;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
@CrossOrigin(origins = "*")
public class PerfilController {

    private final PerfilRepository perfilRepository;

    public PerfilController(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    // CONSULTAR TODOS
    @GetMapping
    public List<Perfil> listar() {
        return perfilRepository.findAll();
    }

    // CONSULTAR POR ID
    @GetMapping("/{id}")
    public Perfil buscarPorId(@PathVariable Integer id) {
        return perfilRepository.findById(id).orElse(null);
    }

    // CREAR
    @PostMapping
    public Perfil crear(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Perfil actualizar(@PathVariable Integer id, @RequestBody Perfil datos) {

        return perfilRepository.findById(id).map(perfil -> {

            perfil.setNombre(datos.getNombre());
            perfil.setDescripcion(datos.getDescripcion());

            return perfilRepository.save(perfil);

        }).orElse(null);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {

        if (perfilRepository.existsById(id)) {
            perfilRepository.deleteById(id);
            return "Perfil eliminado correctamente";
        }

        return "Perfil no encontrado";
    }
}