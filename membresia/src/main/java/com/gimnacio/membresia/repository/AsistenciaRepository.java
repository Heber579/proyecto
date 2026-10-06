package com.gimnacio.membresia.repository;

import com.gimnacio.membresia.entity.Asistencias;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencias, Integer> {
    List<Asistencias> findByIdMiembro_IdMiembroOrderByFechaAsistenciaDesc(Integer idMiembro);
}