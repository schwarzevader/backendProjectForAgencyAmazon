package org.example.backendtestprojectforagencyamazon.repo;


import org.example.backendtestprojectforagencyamazon.domain.SomeEmployee;
import org.example.backendtestprojectforagencyamazon.dto.SomeEmployeeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface EmployeeRepo extends JpaRepository<SomeEmployee,Long> {

    Optional<SomeEmployee> findSomeEmployeeByName(String name);

    @Query(value = "select new org.example.backendtestprojectforagencyamazon.dto.SomeEmployeeDto(" +
                   "e.name," +
                   "e.mail," +
                   "e.phoneNumber," +
                   "e.login," +
                   "e.phoneNumber) " +
                   "from Employee e " +
                   "where e.id =:id"
    )
    Optional<SomeEmployeeDto> findSomeEmployeeDtoById(@Param("id") Long id);


}
