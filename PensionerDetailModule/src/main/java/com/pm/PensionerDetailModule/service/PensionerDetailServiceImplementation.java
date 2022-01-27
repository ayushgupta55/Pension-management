package com.pm.PensionerDetailModule.service;

import java.io.*;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.PensionerDetailModule.entity.Pensioner;
import com.pm.PensionerDetailModule.repository.PensionerDetailRepository;

@Service
public class PensionerDetailServiceImplementation implements PensionerDetailService{

	@Autowired
	private PensionerDetailRepository pensionerDetailRepository;
	
	HashMap<Long,Pensioner> hm = new HashMap<>();
	
	String line = "";
//	private BufferedReader br;
	InputStream is;
	public void savePensionerData() throws NumberFormatException, IOException{
		
//		try {
			PensionerDetailServiceImplementation instance = new PensionerDetailServiceImplementation();
			InputStream is = instance.getFileAsIOStream("PensionerDetails.csv");
//			br = new BufferedReader(new FileReader("src/main/resources/PensionerDetails.csv"));

			try (InputStreamReader isr = new InputStreamReader(is);
				 BufferedReader br = new BufferedReader(isr);){
			while((line=br.readLine())!=null){
				String[] data = line.split(",");
				Pensioner p = new Pensioner();
				p.setAadharNumber(Long.parseLong(data[0]));
				p.setName(data[1]);
				p.setDateOfBirth(data[2]);
				p.setPan(Integer.parseInt(data[3]));
				p.setSalaryEarned(Integer.parseInt(data[4]));
				p.setAllowance(Double.parseDouble(data[5]));
				p.setPensionType(data[6]);
				p.setBankName(data[7]);
				p.setAccountNumber(data[8]);
				p.setBankAccountType(data[9]);
//				pensionerDetailRepository.save(p);
				hm.put(p.getAadharNumber(), p);
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private InputStream getFileAsIOStream(final String fileName)
	{
		InputStream ioStream = this.getClass()
				.getClassLoader()
				.getResourceAsStream(fileName);

		if (ioStream == null) {
			throw new IllegalArgumentException(fileName + " is not found");
		}
		return ioStream;
	}

	@Override
	public Pensioner fetchPensioner(Long aadharNumber) {
		// TODO Auto-generated method stub
		return hm.get(aadharNumber);
//		return pensionerDetailRepository.findById(aadharNumber).get();
	}


}
