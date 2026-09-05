package com.gimnacio.membresia.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    @GetMapping("/")
    public String inicio() {
        return "Sistema de Membresías funcionando correctamente";
    }
}