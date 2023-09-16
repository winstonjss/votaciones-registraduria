package org.example.controller;

import org.example.dto.UsuarioDto;
import org.example.dto.UsuarioResponse;
import org.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerIniciarSesion {

    @Autowired
    private UsuarioService service;
    @PostMapping
    @RequestMapping(value = "/iniciar-sesion")
    public ResponseEntity<UsuarioResponse> iniciarSesion(@RequestBody UsuarioDto usuarioDto){
        return service.response(usuarioDto);
    }
}
