package com.example.restservice;

import java.io.Serializable;
import java.util.ArrayList;

public class PatientName implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4860385899186831855L;
	private String family;
	private ArrayList<String> given;
	
	public PatientName() {
		
	}
	
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public ArrayList<String> getGiven() {
		return given;
	}
	public void setGiven(ArrayList<String> given) {
		this.given = given;
	}
	
	@Override
	  public String toString() {
	    return "PatientName{" +
	        "family=" + family +
	        ", given='" + given.toString() + '\'' +
	        '}';
	  }
}
