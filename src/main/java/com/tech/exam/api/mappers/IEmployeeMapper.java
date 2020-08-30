package com.tech.exam.api.mappers;

import com.tech.exam.api.model.EmployeeRequest;
import com.tech.exam.api.model.EmployeeResponse;
import com.tech.exam.repository.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IEmployeeMapper {

  @Mapping(source = "boss.fullName", target = "boss")
  EmployeeResponse employeeEntityToEmployeeResponse(Employee employeeEntity);

  Employee employeeRequestToEmployeeEntity(EmployeeRequest employeeRequest);
}
