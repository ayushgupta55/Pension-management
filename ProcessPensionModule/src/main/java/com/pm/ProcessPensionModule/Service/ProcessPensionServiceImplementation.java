package com.pm.ProcessPensionModule.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.pm.ProcessPensionModule.Entity.Pensioner;
import com.pm.ProcessPensionModule.Repository.ProcessPensionRepository;

@Service
public class ProcessPensionServiceImplementation implements ProcessPensionService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProcessPensionRepository processPensionRepository;
	
	@Override
	public Pensioner getPensionDetail(Long aadharNumber) {
		String url = "http://Pension-Detail/Pension/PensionerDetailByAadhaar/" + aadharNumber;
		Pensioner pensioner = restTemplate.getForObject(url, Pensioner.class);

		double pensionAmount = 0;
		
		if(pensioner.getPensionType().equalsIgnoreCase("self")){
			pensionAmount = pensioner.getSalaryEarned()*0.8 + pensioner.getAllowance();
		}else{
			pensionAmount = pensioner.getSalaryEarned()*0.5 + pensioner.getAllowance();
		}
		int serviceCharge = 0;
		if(pensioner.getBankAccountType().equalsIgnoreCase("private")){
			serviceCharge = 550;
		}else{
			serviceCharge = 500;
		}
		pensioner.setPensionAmount(pensionAmount);
		pensioner.setServiceCharge(serviceCharge);
		pensioner.setAadharNumber(pensioner.getAadharNumber());
		processPensionRepository.save(pensioner);
		
		return pensioner;
	}
}
