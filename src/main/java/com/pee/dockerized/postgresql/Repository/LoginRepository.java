package com.pee.dockerized.postgresql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pee.dockerized.postgresql.Model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
    

