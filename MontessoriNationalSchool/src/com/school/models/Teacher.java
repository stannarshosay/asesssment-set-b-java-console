package com.school.models;

public abstract class Teacher {

	protected int id;
	protected String name;
	protected String address;
	protected long phoneNumber;
	protected int extraHours;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getExtraHours() {
		return extraHours;
	}

	public void setExtraHours(int extraHours) {
		this.extraHours = extraHours;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
		
	public abstract String display();

	@Override
	public String toString() {
		
		return "\n"+this.id+" | "+this.name
				+"\n------------------------"
				+"\nAddress : "+this.address
				+"\nPhone : "+this.phoneNumber
				+"\nExtra Hours : "+this.extraHours;
	}
	
	

}
