package com.customercare.interfaces;

import java.util.List;

import com.customercare.entity.*;

public interface CustomerInterface {

	void launchComplaint(Complaint complaint);

	Complaint getComplaint(int customerId);

	Complaint getComplaintStatus(int complaintId);

	List<Person> viewAllCustomer();
}
