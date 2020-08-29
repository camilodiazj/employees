package com.tech.exam.api.model;

import com.tech.exam.repository.entity.Employee;
import lombok.Data;

@Data
public class EmployeeResponse {
  private Long id;
  private String fullName;
  private String function;
  private Employee boss;
}
