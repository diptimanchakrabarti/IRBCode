package com.codejava.domain;

import org.springframework.stereotype.Service;

@Service
public class Patient {

	private String patientid;
	private String dob;
	private String patname;
	private String gendercd;
	private String citynm;
	private String statenm;
	private String isdiabetic;
	private String issmoker;
	private String ishyper;
	private String diagcode;
	private String diagcodedesc;
	private String salaryrange;
	private String ishmo;
	private String isppo;
	private String addinsurance;
	private String dschrgdctr;
	private String dschrghstf;
	private String dschrgrnp;
	private String dschrgtohmcr;
	private String dschrgtonrscr;
	private String temp;
	private String admsndate;
	
	public Patient(){
		
	}
	
	public Patient( String patientid, String dob, String patname, String gendercd, String citynm, String statenm, String isdiabetic, String issmoker, String ishyper, String diagcode, String diagcodedesc, String salaryrange, String ishmo, String isppo, String addinsurance, String dschrgdctr, String dschrghstf, String dschrgrnp, String dschrgtohmcr, String dschrgtonrscr, String temp,String admsndate){
		this.addinsurance=addinsurance;
		this.citynm=citynm;
		this.diagcode=diagcode;
		this.diagcodedesc=diagcodedesc;
		this.dob=dob;
		this.dschrgdctr=dschrgdctr;
		this.dschrghstf=dschrghstf;
		this.dschrgrnp=dschrgrnp;
		this.dschrgtohmcr=dschrgtohmcr;
		this.dschrgtonrscr=dschrgtonrscr;
		this.gendercd=gendercd;
		this.isdiabetic=isdiabetic;
		this.ishmo=ishmo;
		this.ishyper=ishyper;
		this.isppo=isppo;
		this.issmoker=issmoker;
		this.patientid=patientid;
		this.patname=patname;
		this.salaryrange=salaryrange;
		this.statenm=statenm;
		this.temp=temp;
		this.admsndate=admsndate;
	}
	
	public String getPatientid(){
		return this.patientid;
	}
	public void setPatientid(String patientid){
		this.patientid=patientid;
	}
	public String getDoB(){
		return this.dob;
	}
	public void setDOB(String dob){
		this.dob=dob;
	}
	public String getPatname(){
		return this.patname;
	}
	public void setPatname(String patname){
		this.patname=patname;
	}
	public String getGendercd(){
		return this.gendercd;
	}
	public void setGendercd(String gendercd){
		this.gendercd=gendercd;
	}
	public String getCitynm(){
		return this.citynm;
	}
	public void setCitynm(String citynm){
		this.citynm=citynm;
	}
	public String getStatenm(){
		return this.statenm;
	}
	public void setStatenm(String statenm){
		this.statenm=statenm;
	}
	
	public String getIsdiabetic(){
		return this.isdiabetic;
	}
	public void setIsdiabetic(String isdiabetic){
		this.isdiabetic=isdiabetic;
	}
	public String getIssmoker(){
		return this.issmoker;
	}
	public void setIssmoker(String issmoker){
		this.issmoker=issmoker;
	}
	public String getIshyper(){
		return this.ishyper;
	}
	public void setIshyper(String ishyper){
		this.ishyper=ishyper;
	}
	public String getDiagcode(){
		return this.diagcode;
	}
	public void setDiagcode(String diagcode){
		this.diagcode=diagcode;
	}
	public String getDiagcodedesc(){
		return this.diagcodedesc;
	}
	public void setDiagcodedesc(String diagcodedesc){
		this.diagcodedesc=diagcodedesc;
	}
	public String getSalaryrange(){
		return this.salaryrange;
	}
	public void setSalaryrange(String salaryrange){
		this.salaryrange=salaryrange;
	}
	public String getIshmo(){
		return this.ishmo;
	}
	public void setIshmo(String ishmo){
		this.ishmo=ishmo;
	}
	public String getIsppo(){
		return this.isppo;
	}
	public void setIsppo(String isppo){
		this.isppo=isppo;
	}
	public String getAddinsurance(){
		return this.addinsurance;
	}
	public void setAddinsurance(String addinsurance){
		this.addinsurance=addinsurance;
	}
	public String getDschrgdctr(){
		return this.dschrgdctr;
	}
	public void setDschrgdctr(String dschrgdctr){
		this.dschrgdctr=dschrgdctr;
	}
	public String getDschrghstf(){
		return this.dschrghstf;
	}
	public void setDschrghstf(String dschrghstf){
		this.dschrghstf=dschrghstf;
	}
	public String getDschrgrnp(){
		return this.dschrgrnp;
	}
	public void setDschrgrnp(String dschrgrnp){
		this.dschrgrnp=dschrgrnp;
	}
	public String getDschrgtohmcr(){
		return this.dschrgtohmcr;
	}
	public void setDschrgtohmcr(String dschrgtohmcr){
		this.dschrgtohmcr=dschrgtohmcr;
	}
	public String getDschrgtonrscr(){
		return this.dschrgtonrscr;
	}
	public void setDschrgtonrscr(String dschrgtonrscr){
		this.dschrgtonrscr=dschrgtonrscr;
	}
	public String getTemp(){
		return this.temp;
	}
	public void setTemp(String temp){
		this.temp=temp;
	}
	
	public String getAdmsndate(){
		return this.admsndate;
	}
	public void setAdmsndate(String admsndate){
		this.admsndate=admsndate;
	}
	
	
}
