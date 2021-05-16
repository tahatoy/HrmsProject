package com.example.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="system_users")

public class SystemUser {

	@Id
	@GeneratedValue
	@Column(name="systemUserId")
	private int systemUserId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	public SystemUser() {}

	public SystemUser(int systemUserId, String firstName, String lastName) {
		super();
		this.systemUserId = systemUserId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getSystemUserId() {
		return systemUserId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setSystemUserId(int systemUserId) {
		this.systemUserId = systemUserId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
