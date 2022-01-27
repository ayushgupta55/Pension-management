package com.pm.PensionerDetailModule.service;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;

//import static org.mockito.ArgumentMatchers.any;

//import org.junit.Before;
import org.junit.Test;
//import org.aspectj.lang.annotation.Before;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.pm.PensionerDetailModule.entity.Pensioner;
import com.pm.PensionerDetailModule.repository.PensionerDetailRepository;

import java.io.IOException;

public class PensionerDetailServiceImplementationTest {

	@InjectMocks
	private PensionerDetailServiceImplementation pensionerDetailServiceImplementation;

	@Mock
	private PensionerDetailRepository pensionerDetailRepositoryMock;
	
	@Before
	public void initMocks() {
	       MockitoAnnotations.initMocks(this);
	   }
	
	@Test
	public void test1(){
		Pensioner pensioner = new Pensioner();
		pensioner.setName("Sankalp");
		Mockito.when(pensionerDetailRepositoryMock.findById(any())).thenReturn(java.util.Optional.of(pensioner));
//		Mockito.doReturn(pensioner).when(pensionerDetailRepositoryMock).findById(any());
//		PensionerDetailServiceImplementation impl = new PensionerDetailServiceImplementation();
		Pensioner p = pensionerDetailServiceImplementation.fetchPensioner((long)1);
		assertEquals("Sankalp", p.getName());
	}

	@Test
	public void test2(){
//		Pensioner pensioner = new Pensioner();
//		pensioner.setName("Sankalp");
//		Mockito.when(pensionerDetailRepositoryMock.findById(any())).thenReturn(java.util.Optional.of(pensioner));
//		Mockito.doReturn(pensioner).when(pensionerDetailRepositoryMock).findById(any());
//		PensionerDetailServiceImplementation impl = new PensionerDetailServiceImplementation();

		try {
			pensionerDetailServiceImplementation.savePensionerData();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		assertEquals("Sankalp", p.getName());
	}


}
