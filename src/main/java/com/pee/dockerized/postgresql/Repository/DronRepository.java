package com.pee.dockerized.postgresql.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pee.dockerized.postgresql.Model.Dron;
import com.pee.dockerized.postgresql.Model.TipoDron;

public interface DronRepository extends JpaRepository<Dron, Long> {
    List<Dron> findByTipoDron(TipoDron tipoDron);
}

   