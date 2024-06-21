package org.example.backendtestprojectforagencyamazon.service.interfaces;


import org.example.backendtestprojectforagencyamazon.domain.SomeEmployee;

public interface CRUDEmployeeService {

   SomeEmployee create(SomeEmployee someEmployee);
   SomeEmployee read(Long id);

   SomeEmployee update(SomeEmployee someEmployee);

   void delete(Long id);
}
