package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Dron;

public interface DronRepository extends JpaRepository<Dron, Long> {
}
