package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee create(@RequestBody Employee employee) {
		LOG.debug("Received employee create request for [{}]", employee);

		return employeeService.create(employee);
	}

	@GetMapping("/employee/{id}")
	public Employee read(@PathVariable String id) {
		LOG.debug("Received employee create request for id [{}]", id);

		return employeeService.read(id);
	}

	@PutMapping("/employee/{id}")
	public Employee update(@PathVariable String id, @RequestBody Employee employee) {
		LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);

		employee.setEmployeeId(id);
		return employeeService.update(employee);
	}

	/**
	 * report number of employee to be reported
	 * 
	 * @param employee id
	 * @return
	 */
	@GetMapping("/employee/reportEmployeeStructure/{id}")
	public ReportingStructure reportEmployeeStructure(@PathVariable String id) {
		LOG.debug("Received employee reportEmployeeStructure for id [{}]", id);

		return new ReportingStructure(employeeService.read(id));
	}

	/**
	 * create employee compensation
	 * 
	 * @param compensation
	 * @return
	 */
	@PostMapping("/employee/createCompensation")
	public Compensation createCompensation(@RequestBody Compensation compensation) {
		LOG.debug("Received createCompensation create request for [{}]", compensation);

		return employeeService.createCompensation(compensation);
	}

	@GetMapping("/employee/readCompensation/{id}")
	public Compensation readCompensation(@PathVariable String id) {
		LOG.debug("Received createCompensation create request for [{}]", id);

		return employeeService.getCompensationByEmployeeId(id);
	}
}
