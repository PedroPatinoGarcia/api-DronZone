package com.pee.dockerized.postgresql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pee.dockerized.postgresql.Model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String nombre);
   } 

