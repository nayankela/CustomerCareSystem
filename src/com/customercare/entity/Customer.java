package com.customercare.entity;

import java.util.List;

public class Customer extends Person {

	private List<Complaint> complaints;

	public Customer() {
		super();
	}

	public Customer(int id, String name) {
		super(id, name);
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	@Override
	public String toString() {
		return "Customer [complaints=" + complaints + super.toString() + "]";
	}

}
