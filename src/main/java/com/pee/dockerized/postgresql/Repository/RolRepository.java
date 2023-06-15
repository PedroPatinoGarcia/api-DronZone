package com.pee.dockerized.postgresql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pee.dockerized.postgresql.Model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByUsername(String name);
}
