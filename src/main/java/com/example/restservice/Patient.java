package com.example.restservice;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {
	
	private ArrayList<PatientName> name;
	private String gender;
	private String birthDate;
	
	public Patient() {
		
	}

	public ArrayList<PatientName> getName() {
		return name;
	}

	public void setName(ArrayList<PatientName> name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	  public String toString() {
	    return "Patient{" +
	        "name=" + name.toString() +
	        ", gender='" + gender +
	        ", birthDate='" + birthDate + '\'' +
	        '}';
	  }
}
