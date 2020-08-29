package com.tech.exam.api.mappers;

import com.tech.exam.api.model.EmployeeResponse;
import com.tech.exam.repository.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper {

  EmployeeResponse employeeEntityToEmployeeResponse(Employee employeeEntity);

}
