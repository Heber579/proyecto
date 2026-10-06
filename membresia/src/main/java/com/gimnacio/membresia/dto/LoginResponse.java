package com.gimnacio.membresia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private Integer idUsuario;
    private String nombre;
    private String usuario;
    private String correo;
    private Integer idPerfil;
    private String perfilNombre;
    private Integer idMiembro;
}
