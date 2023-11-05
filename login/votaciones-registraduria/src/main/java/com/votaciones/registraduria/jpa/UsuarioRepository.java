package com.votaciones.registraduria.jpa;

import com.votaciones.registraduria.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByUsuarioAndContrasena(String nombre, String contrasena);
}
