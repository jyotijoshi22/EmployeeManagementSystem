package io.project.EmployeeManagementSystem;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private Integer contactNumber;
	
	@Column
	private String address;
	
	@Column
	private String contractType;

	@Column
	private Integer startDate;

	@Column
	private Integer finishDate;

	@Column
	private String workTimeType;

	@Column
	private float hoursPerWeek;
	
	@Column
	private boolean onGoing;
	
	//default constructor
	public Employee() {
		
	}
	
	//constructor
	
	public Employee(String firstName, String middleName, String lastName, String emailId,
			Integer contactNumber, String address, String contractType, Integer startDate, Integer finishDate,
			String workTimeType, float hoursPerWeek, boolean onGoing) {
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
	
}


