package org.example.service;

import org.example.dto.UsuarioDto;
import org.example.dto.UsuarioResponse;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    ResponseEntity<UsuarioResponse> response(UsuarioDto usuarioDto);
}
