package com.tech.exam.controller;

import com.tech.exam.api.model.EmployeeResponse;
import com.tech.exam.controller.definition.EmployeeDefinition;
import com.tech.exam.exceptions.ServiceException;
import com.tech.exam.repository.entity.Employee;
import com.tech.exam.service.IEmployeeService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;

public class EmployeeController implements EmployeeDefinition {

  private final IEmployeeService employeeService;

  public EmployeeController(IEmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @Override
  public ResponseEntity<List<EmployeeResponse>> findAll() throws ServiceException {
    return ResponseEntity.ok().body(employeeService.findAll());
  }

  @Override
  public ResponseEntity<EmployeeResponse> findById(Long id) throws ServiceException {
    return ResponseEntity.ok().body(employeeService.findById(id));
  }

  @Override
  public ResponseEntity<String> create(Employee employee) throws ServiceException {
    employeeService.create(employee);
    return ResponseEntity.created(URI.create("/employees/" + employee.getFullName())).build();
  }

  @Override
  public ResponseEntity<String> update(Employee employee) throws ServiceException {
    employeeService.update(employee);
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<String> setBoss(Long idBoss, Long idEmployee) throws ServiceException {
    employeeService.setBoss(idBoss, idEmployee);
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<String> deleteById(Long id) throws ServiceException {
    employeeService.delete(id);
    return ResponseEntity.ok().build();
  }
}
