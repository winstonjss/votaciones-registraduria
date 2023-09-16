package org.example.service.impl;

import org.example.dto.UsuarioDto;
import org.example.dto.UsuarioResponse;
import org.example.jpa.UsuarioRepository;
import org.example.model.Usuario;
import org.example.service.UsuarioService;
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
