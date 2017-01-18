package com.codejava.domain;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ModelData {

@SerializedName("header")
private List<String> elementName;

@SerializedName("data")
private List<List<String>> elementInfo;
@SerializedName("tablename")
private String tablename;

public ModelData(){
	
}

public ModelData(String tablename, List<String> elementName, List<List<String>> elementInfo ){
	this.tablename=tablename;
	this.elementInfo=elementInfo;
	this.elementName=elementName;
	
}

public String getTablename(){
	return this.tablename;
}
public void setTablename(String tablename){
	this.tablename=tablename;
}

public List<String> getElementName(){
	return this.elementName;
}
public void setElementName(List<String> elementName){
	this.elementName=elementName;
}

public List<List<String>> getElementInfo(){
	return this.elementInfo;
}
public void setElementInfo(List<List<String>> elementInfo){
	this.elementInfo=elementInfo;
}
}
