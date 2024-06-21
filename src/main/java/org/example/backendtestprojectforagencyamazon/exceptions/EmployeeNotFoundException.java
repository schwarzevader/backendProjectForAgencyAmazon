package org.example.backendtestprojectforagencyamazon.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Employee not found with id " + id);
    }

    public EmployeeNotFoundException(String name) {
        super("Employee not found with name " + name);
    }
}
