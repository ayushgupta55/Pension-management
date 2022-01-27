package com.pm.PensionerDetailModule.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pm.PensionerDetailModule.entity.Pensioner;
import com.pm.PensionerDetailModule.repository.PensionerDetailRepository;
import com.pm.PensionerDetailModule.service.PensionerDetailServiceImplementation;

@SpringBootTest
public class PensionControllerTest {

//	@Autowired
//	private MockMvc mockMvc;
	
	@Resource
	private PensionerDetailRepository pensionerDetailRepositoryMock;

	@InjectMocks
	private PensionController pensionControllerMock;

	@Mock
	private PensionerDetailServiceImplementation pensionerDetailServiceImplementationMock;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test5() throws Exception{
		Pensioner pensioner = new Pensioner();
		pensioner.setAadharNumber(10l);
//		PensionerDetailServiceImplementation pensionerDetailServiceImplementation = Mockito.mock(PensionerDetailServiceImplementation.class);

		Mockito.when(pensionerDetailServiceImplementationMock.fetchPensioner(10l)).thenReturn(pensioner);
		assertNotNull(pensionControllerMock.fetchPensioner(10l));
		
//		assertEquals(10l, pensionControllerMock.fetchPensioner(10l));
//		assertNotNull(pensionControllerTest.fetchPensioner(10l));

	}
	
	@Test
	public void test6() throws Exception{
		Pensioner pensioner = new Pensioner();
		pensioner.setAadharNumber(11l);
//		PensionerDetailServiceImplementation pensionerDetailServiceImplementation = Mockito.mock(PensionerDetailServiceImplementation.class);

		Mockito.when(pensionerDetailServiceImplementationMock.fetchPensioner(11l)).thenReturn(pensioner);
//		(pensionControllerMock.fetchPensioner(10l));
		
		
		assertEquals(null, pensionControllerMock.fetchPensioner(101l));
//		assertNotNull(pensionControllerTest.fetchPensioner(10l));

	}
	




}
