package com.mindex.challenge.entity;

import java.util.Date;

public class CompensationEntity {
	private String employeeId;
	private String salary;
	private Date effectiveDate;

	public CompensationEntity() {
	}

	public CompensationEntity(String employeeId, String salary, Date effectiveDate) {
		this.employeeId = employeeId;
		this.salary = salary;
		this.effectiveDate = effectiveDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
