package com.tech.exam.controller.definition;

import com.tech.exam.api.model.EmployeeResponse;
import com.tech.exam.repository.entity.Employee;
import com.tech.exam.exceptions.ServiceException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public interface EmployeeDefinition {

  @GetMapping
  ResponseEntity<List<EmployeeResponse>> findAll() throws ServiceException;

  @GetMapping("/{id}")
  ResponseEntity<EmployeeResponse> findById(@PathVariable Long id) throws ServiceException;

  @PostMapping
  ResponseEntity<String> create(@RequestBody Employee employee) throws ServiceException;

  @PutMapping
  ResponseEntity<String> update(@RequestBody Employee employee) throws ServiceException;

  @PutMapping
  ResponseEntity<String> setBoss(Long idBoss, Long idEmployee) throws ServiceException;

  @DeleteMapping("/{id}")
  ResponseEntity<String> deleteById(@PathVariable Long id) throws ServiceException;

}
