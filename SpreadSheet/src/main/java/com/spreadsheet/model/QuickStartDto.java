package com.spreadsheet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="demo")
public class QuickStartDto
{
	@Id
	@GenericGenerator(name="gene" ,strategy= "increment")
	@GeneratedValue( generator="gene")
	private int id;
	@Column(name="first_name")
	private String Name;
	@Column(name="Last_name")
	private String Lname;
	@Column(name="usn")
	private String USN;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getUSN() {
		return USN;
	}
	public void setUSN(String uSN) {
		USN = uSN;
	}
	
	
}
