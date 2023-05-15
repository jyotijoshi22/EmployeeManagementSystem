package io.project.EmployeeManagementSystem;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeeDTO {
	private String firstName;
	private String middleName;
	private String lastName;

	private String emailId;
	private Integer contactNumber;
	private String address;

	private String contractType;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Integer startDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Integer finishDate;


	private boolean onGoing;


	private String workTimeType;


	private float hoursPerWeek;
	
	
	public EmployeeDTO(boolean onGoing) {
		super();
		this.onGoing = onGoing;
	}


	public EmployeeDTO(String firstName, String middleName, String lastName, String emailId,
			Integer contactNumber, String address, String contractType, Integer startDate, Integer finishDate,
			boolean onGoing, String workTimeType, float hoursPerWeek) {
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

	public Integer getStartDate() {
		return startDate;
	}

	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}

	public Integer getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Integer finishDate) {
		this.finishDate = finishDate;
	}

	public boolean isOnGoing() {
		return onGoing;
	}

	public void setOnGoing(boolean onGoing) {
		this.onGoing = onGoing;
	}

	public String getWorkTimeType() {
		return workTimeType;
	}


	public void setWorkTimeType(String workTimeType) {
		this.workTimeType = workTimeType;
	}





	public float getHoursPerWeek() {
		return hoursPerWeek;
	}





	public void setHoursPerWeek(float hoursPerWeek) {
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


	public Integer getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


}
