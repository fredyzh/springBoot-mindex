package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

public interface EmployeeService {
	Employee create(Employee employee);

	Employee read(String id);

	Employee update(Employee employee);

	Compensation createCompensation(Compensation compensation);

	Compensation getCompensationByEmployeeId(String empid);
}
