package com.example.data;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.AttributeConverter;

import com.example.restservice.PatientName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArrayListConverter implements AttributeConverter<ArrayList<PatientName>, String> {

	@Override
    public String convertToDatabaseColumn(ArrayList<PatientName> patientName) {
        String stringPatientName = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        	stringPatientName = objectMapper.writeValueAsString(patientName);
        } catch (final JsonProcessingException e) {
        	System.out.println("convertToDatabaseColumn JSON writing error: " + e.getMessage());
        }
        	
        return stringPatientName;
    }

    @Override
    public ArrayList<PatientName> convertToEntityAttribute(String stringPatientName) {
    	ObjectMapper objectMapper = new ObjectMapper();
    	ArrayList<PatientName> patientName = null;
        try {
        	patientName = objectMapper.readValue(stringPatientName, ArrayList.class);
        	
        } catch (final IOException e) {
        	System.out.println("convertToEntityAttribute JSON reading error: " + e.getMessage());
        }

        return patientName;
    }
}
