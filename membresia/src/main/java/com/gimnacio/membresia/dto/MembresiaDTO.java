package com.gimnacio.membresia.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class MembresiaDTO {
    
    private Integer idMembresia;
    private Integer idMiembro;
    private Integer idPlan;
    private Integer idUsuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean estado;
}
