package org.example.backendtestprojectforagencyamazon.controllers;


import lombok.AllArgsConstructor;

import org.example.backendtestprojectforagencyamazon.domain.SomeEmployee;
import org.example.backendtestprojectforagencyamazon.service.interfaces.CRUDEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/crud")
@AllArgsConstructor
public class CRUDEmployeeController {


    private CRUDEmployeeService crudEmployeeService;


    @GetMapping(value = "/employee/{id}")
    ResponseEntity<SomeEmployee> findEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(crudEmployeeService.read(id), HttpStatus.OK);
    }
    @PostMapping(value = "/creat")
    ResponseEntity<SomeEmployee> creatEmployee(@RequestBody SomeEmployee employee){
        return new ResponseEntity<>(crudEmployeeService.create(employee), HttpStatus.CREATED);
    }

    @PutMapping(value = "/uprate")
    ResponseEntity<SomeEmployee> updateEmployee(@RequestBody SomeEmployee employee){
        return new ResponseEntity<>(crudEmployeeService.update(employee), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    ResponseEntity<Object> delete(@PathVariable Long id){
        crudEmployeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
