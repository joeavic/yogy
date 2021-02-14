package com.yogy.user.entity;


import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private Long creationTime;
	private Double lat;
	private Double lon;
	private Long s2CellId;
	private Long level20S2CellId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getLevel20S2CellId() {
		return level20S2CellId;
	}

	public void setLevel20S2CellId(Long level20S2CellId) {
		this.level20S2CellId = level20S2CellId;
	}

	public Long getS2CellId() {
		return s2CellId;
	}

	public void setS2CellId(Long s2CellId) {
		this.s2CellId = s2CellId;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public User(String firstName, String lastName, String contactNumber){
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
