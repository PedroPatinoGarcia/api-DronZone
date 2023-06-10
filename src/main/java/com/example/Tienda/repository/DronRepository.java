package com.example.Tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Tienda.domain.Dron;

public interface DronRepository extends JpaRepository<Dron, Long> {
}
