package com.tech.exam.api.model;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeRequest {

  @NotBlank(message = "fullName is mandatory")
  private String fullName;
  @NotBlank(message = "function is mandatory")
  private String function;
}
