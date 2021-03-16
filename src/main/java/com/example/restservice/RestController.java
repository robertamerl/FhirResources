package com.example.restservice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.data.User;
import com.example.data.UserRepository;

@Controller
@RequestMapping 
public class RestController {

	  @Autowired // This means to get the bean called userRepository
	  private UserRepository userRepository;
	
	  @Autowired
	  RestTemplate restTemplate;
	
	  @PostMapping(path="/transferFhirPatient")
	  public @ResponseBody String transferFhirPatient (@RequestParam String fhirUrl) {
		  
		User patient = new User();
		//String charset = java.nio.charset.StandardCharsets.UTF_8.name();
		try {
			
			Patient patientRes = restTemplate.getForObject(fhirUrl, Patient.class);
			
			patient.setGender(patientRes.getGender());
			patient.setBirthDay(patientRes.getBirthDate());
			
			patient.setname(patientRes.getName());
			           
            // fhirUrl
            patient.setFhirUrl(fhirUrl);
            
            // created Time stamp
            ZonedDateTime zdt = ZonedDateTime.now(ZoneId.systemDefault());
            patient.setCreatedTimeStamp(zdt.toString());

		} catch (Exception e) { //
			// TODO: handle exception
			System.out.println("ROBERTA -->" + e.getMessage());
		}
		
	    userRepository.save(patient);
	    return "Saved";
	  }
	  
	  @GetMapping(path="/transferedPatient")
	  public @ResponseBody Iterable<User> getTranferedPatient(@RequestParam(value = "fhirUrl") String fhirUrl) {
	    
		return userRepository.findPatientByFhirUrl(fhirUrl);
	  }
	  
}
