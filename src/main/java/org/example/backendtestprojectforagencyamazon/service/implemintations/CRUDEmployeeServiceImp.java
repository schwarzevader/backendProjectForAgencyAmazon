package org.example.backendtestprojectforagencyamazon.service.implemintations;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.backendtestprojectforagencyamazon.service.interfaces.CRUDEmployeeService;
import org.springframework.stereotype.Service;
import org.example.backendtestprojectforagencyamazon.domain.SomeEmployee;
import org.example.backendtestprojectforagencyamazon.repo.EmployeeRepo;
import org.example.backendtestprojectforagencyamazon.exceptions.EmployeeNotFoundException;

@Service
@Transactional
@AllArgsConstructor
public class CRUDEmployeeServiceImp implements CRUDEmployeeService {
    private EmployeeRepo employeeRepo;
    @Override
    public SomeEmployee create(SomeEmployee someEmployee) {
        return employeeRepo.save(someEmployee);
    }

    @Override
    public SomeEmployee read(Long id) {
        return employeeRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
    }

    @Override
    public SomeEmployee update(SomeEmployee someEmployee) {
        SomeEmployee employee = employeeRepo.findById(someEmployee.getId())
                .orElseThrow(()->new EmployeeNotFoundException(someEmployee.getId()));
        employee.setMail(someEmployee.getMail());
        employee.setLogin(someEmployee.getLogin());
        employee.setName(someEmployee.getName());
        employee.setPassword(someEmployee.getPassword());
        employee.setPhoneNumber(someEmployee.getPhoneNumber());
        return employeeRepo.save(employee);
    }

    @Override
    public void delete(Long id) {
         employeeRepo.deleteById(id);
    }
}
