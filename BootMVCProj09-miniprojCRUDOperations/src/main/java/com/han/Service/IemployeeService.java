package com.han.Service;

import com.han.Model.employee;

public interface IemployeeService {

	public Iterable<employee> FetchAllEmployee();
	public String addEmployee(employee emp);
	public employee editEmployeebyId(int empno);
	public String updateEmpBy(employee emp);
	public String DeleteEmployee(int empno);
}
