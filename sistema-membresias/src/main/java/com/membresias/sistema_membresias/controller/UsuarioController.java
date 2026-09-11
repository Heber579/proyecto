package com.membresias.sistema_membresias.controller;

import com.membresias.sistema_membresias.entity.Usuario;
import com.membresias.sistema_membresias.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/mostraractivos")
    public List<Usuario> mostrarActivos() {
        return usuarioService.mostrarActivos();
    }

    @GetMapping("/mostraractivos/{nombre}")
    public List<Usuario> mostrarActivosFiltro(@PathVariable String nombre) {
        return usuarioService.mostrarActivosFiltro(nombre);
    }

    @GetMapping("/mostraractivos/top/{nombre}")
    public List<Usuario> mostrarActivosFiltroTop(@PathVariable String nombre) {
        return usuarioService.mostrarActivosFiltroTop(nombre);
    }
}
