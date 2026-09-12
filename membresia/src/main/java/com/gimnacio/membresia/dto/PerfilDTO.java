package com.gimnacio.membresia.dto;

import lombok.Data;

@Data 
public class PerfilDTO {

    private Integer idPerfil;
    private String nombre;
    private Boolean estado;
    private String descripcion;
}
