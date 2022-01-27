package com.pm.PensionerDetailModule.entity;

import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.Assert;

public class PensionerTest {

	@Test
	public void testSetter(){
		Pensioner pensioner= new Pensioner();
		pensioner.setName("ayush");
		pensioner.setAadharNumber(10l);
		pensioner.setAccountNumber("100");
		pensioner.setAllowance(50.00);
		pensioner.setBankAccountType("private");
		pensioner.setBankName("SBI");
		pensioner.setDateOfBirth("01012022");
		pensioner.setPan(12341234);
		pensioner.setPensionType("self");
		pensioner.setSalaryEarned(1000);
		
		
		Assert.assertEquals("ayush", pensioner.getName());
		Assert.assertEquals(10l, pensioner.getAadharNumber());
		Assert.assertEquals("100", pensioner.getAccountNumber());
		Assert.assertEquals(50.00, pensioner.getAllowance());
		Assert.assertEquals("private", pensioner.getBankAccountType());
		Assert.assertEquals("SBI", pensioner.getBankName());
		Assert.assertEquals("01012022", pensioner.getDateOfBirth());
		Assert.assertEquals(12341234, pensioner.getPan());
		Assert.assertEquals("self", pensioner.getPensionType());
		Assert.assertEquals(1000, pensioner.getSalaryEarned());

	}
	
	@Test
	public void testGetter(){
		Pensioner pensioner = new Pensioner();
//		Pensioner pensioner= new Pensioner();
		pensioner.setName("ayush");
		pensioner.setAadharNumber(10l);
		pensioner.setAccountNumber("100");
		pensioner.setAllowance(50.00);
		pensioner.setBankAccountType("private");
		pensioner.setBankName("SBI");
		pensioner.setDateOfBirth("01012022");
		pensioner.setPan(12341234);
		pensioner.setPensionType("self");
		pensioner.setSalaryEarned(1000);
		
		
		Assert.assertEquals("ayush", pensioner.getName());
		Assert.assertEquals(10l, pensioner.getAadharNumber());
		Assert.assertEquals("100", pensioner.getAccountNumber());
		Assert.assertEquals(50.00, pensioner.getAllowance());
		Assert.assertEquals("private", pensioner.getBankAccountType());
		Assert.assertEquals("SBI", pensioner.getBankName());
		Assert.assertEquals("01012022", pensioner.getDateOfBirth());
		Assert.assertEquals(12341234, pensioner.getPan());
		Assert.assertEquals("self", pensioner.getPensionType());
		Assert.assertEquals(1000, pensioner.getSalaryEarned());
	}
}
