package com.pm.PensionerDetailModule.controller;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.PensionerDetailModule.entity.Pensioner;
import com.pm.PensionerDetailModule.service.PensionerDetailServiceImplementation;

@RestController
@RequestMapping("/Pension")
public class PensionController {
	
	@Autowired
	private PensionerDetailServiceImplementation pensionerDetailServiceImplementation;
	
	@GetMapping("/PensionerDetailByAadhaar/{id}")
	public ResponseEntity<Pensioner> fetchPensioner(@PathVariable("id") Long aadharNumber){
		try{
//			System.out.println(aadharNumber);
			return new ResponseEntity<>(pensionerDetailServiceImplementation.fetchPensioner(aadharNumber),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	
	@PostConstruct
	public void setDatainDB(){
		
		try {
			pensionerDetailServiceImplementation.savePensionerData();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
