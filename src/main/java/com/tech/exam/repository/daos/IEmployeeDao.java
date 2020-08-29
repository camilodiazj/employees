package com.tech.exam.repository.daos;

import com.tech.exam.repository.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeDao extends CrudRepository<Employee,Long> {
}
