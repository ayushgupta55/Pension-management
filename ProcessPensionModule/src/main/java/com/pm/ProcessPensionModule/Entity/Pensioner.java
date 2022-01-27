package com.pm.ProcessPensionModule.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pensioner {
	@Id
	private long aadharNumber;
	private String name;
	private String dateOfBirth;
	private int pan;
	private int salaryEarned;
	private Double allowance;
	private String pensionType;
	private String bankName;
	private String accountNumber;
	private String bankAccountType;
	private Double pensionAmount;
	private int serviceCharge;
	
	public Double getPensionAmount() {
		return pensionAmount;
	}
	public void setPensionAmount(Double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}
	public int getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	
	
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getPan() {
		return pan;
	}
	public void setPan(int pan) {
		this.pan = pan;
	}
	public int getSalaryEarned() {
		return salaryEarned;
	}
	public void setSalaryEarned(int salaryEarned) {
		this.salaryEarned = salaryEarned;
	}
	public Double getAllowance() {
		return allowance;
	}
	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}
	public String getPensionType() {
		return pensionType;
	}
	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}
//	public double getSelfPension() {
//		return selfPension;
//	}
//	public void setSelfPension(double selfPension) {
//		this.selfPension = selfPension;
//	}
//	public double getFamilyPension() {
//		return familyPension;
//	}
//	public void setFamilyPension(double familyPension) {
//		this.familyPension = familyPension;
//	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
//	public String getPublicOrPrivate() {
//		return publicOrPrivate;
//	}
//	public void setPublicOrPrivate(String publicOrPrivate) {
//		this.publicOrPrivate = publicOrPrivate;
//	}
	public String getBankAccountType() {
		return bankAccountType;
	}
	public void setBankAccountType(String bankAccountType) {
		this.bankAccountType = bankAccountType;
	}
//	private String publicOrPrivate;
}
