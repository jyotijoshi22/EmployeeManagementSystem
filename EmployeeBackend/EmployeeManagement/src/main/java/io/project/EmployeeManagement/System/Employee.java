package io.project.EmployeeManagement.System;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employeeId;

	@Column
	private String firstName;
	
	@Column 
	private String middleName;
	
	@Column
	private String lastName;
	
	@Column
	private String emailId;

	@Column
	private String contactNumber;
	
	@Column
	private String address;
	
	@Column
	private String contractType;

	@Column
	private String startDate;

	@Column
	private String finishDate;

	@Column
	private String workTimeType;

	@Column
	private String hoursPerWeek;
	
	@Column
	private String onGoing;
	
	//default constructor
	public Employee() {
		
	}
	
	//constructor
	
	public Employee(String firstName, String middleName, String lastName, String emailId,
			String contactNumber, String address, String contractType, String startDate, String finishDate,
			String workTimeType, String hoursPerWeek, String onGoing) {
		super();
	
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.address = address;
		this.contractType = contractType;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.workTimeType = workTimeType;
		this.hoursPerWeek = hoursPerWeek;
		this.onGoing = onGoing;
	}

	
	//getter and setter
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}


	public String isOnGoing() {
		return onGoing;
	}

	public void setOnGoing(String onGoing) {
		this.onGoing = onGoing;
	}

	public String getWorkTimeType() {
		return workTimeType;
	}

	public void setWorkTimeType(String workTimeType) {
		this.workTimeType = workTimeType;
	}

	public String getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHoursPerWeek(String hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	
}


