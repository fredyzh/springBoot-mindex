package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;

public interface EmployeeService {
	Employee create(Employee employee);

	Employee read(String id);

	Employee update(Employee employee);

	/**
	 * create compensation
	 * 
	 * @param compensation
	 * @return
	 */
	Compensation createCompensation(Compensation compensation);

	/**
	 * retrieve compensation by employee id
	 * 
	 * @param empid
	 * @return
	 */
	Compensation getCompensationByEmployeeId(String empid);
}
