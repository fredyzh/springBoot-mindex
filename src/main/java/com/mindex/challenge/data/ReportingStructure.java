package com.mindex.challenge.data;

import java.util.List;
import java.util.Optional;

/**
 * report the amount of a specified employee to be reported
 * 
 * @author fredy
 */
public class ReportingStructure {
	private Employee employee;
	private long numberOfReports;

	/**
	 * only constructor to populate report number
	 * 
	 * @param employee
	 */
	public ReportingStructure(Employee employee) {
		this.employee = employee;
		Optional<List<Employee>> opt = Optional.ofNullable(employee.getDirectReports());
		setNumberOfReports(opt.isEmpty() ? 0 : opt.get().size());
	}

	public Employee getEmployee() {
		return employee;
	}

	private void setNumberOfReports(long numberOfReports) {
		this.numberOfReports = numberOfReports;
	}

	public long getNumberOfReports() {
		return numberOfReports;
	}
}
