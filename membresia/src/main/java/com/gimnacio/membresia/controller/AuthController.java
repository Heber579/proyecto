package com.gimnacio.membresia.controller;

import com.gimnacio.membresia.dto.LoginRequest;
import com.gimnacio.membresia.dto.LoginResponse;
import com.gimnacio.membresia.entity.Usuarios;
import com.gimnacio.membresia.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final UsuarioRepository usuarioRepository;

    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<Usuarios> usuarioOpt = usuarioRepository.findByUsuario(request.getUsuario());

        if (usuarioOpt.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Usuario no encontrado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Usuarios usuario = usuarioOpt.get();

        if (!usuario.getEstado()) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "El usuario se encuentra inactivo");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        if (!usuario.getContrasena().equals(request.getContrasena())) {
            Map<String, String> response = new HashMap<>();
            response.put("mensaje", "Contraseña incorrecta");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        Integer idPerfil = usuario.getIdPerfil() != null ? usuario.getIdPerfil().getIdPerfil() : null;
        String nombrePerfil = usuario.getIdPerfil() != null ? usuario.getIdPerfil().getNombre() : "CLIENTE";
        Integer idMiembro = usuario.getIdMiembro() != null ? usuario.getIdMiembro().getIdMiembro() : null;

        LoginResponse responseData = new LoginResponse(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getUsuario(),
                usuario.getCorreo(),
                idPerfil,
                nombrePerfil,
                idMiembro
        );

        return ResponseEntity.ok(responseData);
    }
}