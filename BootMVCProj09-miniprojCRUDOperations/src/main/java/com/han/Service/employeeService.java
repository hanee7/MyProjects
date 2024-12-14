package com.han.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.han.Model.employee;
import com.han.Repository.employeeRepository;

@Service
public class employeeService implements IemployeeService {

	@Autowired
	public employeeRepository empRep;
	@Override
	public Iterable<employee> FetchAllEmployee() {
		return empRep.findAll();
	}
	@Override
	public String addEmployee(employee emp) {
		int val=empRep.save(emp).getEmpno();
		return "Employee saved with No :"+val;
	}
		@Override
		public employee editEmployeebyId(int empno) {
			employee emp=empRep.findById(empno).orElseThrow(()->new IllegalArgumentException());
			return emp;
		}
		
		@Override
		public String updateEmpBy(employee emp) {
			return "Employee Updated :"+empRep.save(emp).getEmpno();
		}
		@Override
		public String DeleteEmployee(int empno) {
			empRep.deleteById(empno);
			return "Employee Deleted";
		}
}
