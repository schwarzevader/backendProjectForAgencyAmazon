package org.example.backendtestprojectforagencyamazon.implemintations;

import lombok.extern.slf4j.Slf4j;

import org.example.backendtestprojectforagencyamazon.domain.SomeEmployee;
import org.example.backendtestprojectforagencyamazon.repo.EmployeeRepo;
import org.example.backendtestprojectforagencyamazon.service.implemintations.CRUDEmployeeServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@SpringBootTest
@Slf4j
class CRUDEmployeeServiceImpTest {

    @Autowired
    private EmployeeRepo employeeRepo;


    @Autowired
    private CRUDEmployeeServiceImp crudEmployeeServiceImp;

    private final String NAME="someName";


    private SomeEmployee newEmployee(){
        return new SomeEmployee(NAME,"user@gmail.com","4379995","login","123");
    }
    @Test
    void creat() {

        // Given
        SomeEmployee someEmployee = crudEmployeeServiceImp
                .create(newEmployee());

        log.info("employee : "+someEmployee.toString());
        // Then
        assertEquals(NAME, someEmployee.getName());
    }

    @Test
    void read() {
        // Given
        Long id = 1000L;
        // When
        SomeEmployee someEmployee= crudEmployeeServiceImp.read(id);
        log.info("employee : "+someEmployee.toString());
        // Then
        assertEquals(id,someEmployee.getId());
    }

    @Test
    void update() {
        // Given
        SomeEmployee originalEmployee = crudEmployeeServiceImp
                .create(newEmployee());
        String updateName = "Updated Name";
        originalEmployee.setName(updateName);
        // When
        SomeEmployee updatedEmployee =crudEmployeeServiceImp.update(originalEmployee);
        // Then
        assertEquals(updateName, updatedEmployee.getName());
    }

    @Test
    void delete() {
        // Given
        SomeEmployee someEmployee = crudEmployeeServiceImp
                .create(newEmployee());
        log.info("employee : "+someEmployee.toString());
        Long id = someEmployee.getId();
        // When
        crudEmployeeServiceImp.delete(id);
        // Then
        assertFalse(employeeRepo.existsById(id));

    }






}