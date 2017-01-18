<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h3>Readmission Risk Assessment</h3>
    <div align="center">
        <form:form action="scorepatient" method="post" commandName="patientoutputForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Patient Details</h2></td>
                </tr>
                <tr>
                    <td>PatientId:</td>
                    <td><form:input path="patientid" readonly="true" /></td>
                </tr>
                <tr>
                    <td>Patient Name:</td>
                    <td><form:input path="patname" readonly="true" /></td>
                </tr>
                <tr>
                    <td>Patient DoB:</td>
                    <td>${dob}</td>
                </tr>
                 <tr>
                    <td>Gender:</td>
                    <td><form:input path="gendercd" readonly="true" /></td>
                </tr> 
                 <tr>
                    <td>City:</td>
                    <td><form:input path="citynm" readonly="true" /></td>
                </tr>  
                 <tr>
                    <td>State:</td>
                    <td><form:input path="statenm" readonly="true" /></td>
                </tr>
                 <tr>
                    <td>Diabetic:</td>
                    <td><form:input path="isdiabetic" readonly="true" /></td>
                </tr>
                 <tr>
                    <td>Smoker:</td>
                    <td><form:input path="issmoker" readonly="true" /></td>
                </tr> 
                 <tr>
                    <td>Hypertensive:</td>
                    <td><form:input path="ishyper" readonly="true" /></td>
                </tr>
                <tr>
                    <td>Diag Code:</td>
                    <td><form:input path="diagcode" readonly="true" /></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><form:input path="diagcodedesc" readonly="true" /></td>
                </tr>
                <tr>
                    <td>Date Admitted:</td>
                    <td><form:input path="admsndate" readonly="true" /></td>
                </tr>
                <tr>
                    <td>Annual Salary Range:</td>
                    <td><form:input path="salaryrange" readonly="true" /></td>
                </tr>
                <tr>
                    <td>City Temperature:</td>
                    <td><form:input path="temp" readonly="true" /></td>
                </tr>
                <tr>
                    <td>Plan Type:</td>
                    <td><form:checkbox path="ishmo" value="HMO"/>HMO
                        <form:checkbox path="isppo" value="PPO"/>PPO</td>
                </tr> 
                <tr>
                    <td>Additional Insurance?</td>
                    <td><form:radiobutton path="addinsurance" value="Y"/>Y
                        <form:radiobutton path="addinsurance" value="N"/>N</td>
                </tr> 
                <tr>
                    <td>Discharged By:</td>
                    <td><form:radiobutton path="dschrgdctr" value="Yes"/>Doctor
                        <form:radiobutton path="dschrgdctr" value="No"/>HouseStaff
                        <form:radiobutton path="dschrgdctr" value="No"/>RNP</td>
                </tr>
                <tr>
                    <td>Discharged To:</td>
                    <td><form:radiobutton path="dschrgtohmcr" value="Y"/>HomeCare
                        <form:radiobutton path="dschrgtohmcr" value="N"/>NursingCare</td>
                        
                </tr>              
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Score" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>