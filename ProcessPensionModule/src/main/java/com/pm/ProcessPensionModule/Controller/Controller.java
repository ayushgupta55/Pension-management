package com.pm.ProcessPensionModule.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pm.ProcessPensionModule.Entity.Pensioner;
import com.pm.ProcessPensionModule.Service.ProcessPensionService;

@RestController
@RequestMapping("/Process")
public class Controller {
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Autowired
	private ProcessPensionService processPensionService;
	
	@PostMapping("/ProcessPension/{id}")
	public ResponseEntity<Pensioner> pensionAmount(@PathVariable("id") Long AadharNumber){
		
		try{
			return new ResponseEntity<>(processPensionService.getPensionDetail(AadharNumber),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
