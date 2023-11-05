package com.votaciones.registraduria.service;


import com.votaciones.registraduria.dto.UsuarioDto;
import com.votaciones.registraduria.dto.UsuarioResponse;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    ResponseEntity<UsuarioResponse> response(UsuarioDto usuarioDto);
}
