package org.example.backendtestprojectforagencyamazon.service.implemintations;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.example.backendtestprojectforagencyamazon.domain.SomeEmployee;
import org.example.backendtestprojectforagencyamazon.dto.SomeEmployeeDto;
import org.example.backendtestprojectforagencyamazon.exceptions.EmployeeNotFoundException;
import org.example.backendtestprojectforagencyamazon.repo.EmployeeRepo;
import org.example.backendtestprojectforagencyamazon.service.interfaces.EmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepo employeeRepo;




    @Override
    public SomeEmployeeDto findSomeEmployeeDtoById(Long id) {
        return employeeRepo.findSomeEmployeeDtoById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

    }

    @Override
    public SomeEmployee findSomeEmployeeDtoByName(String name) {
        return employeeRepo.findSomeEmployeeByName(name).orElseThrow(() -> new EmployeeNotFoundException(name));

    }


    @Override
    public List<SomeEmployee> findAll(int pageNumber) {
        Pageable page1 = PageRequest.of(pageNumber, 10, Sort.by(Sort.Order.asc("name")));
        return employeeRepo.findAll(page1).getContent();
    }
}
