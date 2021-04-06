package com.customercare.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.customercare.Utility;
import com.customercare.entity.Complaint;
import com.customercare.entity.Customer;
import com.customercare.entity.Person;

public class CustomerInterfaceImpl implements CustomerInterface {

	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;

	@Override
	public void launchComplaint(Complaint complaint) {
		try {
			connection = Utility.getConnection();
			preparedStatement = connection.prepareStatement("insert into Complaint values(?,?,?,?,?)");
			preparedStatement.setInt(1, complaint.getId());
			preparedStatement.setString(2, complaint.getTitle());
			preparedStatement.setString(3, complaint.getDescription());
			preparedStatement.setString(4, complaint.getStatus());
			preparedStatement.setInt(5, complaint.getCustomerId());
			int executeUpdate = preparedStatement.executeUpdate();
			if (executeUpdate == 1)
				System.out.println("Complaint Registered");
			else
				System.out.println("Complaint Not Registered");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Person> viewAllCustomer() {
		List<Person> persons = new ArrayList<Person>();

		try {
			connection = Utility.getConnection();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from Customer");

			while (resultSet.next()) {
				int customerId = resultSet.getInt(1);
				String customerName = resultSet.getString(2);
				Person person = new Customer(customerId, customerName);
				persons.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
	}

	@Override
	public Complaint getComplaint(int customerId) {
		Complaint complaint = new Complaint();
		try {
			connection = Utility.getConnection();
			preparedStatement = connection.prepareStatement("Select * from Complaint where customerId=?");
			preparedStatement.setInt(1, customerId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				complaint.setId(resultSet.getInt(1));
				complaint.setTitle(resultSet.getString(2));
				complaint.setDescription(resultSet.getString(3));
				complaint.setStatus(resultSet.getString(4));
				complaint.setCustomerId(resultSet.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return complaint;
	}

	@Override
	public Complaint getComplaintStatus(int complaintId) {
		Complaint complaint = new Complaint();
		try {
			connection = Utility.getConnection();
			preparedStatement = connection.prepareStatement("Select * from Complaint where id=?");
			preparedStatement.setInt(1, complaintId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				complaint.setId(resultSet.getInt(1));
				complaint.setTitle(resultSet.getString(2));
				complaint.setDescription(resultSet.getString(3));
				complaint.setStatus(resultSet.getString(4));
				complaint.setCustomerId(resultSet.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return complaint;
	}

}
