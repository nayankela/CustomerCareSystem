package com.customercare.entity;

public class Complaint {

	private int id;
	private String title;
	private String description;
	private String status;
	private int customerId;

	public Complaint() {
		super();
	}

	public Complaint(int id, String title, String description, String status, int customerId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Complaint [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", customerId=" + customerId + "]";
	}

}
