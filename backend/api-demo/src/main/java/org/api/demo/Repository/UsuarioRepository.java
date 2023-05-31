package org.api.demo.Repository;

import java.util.Optional;

import org.api.demo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    Optional<Usuario> findOneByEmail(String email);
}
