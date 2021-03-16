package com.example.data;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.json.JSONArray;

import com.example.restservice.PatientName;

@TypeDefs({
	  @TypeDef(name = "json", typeClass = String.class)
	})
@Entity // This tells Hibernate to make a table out of this class
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String fhirUrl;
  
  private String createdTimeStamp;
  
  @Convert(converter = ArrayListConverter.class)
  @Column(columnDefinition = "JSON") 
  private ArrayList<PatientName> name;
  
  private String prefix;
  
  private String suffix;
  
  private String gender;
  
  private String birthDay;
  
  
  
  public Integer getId() {
	    return id;
  }

  public void setId(Integer id) {
	  	this.id = id;
  }
  
  public String getFhirUrl() {
	    return fhirUrl;
	  }

  public void setFhirUrl(String fhirUrl) {
	  	this.fhirUrl = fhirUrl;
  }
  
  public String getCreatedTimeStamp() {
	    return createdTimeStamp;
  }

  public void setCreatedTimeStamp(String createdTimeStamp) {
	  	this.createdTimeStamp = createdTimeStamp;
  }
  
  public ArrayList<PatientName> getname() {
	    return name;
  }

  public void setname(ArrayList<PatientName> name) {
	  if (name != null){
		  this.name = new ArrayList<PatientName>(name);
	    }
  }

  public String getPrefix() {
	    return prefix;
  }

  public void setPrefix(String prefix) {
	  	this.prefix = prefix;
  }
  
  public String getSuffix() {
	    return suffix;
  }

  public void setSuffix(String suffix) {
	  	this.suffix = suffix;
  }
  
  public String getGender() {
	    return gender;
  }

  public void setGender(String gender) {
	  	this.gender = gender;
  }
  
  public String getBirthDay() {
	    return birthDay;
  }

  public void setBirthDay(String birthDay) {
	  	this.birthDay = birthDay;
  }

}