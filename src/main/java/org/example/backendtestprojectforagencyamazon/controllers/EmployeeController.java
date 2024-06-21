package org.example.backendtestprojectforagencyamazon.controllers;


import lombok.AllArgsConstructor;

import org.example.backendtestprojectforagencyamazon.domain.SomeEmployee;
import org.example.backendtestprojectforagencyamazon.dto.SomeEmployeeDto;
import org.example.backendtestprojectforagencyamazon.service.interfaces.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;





    @GetMapping(value = "employeeByName/{name}")
    ResponseEntity<SomeEmployee> findEmployeeByName(@PathVariable("name") String name){
        return new ResponseEntity<>(employeeService.findSomeEmployeeDtoByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "employeeDto/{id}")
    ResponseEntity<SomeEmployeeDto> findEmployeeDtoById(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.findSomeEmployeeDtoById(id), HttpStatus.OK);
    }

//    @PostMapping(value = "all/{n}")
    @GetMapping(value = "all/{n}")
    ResponseEntity<List<SomeEmployee>> getEmployees(@PathVariable("n")int pageNumber){
        return new ResponseEntity<>(employeeService.findAll(pageNumber), HttpStatus.OK);
    }
}
