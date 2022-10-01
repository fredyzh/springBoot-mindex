package com.mindex.challenge.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee create(Employee employee) {
		LOG.debug("Creating employee [{}]", employee);

		employee.setEmployeeId(UUID.randomUUID().toString());
		employeeRepository.insert(employee);

		return employee;
	}

	@Override
	public Employee read(String id) {
		LOG.debug("Creating employee with id [{}]", id);

		Employee employee = employeeRepository.findByEmployeeId(id);

		if (employee == null) {
			throw new RuntimeException("Invalid employeeId: " + id);
		}

		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		LOG.debug("Updating employee [{}]", employee);

		return employeeRepository.save(employee);
	}

	@Override
	public Compensation createCompensation(Compensation compensation) {
		LOG.debug("Creating createCompensation [{}]", compensation);

		if (compensation.getEmployee() == null || compensation.getEmployee().getEmployeeId() == null) {
			throw new RuntimeException("Invalid employee");
		}

		Employee employee = employeeRepository.findByEmployeeId(compensation.getEmployee().getEmployeeId());

		/**
		 * depends on business requirement if (employee == null) {
		 * compensation.getEmployee().setEmployeeId(UUID.randomUUID().toString());
		 * employeeRepository.insert(employee); }
		 */

		if (employee == null) {
			throw new RuntimeException("unable to find employee, please create employee first.");
		}
			
		employee.setCompensation(compensation);
		employeeRepository.save(employee);

		return compensation;
	}
	
	@Override
	public Compensation getCompensationByEmployeeId(String id) {
		LOG.debug("Creating getCompensationByEmployeeId with id [{}]", id);

		Employee employee = employeeRepository.findByEmployeeId(id);

		if (employee == null) {
			throw new RuntimeException("Invalid employeeId: " + id);
		}
		Compensation compensation=employee.getCompensation();
		
		if (compensation == null) {
			throw new RuntimeException("no compensation for this employee: " + id);
		}
		
		employee.setCompensation(null); //avoid nested pointing
		compensation.setEmployee(employee);
		
		return compensation;
	}
}
