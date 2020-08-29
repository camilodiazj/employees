package com.tech.exam.service;

import com.tech.exam.api.model.EmployeeResponse;
import com.tech.exam.repository.entity.Employee;
import com.tech.exam.exceptions.ServiceException;
import java.util.List;

public interface IEmployeeService {

  void create(Employee employee) throws ServiceException;

  EmployeeResponse findById(Long id) throws ServiceException;

  List<EmployeeResponse> findAll() throws ServiceException;

  void update(Employee employee) throws ServiceException;

  void delete(Long id) throws ServiceException;

  void setBoss(Long idBoss, Long idEmployee) throws ServiceException;
}
