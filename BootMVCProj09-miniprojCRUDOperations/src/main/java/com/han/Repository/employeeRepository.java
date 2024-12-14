package com.han.Repository;

import org.springframework.data.repository.CrudRepository;

import com.han.Model.employee;

public interface employeeRepository extends CrudRepository<employee, Integer> {

}
