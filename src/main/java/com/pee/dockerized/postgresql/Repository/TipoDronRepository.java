package com.pee.dockerized.postgresql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pee.dockerized.postgresql.Model.TipoDron;

public interface TipoDronRepository extends JpaRepository<TipoDron, Long> {

}
   