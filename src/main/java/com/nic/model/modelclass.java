package com.nic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="demo")
public class modelclass {
	public  modelclass() {}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
public modelclass(int id, String firstname, String lastname, int age) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Column
private String firstname;
@Column
private String lastname;
@Column 
private int age;
}
