package com.tech.exam.controller;

import com.tech.exam.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

  @InjectMocks
  private EmployeeController employeeController;

  @Mock
  private IEmployeeService iEmployeeService;

  @Test
  public void test(){

  }

}
