package com.codejava.controller;


import com.codejava.constants.IRBConstants;
import com.codejava.dao.ProcessDataDAOImpl;
import com.codejava.util.DBConUtil;
import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.util.GsonSingleton;
import com.google.gson.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.codejava.domain.CalculateScore;
import com.codejava.domain.ModelData;
import com.codejava.domain.Patient;
import com.codejava.domain.ProviderInfo;
import com.codejava.domain.User;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class PatientTreatmentController{
	
	
	
	
	public JdbcTemplate jdbcTemplate;
	DataSource dataSource;
	public PatientTreatmentController() throws SQLException{
	
    
	}
	
	
	@RequestMapping(value = "/patient",method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        Patient patientrequestForm = new Patient();    
        model.put("patientrequestForm", patientrequestForm);
         
        List<String> patientList = new ArrayList<>();
        patientList.add("123456789");
        patientList.add("234567867");
        patientList.add("987654323");
        model.put("patientList", patientList);
         
        return "Patient";
    }
     
    @RequestMapping(value = "/searchpatient", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("patientrequestForm") Patient patient,
            Map<String, Object> model) throws SQLException {
           //ProviderInfo provider = new ProviderInfo();
           Patient patientInput = new Patient();
           Patient patientoutputForm = new Patient();
           DBConUtil dbConUtil = new DBConUtil();  
           dataSource = dbConUtil.getdataSource();
           ProcessDataDAOImpl processData = new ProcessDataDAOImpl(dataSource);
           System.out.println("Entered into Next processing");
         if (null !=patient.getPatientid() && !patient.getPatientid().isEmpty()){
        	 
        	 String patientId=patient.getPatientid();
        	 patientInput=processData.getPatient(patientId);
        	 String patname= patientInput.getPatname();
        	 String patientid=patientId;
        	 String dob=patientInput.getDoB();
        	 String gendercd=patientInput.getGendercd();
        	 String citynm=patientInput.getCitynm();
        	 String statenm=patientInput.getStatenm();
        	 String isdiabetic=patientInput.getIsdiabetic();
        	 String issmoker=patientInput.getIssmoker();
        	 String ishyper=patientInput.getIshyper();
        	 String diagcode=patientInput.getDiagcode();
        	 String diagcodedesc=patientInput.getDiagcodedesc();
        	 String salaryrange=patientInput.getSalaryrange();
        	 String	 temp=patientInput.getTemp();
        	 String	 admsndate=patientInput.getAdmsndate();

        	 model.put("patientoutputForm", patientInput);
        	 model.put("patientid", patientid);
        	 model.put("patname", patname);
        	 model.put("dob", dob);
        	 model.put("gendercd", gendercd);
        	 model.put("citynm", citynm);
        	 model.put("statenm", statenm);
        	 model.put("isdiabetic", isdiabetic);
        	 model.put("issmoker", issmoker);
        	 model.put("ishyper", ishyper);
        	 model.put("diagcode", diagcode);
        	 model.put("diagcodedesc", diagcodedesc);
        	 model.put("salaryrange", salaryrange);
        	 model.put("temp", temp);
        	 model.put("admsndate", admsndate);
        	 
         }
                 
        return "ScorePatient";
    }
    
    
    @RequestMapping(value = "/scorepatient", method = RequestMethod.POST)
    public String ScoreRegistration(@ModelAttribute("patientoutputForm") Patient patient,
            Map<String, Object> model) throws SQLException {
           //ProviderInfo provider = new ProviderInfo();
           Patient patientInput = new Patient();
           CalculateScore calculateScoreform = new CalculateScore();
           DBConUtil dbConUtil = new DBConUtil();  
           dataSource = dbConUtil.getdataSource();
           String statenm=null;
           String gendercd=null;
           String diagcode=null;
           String ishmo=null;
           String isppo = "Yes";
           String dschrgtohmcr=null;
           String dschrgdctr=null;
           String temp=null;
          
           System.out.println("Initally check patientID"+patient.getPatientid());
         if (null !=patient.getPatientid() && !patient.getPatientid().isEmpty()){
        	 
        	 String patientId=patient.getPatientid();
        	 System.out.println("Received Patient ID is:"+patientId);
        	 
        	 String patname= patient.getPatname();
        	 String patientid=patientId;
        	 String dob=patient.getDoB();
        	 if(IRBConstants.MALE.equals(patient.getGendercd())){
        		 gendercd="M";
        	 }else{
        		 gendercd="F";
        	 }
        	 String citynm=patient.getCitynm();
        	 statenm=patient.getStatenm();
        	 String isdiabetic=patient.getIsdiabetic();
        	 String issmoker=patient.getIssmoker();
        	 String ishyper=patient.getIshyper();
        	 diagcode=patient.getDiagcode();
        	 String diagcodedesc=patient.getDiagcodedesc();
        	 String salaryrange=patient.getSalaryrange();
        	 temp=patient.getTemp().substring(0,2);
        	
        	 String	 admsndate=patient.getAdmsndate();
             if (IRBConstants.HMO.equals(patient.getIshmo())){
            	 ishmo="Yes";
             } else if (IRBConstants.BOTH.equals(patient.getIshmo())){
            	 ishmo="Yes";
            	 isppo="Yes";
             } else{
            	 ishmo="No"; 
             };
             
             String addinsurance=patient.getAddinsurance();
             System.out.println("Checked by Doctor"+patient.getDschrgdctr());
             dschrgdctr=patient.getDschrgdctr();
             if(IRBConstants.YES_IN_ONE.equals(patient.getDschrgtohmcr())){
            	 dschrgtohmcr="Yes";
             }else{
            	 dschrgtohmcr="No";
             };
             
        	
        	
         }
         model.put("riskForm", calculateScoreform);
         String tablename="Userinput";
         List<String> elementName = new ArrayList<String>();
         List<String>elementData =  new ArrayList<String>();
         List<List<String>> elementInfo =  new ArrayList<List<String>>();
         elementName.add("patientage");
         elementName.add("patientstate");
         elementName.add("patinetgndr");
         elementName.add("diagcd");
         elementName.add("plantypehmo");
         elementName.add("hascopay");
         elementName.add("dschrghmcr");
         elementName.add("dschrgbysrgn");
         elementName.add("temp");
         elementData.add("45");
         elementData.add(statenm);
         elementData.add(gendercd);
         elementData.add(diagcode);
         elementData.add(ishmo);
         elementData.add(isppo);
         elementData.add(dschrgtohmcr);
         elementData.add(dschrgdctr);
         elementData.add(temp);
         elementInfo.add(elementData);
         ModelData modeldata = new ModelData();
         modeldata.setElementInfo(elementInfo);
         modeldata.setElementName(elementName);
         modeldata.setTablename(tablename);
         //String responseString=null;
         System.out.println("The tablename is:"+tablename);
         System.out.println("Start Processing JSON");
         System.out.println(modeldata.toString());
         String requestVal = GsonSingleton.getGson().toJson(modeldata);
         System.out.println("Output value is :"+requestVal);
        String modelResponse = getModelResponse(requestVal);         
         System.out.println(modelResponse);
         String updatedModelResponse = modelResponse.substring(1, modelResponse.length()-1);
         System.out.println(updatedModelResponse);
         Gson gson = new Gson();
         ModelData respdata = new ModelData();
         respdata = gson.fromJson(updatedModelResponse, ModelData.class);
         List<String> datalist = new ArrayList<String>();
         List<List<String>> recordAll = new ArrayList<List<String>>();
         recordAll = respdata.getElementInfo();
         System.out.println("Array in data set:"+recordAll.toString());
         datalist=recordAll.get(0);
         System.out.println("The actual data set is:"+datalist.toString());
         String riskValue = datalist.get(7).toString();
         System.out.println("The risk value is"+riskValue);
         String resubmitamount =null;
         model.put("riskValue",riskValue);
         if(IRBConstants.SALARY_RANGE.equals(patient.getSalaryrange())){
        	 resubmitamount="15000";
         }else{
        	 resubmitamount="30000";
         }
         System.out.println("The readmission"+resubmitamount);
         model.put("resubmitamount",resubmitamount);
        
         
        return "ReportRisk";
    }
    
    @RequestMapping(value = "/riskscorepatient", method = RequestMethod.POST)
    public String ReScoreRegistration(@ModelAttribute("riskForm") CalculateScore calcscore,
            Map<String, Object> model) throws SQLException {
                    
           CalculateScore calculateScoreform = new CalculateScore();
           String riskValue=calcscore.getRiskValue();
           String resubmitamount = calcscore.getResubmitamount();
           List<String> lowerprice = calcscore.getLowerprice();
           
           int lengthofArray = lowerprice.size();
           int finalValue  = 0;
           if(lengthofArray>1){
        	   Object obj = Collections.max(lowerprice);
        	   finalValue=Integer.parseInt(obj.toString());
           }else{
        	   finalValue=Integer.parseInt(lowerprice.get(0).toString());
        			   
           }
           
           double revisedLessValue =(Integer.parseInt(resubmitamount)*finalValue)/100;
           double revisedValue=Integer.parseInt(resubmitamount)-revisedLessValue;
           String revisedvalue = String.valueOf(revisedValue);
           model.put("riskForm", calculateScoreform);
           model.put("riskValue",riskValue);
           model.put("resubmitamount",resubmitamount);
           model.put("revisedvalue",revisedvalue);
        
         
        return "RecalculateRisk";
    }
    
    public String getModelResponse(String requestVal){
    	String urlPath= "https://palblyp.pmservice.ibmcloud.com/pm/v1/score/IRB1Data?accesskey=Yn9bduFcA89aahVDut99YuMMOoEYD6SLTvvV1ERHizBAc3Rzljd5O8TjFUcs2FrNpvelDBj2EWArRQzCnErs5CMZ7MwKXrv8cxZgwmbqEwlvvLfiR4mmayU+qGXbfsBZ/w5le5TjV0FpZTSwHSuySamQXJLX5UfGoffx814S/Nw=";
		
		System.out.println("The converted json string:"+requestVal.toString());
		try {
			StringEntity modelRequestSE = new StringEntity(requestVal.toString()); 
			System.out.println("The String value is:"+ modelRequestSE.toString());
			long startTime = System.currentTimeMillis();
			CloseableHttpClient httpclient = HttpClients.custom().build();
			HttpPost httppost = new HttpPost(urlPath);
			httppost.setHeader("content-type","application/json");
			httppost.setEntity(modelRequestSE);
			HttpResponse response = httpclient.execute(httppost);
			System.out.println("Response from Source is:"+response.toString());
			String responseString = new BasicResponseHandler().handleResponse(response);
			return responseString;
	        } catch(IOException e){
	        	System.out.println(e.getMessage());
	        	throw new RuntimeException(e);
	        }
	
    }
}
