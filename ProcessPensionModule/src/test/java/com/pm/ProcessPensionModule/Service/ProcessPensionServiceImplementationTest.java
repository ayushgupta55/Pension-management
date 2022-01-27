package com.pm.ProcessPensionModule.Service;

import java.net.URI;
import java.net.URISyntaxException;

//import org.junit.Before;
//import org.junit.Test;
import com.pm.ProcessPensionModule.Repository.ProcessPensionRepository;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.pm.ProcessPensionModule.Entity.Pensioner;
import static org.mockito.ArgumentMatchers.any;

//import junit.framework.Assert;

@SpringBootTest
public class ProcessPensionServiceImplementationTest {
	
	@InjectMocks
	private ProcessPensionServiceImplementation processPensionServiceImplementation;
	
	@Mock
	private RestTemplate restTemplate;

	@Mock
	private ProcessPensionRepository processRepository;
	
	@Before
	public void initMocks() {
	       MockitoAnnotations.initMocks(this);
	   }
	@Test
	public void test() throws URISyntaxException{
		final String baseURL = "http://localhost:8080/Pension/PensionerDetailByAadhaar/10";
		URI uri = new URI(baseURL);

		Pensioner pensioner = new Pensioner();
		pensioner.setAadharNumber(10l);
		pensioner.setName("Sankalp");
		pensioner.setAllowance(5000D);
		pensioner.setSalaryEarned(50000);
		pensioner.setPensionType("self");
		pensioner.setBankAccountType("Private");

		Mockito.when(restTemplate.getForObject(baseURL,Pensioner.class)).thenReturn(pensioner);

		Mockito.when(processRepository.save(any())).thenReturn(pensioner);


//		ResponseEntity<Pensioner> responseEntity = this.restTemplate.getForEntity(uri,Pensioner.class);

//		Assert.assertEquals(200, responseEntity.getStatusCodeValue());

//		Mockito.when().thenReturn(pensioner);
//
//		processPensionServiceImplementation.getPensionDetail(10l)

		Pensioner p = processPensionServiceImplementation.getPensionDetail(10l);

		
		double pensionAmount = 0;
		
		if(pensioner.getPensionType().equalsIgnoreCase("self")){
			pensionAmount = 50000*0.8 + 5000;
		}else{
			pensionAmount = 50000*0.5 + 5000;
		}
		int serviceCharge = 550;
//		if(pensioner.getBankAccountType().equalsIgnoreCase("private")){
//			serviceCharge = 550;
//		}else{
//			serviceCharge = 500;
//		}	
		System.out.println(p.getSalaryEarned());
		System.out.println(p.getPensionAmount());
		
		Assert.assertEquals(pensionAmount, p.getPensionAmount());
		
		Assert.assertEquals(serviceCharge, p.getServiceCharge());
		
		

	}

}