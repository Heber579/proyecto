package com.gimnacio.membresia.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data 
public class PlanDTO {
    private Integer idPlan;
    private String nombre;
    private Integer duracionMeses;
    private BigDecimal precio;
    private Boolean estado;

}
