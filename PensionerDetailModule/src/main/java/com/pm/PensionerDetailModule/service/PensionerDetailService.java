package com.pm.PensionerDetailModule.service;

import java.io.IOException;

import com.pm.PensionerDetailModule.entity.Pensioner;

public interface PensionerDetailService {

	public void savePensionerData() throws NumberFormatException, IOException;
	public Pensioner fetchPensioner(Long aadharNumber);
}
