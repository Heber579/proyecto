package com.gimnacio.membresia.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class MiembroDTO {
    
    private Integer idMiembro;
    private String nombre;
    private String telefono;
    private LocalDate fechaNacimiento;
    private Boolean estado;
}
