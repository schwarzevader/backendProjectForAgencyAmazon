package org.example.backendtestprojectforagencyamazon.service.interfaces;



import org.example.backendtestprojectforagencyamazon.domain.SomeEmployee;
import org.example.backendtestprojectforagencyamazon.dto.SomeEmployeeDto;

import java.util.List;

public interface EmployeeService  {


    public SomeEmployee findSomeEmployeeDtoByName(String name);

    public SomeEmployeeDto findSomeEmployeeDtoById(Long id);
    List<SomeEmployee> findAll(int pageNumber);
 }
