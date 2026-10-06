package com.gimnacio.membresia.controller;

import com.gimnacio.membresia.entity.Asistencias;
import com.gimnacio.membresia.entity.Miembros;
import com.gimnacio.membresia.repository.AsistenciaRepository;
import com.gimnacio.membresia.repository.MiembroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin(origins = "http://localhost:5173")
public class AsistenciaController {

    private final AsistenciaRepository asistenciaRepository;
    private final MiembroRepository miembroRepository;

    public AsistenciaController(AsistenciaRepository asistenciaRepository, MiembroRepository miembroRepository) {
        this.asistenciaRepository = asistenciaRepository;
        this.miembroRepository = miembroRepository;
    }

    @PostMapping("/checkin/{idMiembro}")
    public ResponseEntity<?> registrarCheckIn(@PathVariable Integer idMiembro) {
        Optional<Miembros> miembroOpt = miembroRepository.findById(idMiembro);
        if (miembroOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("El miembro no existe");
        }

        Asistencias nuevaAsistencia = new Asistencias();
        nuevaAsistencia.setIdMiembro(miembroOpt.get());
        nuevaAsistencia.setFechaAsistencia(LocalDateTime.now());

        Asistencias guardada = asistenciaRepository.save(nuevaAsistencia);
        return ResponseEntity.ok(guardada);
    }

    @GetMapping("/miembro/{idMiembro}")
    public ResponseEntity<List<Asistencias>> obtenerAsistenciasPorMiembro(@PathVariable Integer idMiembro) {
        return ResponseEntity.ok(asistenciaRepository.findByIdMiembro_IdMiembroOrderByFechaAsistenciaDesc(idMiembro));
    }
}