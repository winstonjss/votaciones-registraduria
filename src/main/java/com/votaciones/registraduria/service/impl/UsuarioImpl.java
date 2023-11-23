package com.votaciones.registraduria.service.impl;

import com.votaciones.registraduria.dto.UsuarioDto;
import com.votaciones.registraduria.dto.UsuarioResponse;
import com.votaciones.registraduria.jpa.UsuarioRepository;


import com.votaciones.registraduria.model.Usuario;
import com.votaciones.registraduria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public ResponseEntity<UsuarioResponse> response(UsuarioDto usuarioDto) {

        try {
            Optional<Usuario> validarSesion = usuarioRepository.findByUsuarioAndContrasena(usuarioDto.getNombreUsuario()
                    ,usuarioDto.getPassword()
            );

            if (validarSesion.isPresent()) {
                UsuarioResponse usuarioResponse = new UsuarioResponse();
                usuarioResponse.setRol(validarSesion.get().getRol().toString());
                usuarioResponse.setSesionIniciada(true);
                return ResponseEntity.ok(usuarioResponse);
            } else {
                UsuarioResponse usuarioResponse = new UsuarioResponse();
                usuarioResponse.setRol("");
                usuarioResponse.setSesionIniciada(false);
                return ResponseEntity.ok(usuarioResponse);
            }
        }
        catch (Exception e){
            return null;
        }
    }

}