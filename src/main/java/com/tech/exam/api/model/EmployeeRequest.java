package com.tech.exam.api.model;

import com.tech.exam.repository.entity.Employee;
import lombok.Data;

@Data
public class EmployeeRequest { //TODO: THON ABOUT UPDATE. need an ID
  private String fullName;
  private String function;
  private Employee boss;
}
