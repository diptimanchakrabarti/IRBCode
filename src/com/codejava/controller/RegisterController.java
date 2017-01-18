package com.codejava.controller;


import com.codejava.dao.ProcessDataDAOImpl;
import com.codejava.util.DBConUtil;
import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.codejava.domain.ModelData;
import com.codejava.domain.ProviderInfo;
import com.codejava.domain.User;

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
public class RegisterController{
	
	
	
	
	public JdbcTemplate jdbcTemplate;
	DataSource dataSource;
	public RegisterController() throws SQLException{
	
    
	}
	
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
    public String viewRegistration(Map<String, Object> model) {
        User userForm = new User();    
        model.put("userForm", userForm);
         
        List<String> professionList = new ArrayList<>();
        professionList.add("Developer");
        professionList.add("Designer");
        professionList.add("IT Manager");
        model.put("professionList", professionList);
         
        return "Registration";
    }
     
    @RequestMapping(value = "/addregister", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user,
            Map<String, Object> model) throws SQLException {
           ProviderInfo provider = new ProviderInfo();
           DBConUtil dbConUtil = new DBConUtil();  
           dataSource = dbConUtil.getdataSource();
           ProcessDataDAOImpl processData = new ProcessDataDAOImpl(dataSource);
         if (null !=user.getUsername() && !user.getUsername().isEmpty()){
        	 
        	 String username=user.getUsername();
        	 String password = user.getPassword();
        	 String email = user.getEmail();
        	 Date birthdate = user.getBirthDate();
        	 String profession = user.getProfession();
        	 //provider.setDoB(birthdate);
        	 provider.setEmail(email);
        	 provider.setPassword(password);
        	 provider.setProfession(profession);
        	 provider.setUsername(username);
        	 processData.saveOrUpdate(provider);
         }
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
         elementData.add("NY");
         elementData.add("M");
         elementData.add("I50.23");
         elementData.add("Yes");
         elementData.add("No");
         elementData.add("Yes");
         elementData.add("No");
         elementData.add("17.5");
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
         ProviderInfo prov = processData.get(user.getUsername());
        // for testing purpose:
        System.out.println("username: " + prov.getUsername());
        System.out.println("password: " + prov.getPassword());
        System.out.println("email: " + prov.getEmail());
        System.out.println("birth date: " + user.getBirthDate());
        System.out.println("profession: " + prov.getProfession());
         
        return "RegistrationSuccess";
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
