package com.pee.dockerized.postgresql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pee.dockerized.postgresql.Model.Dron;

public interface DronRepository extends JpaRepository<Dron, Long> {

}
   