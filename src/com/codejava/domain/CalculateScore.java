package com.codejava.domain;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculateScore {

private String resubmitamount;
private String riskValue;
private List<String> lowerprice;
private String revisedvalue;

public CalculateScore(){
	}

public CalculateScore(String resubmitamount, String riskValue, List<String> lowerprice, String revisedvalue){
	this.lowerprice=lowerprice;
	this.resubmitamount=resubmitamount;
	this.riskValue=riskValue;
	this.revisedvalue=revisedvalue;
}

public String getResubmitamount(){
	return this.resubmitamount;
}
public void setResubmitamount(String resubmitamount){
	 this.resubmitamount=resubmitamount;
}

public String getRiskValue(){
	return this.riskValue;
}
public void setRiskValue(String riskValue){
	 this.riskValue=riskValue;
}

public List<String> getLowerprice(){
	return this.lowerprice;
}
public void setLowerprice(List<String> lowerprice){
	 this.lowerprice=lowerprice;
}

public String getRevisedvalue(){
	return this.revisedvalue;
}
public void setRevisedvalue(String revisedvalue){
	 this.revisedvalue=revisedvalue;
}
}
