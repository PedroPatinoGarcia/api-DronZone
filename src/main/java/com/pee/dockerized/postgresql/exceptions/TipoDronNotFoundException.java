package com.pee.dockerized.postgresql.exceptions;

public class TipoDronNotFoundException extends RuntimeException {
    public TipoDronNotFoundException(Long id) {
    super("No se puede encontrar el tipo de dron con ID: " + id);
    }
}
