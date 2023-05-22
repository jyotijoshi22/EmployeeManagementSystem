package io.project.EmployeeManagement.System;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeeDTO {
	private String firstName;
	private String middleName;
	private String lastName;

	private String emailId;
	private String contactNumber;
	private String address;

	private String contractType;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private String startDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private String finishDate;


	private String onGoing;


	private String workTimeType;


	private String hoursPerWeek;
	
	
	public EmployeeDTO(String onGoing) {
		super();
		this.onGoing = onGoing;
	}


	public EmployeeDTO(String firstName, String middleName, String lastName, String emailId,
			String contactNumber, String address, String contractType, String startDate, String finishDate,
			String onGoing, String workTimeType, String hoursPerWeek) {
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





	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
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


}
