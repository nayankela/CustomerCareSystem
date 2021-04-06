package com.customercare;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.customercare.entity.Complaint;
import com.customercare.entity.Customer;
import com.customercare.entity.Person;
import com.customercare.interfaces.CustomerInterface;
import com.customercare.interfaces.CustomerInterfaceImpl;

public class UserOperations {

	public static void main(String[] args) {

		while (true) {

			System.out.println("1. View all customers by name with keyId.");
			System.out.println("2. Select a customer using keyId to view all complaints launched by customerId");
			System.out.println("3. Select a complaint to view its status ");
			System.out.println("4. Launch a new complaint ");
			System.out.println("5. Quit.");

			CustomerInterface customerInterface = new CustomerInterfaceImpl();
			Complaint complaint;
			System.out.println("Enter your choice to perform any operation: ");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				List<Person> viewAllCustomer = customerInterface.viewAllCustomer();
				System.out.println("Id" + "\t" + "Name");
				for (Person person : viewAllCustomer) {
					System.out.println(person.getId() + "\t" + person.getName());
				}
				break;
			case 2:
				System.out.println("Enter customerId to view all complaints launched by customerId : ");
				int customerId = scanner.nextInt();
				complaint = customerInterface.getComplaint(customerId);
				System.out.println("Id" + "\t\t\t" + "Title" + "\t\t\t" + "Discription" + "\t\t\t" + "Status" + "\t\t\t"
						+ "CustomerId");
				System.out
						.println(complaint.getId() + "\t\t" + complaint.getTitle() + "\t\t" + complaint.getDescription()
								+ "\t\t" + complaint.getStatus() + "\t\t" + complaint.getCustomerId());
				break;
			case 3:
				System.out.println("Enter a complaintId to view its status : ");
				int complaintId = scanner.nextInt();
				complaint = customerInterface.getComplaintStatus(complaintId);
				System.out.println("Id" + "\t\t\t" + "Title" + "\t\t\t" + "Discription" + "\t\t\t" + "Status" + "\t\t\t"
						+ "CustomerId");
				System.out
						.println(complaint.getId() + "\t\t" + complaint.getTitle() + "\t\t" + complaint.getDescription()
								+ "\t\t" + complaint.getStatus() + "\t\t" + complaint.getCustomerId());
				break;
			case 4:

				System.out.println("Enter title of complaint: ");
				String title = scanner.next();
				System.out.println("Enter description of complaint: ");
				String description = scanner.next();
				System.out.println("Enter status of complaint: ");
				String status = scanner.next();
				System.out.println("Enter customerId of complaint: ");
				int customerIdForComplaint = scanner.nextInt();
				Random random = new Random();
				int complaintIdTwo = random.nextInt();

				complaint = new Complaint(complaintIdTwo, title, description, status, customerIdForComplaint);
				customerInterface.launchComplaint(complaint);
				break;
			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Please opt correct option.");
				break;
			}
		}

	}
}
