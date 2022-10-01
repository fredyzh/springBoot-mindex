package com.mindex.challenge.data;

import java.util.Date;

import org.springframework.data.annotation.Transient;

/*
 * data obj for employee compensation
 */
public class Compensation {
	@Transient
	private Employee employee;
	private String salary;
	private Date effectiveDate;

	public Compensation() {
	}

	public Compensation(Employee employee, String salary, Date effectiveDate) {
		this.employee = employee;
		this.salary = salary;
		this.effectiveDate = effectiveDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
}
