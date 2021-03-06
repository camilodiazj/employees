package com.tech.exam.service;

import com.tech.exam.api.mappers.IEmployeeMapper;
import com.tech.exam.api.model.EmployeeRequest;
import com.tech.exam.api.model.EmployeeResponse;
import com.tech.exam.exceptions.BusinessException;
import com.tech.exam.exceptions.ServiceException;
import com.tech.exam.repository.daos.IEmployeeDao;
import com.tech.exam.repository.entity.Employee;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class EmployeeServiceImpl implements IEmployeeService {


  private final IEmployeeDao iEmployeeDao;
  private final IEmployeeMapper employeeMapper;

  public EmployeeServiceImpl(IEmployeeDao iEmployeeDao,
      IEmployeeMapper employeeMapper) {
    this.iEmployeeDao = iEmployeeDao;
    this.employeeMapper = employeeMapper;
  }

  @Override
  @Transactional
  public void create(EmployeeRequest employee) throws ServiceException {
    try {
      iEmployeeDao.save(employeeMapper.employeeRequestToEmployeeEntity(employee));
    } catch (Exception e) {
      log.error("Error EmployeeServiceImpl::create");
      throw new ServiceException("Error EmployeeServiceImpl::create");
    }
  }

  @Override
  @Transactional(readOnly = true)
  public EmployeeResponse findById(Long id) throws ServiceException {
    try {
      Employee employee = iEmployeeDao.findById(id)
          .orElseThrow(() -> new BusinessException("Employee not found"));
      return employeeMapper.employeeEntityToEmployeeResponse(employee);
    } catch (BusinessException e) {
      log.error("Employee not found", e);
      throw e;
    } catch (Exception e) {
      log.error("Error EmployeeServiceImpl::findAll", e);
      throw new ServiceException("Error EmployeeServiceImpl::findById", e);
    }
  }

  @Override
  @Transactional(readOnly = true)
  public List<EmployeeResponse> findAll() throws ServiceException {
    try {
      List<Employee> employees = (List<Employee>) iEmployeeDao.findAll();

      return employees.stream()
          .map(employeeMapper::employeeEntityToEmployeeResponse)
          .collect(Collectors.toList());

    } catch (Exception e) {
      log.error("Error EmployeeServiceImpl::findAll", e);
      throw new ServiceException("Error EmployeeServiceImpl::findAll", e);
    }
  }

  @Override
  @Transactional
  public void update(Employee employee) throws ServiceException {
    try {
      iEmployeeDao.save(employee);
    } catch (Exception e) {
      log.error("Error EmployeeServiceImpl::update", e);
      throw new ServiceException("Error EmployeeServiceImpl::update", e);
    }
  }

  @Override
  @Transactional
  public void delete(Long id) throws ServiceException {
    try {
      iEmployeeDao.deleteById(id);
    } catch (Exception e) {
      log.error("Error EmployeeServiceImpl::delete", e);
      throw new ServiceException("Error EmployeeServiceImpl::delete", e);
    }
  }

  @Override
  @Transactional
  public void setBoss(Long idBoss, Long idEmployee) throws ServiceException {
    try {
      Employee employee = iEmployeeDao.findById(idEmployee)
          .orElseThrow(() -> new BusinessException("Employee not found"));

      Employee boss = iEmployeeDao.findById(idBoss)
          .orElseThrow(() -> new BusinessException("Boss not found"));

      employee.setBoss(boss);
      iEmployeeDao.save(employee);
    } catch (BusinessException e) {
      throw e;
    } catch (Exception e) {
      log.error("Error EmployeeServiceImpl::setBoss", e);
      throw new ServiceException("Error EmployeeServiceImpl::setBoss", e);
    }
  }

}
