package com.votaciones.registraduria.controller;

import com.votaciones.registraduria.dto.UsuarioDto;
import com.votaciones.registraduria.dto.UsuarioResponse;
import com.votaciones.registraduria.service.UsuarioService;
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