package com.gimnacio.membresia.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data 
public class InicioDTO {
    
    private Long totalMiembrosActivos;
    private Long totalMembresiasVigentes;
    private Long membresiasPorVencer;
    private BigDecimal ingresosDelMes;
    private Long totalUsuariosSistema;
}
