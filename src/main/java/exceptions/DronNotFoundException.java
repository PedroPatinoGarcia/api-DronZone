package exceptions;

public class DronNotFoundException extends RuntimeException {
    public DronNotFoundException(Long id) {
    super("No se puede encontrar dron con ID: " + id);
    }
    }