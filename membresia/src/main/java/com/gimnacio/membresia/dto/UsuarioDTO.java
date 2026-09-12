package com.gimnacio.membresia.dto;

import lombok.Data;

@Data 
public class UsuarioDTO {

    private Integer idUsuario;
    private Integer idPerfil;
    private String nombre;
    private String usuario;
    private String contrasena;
    private String correo;
    private Boolean estado;

}
