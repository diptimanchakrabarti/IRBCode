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
        <form:form action="riskscorepatient" method="post" commandName="riskForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Risk Score</h2></td>
                </tr>
                <tr>
                    <td>Calculated Risk:</td>
                    <td><form:input path="riskValue" readonly="true" value="${riskValue}" /></td>
                </tr>
                <tr>
                    <td>Contributing Factors:</td>
                    <td>Age of Patient</td>
                    <td>Discharged To</td>
                    <td>Diagnosis Code</td>
                    <td>Average Temperature</td>
                </tr>
                <tr>
                    <td>Projected Cost for ReAdmission:</td>
                    <td><form:input path="resubmitamount" readonly="true" value="${resubmitamount}"/></td>
                </tr>
                <tr>
                    <td>Discharged By:</td>
                    <td><form:checkbox path="lowerprice" value="25"/>Checkup After 1 Week of Discharge
                        <form:checkbox path="lowerprice" value="30"/>Tissue Biopsy after 2 weeks
                        <form:checkbox path="lowerprice" value="40"/>Diet UnderSupervision
                        <form:checkbox path="lowerprice" value="45"/>NurseVisit
                        <form:checkbox path="lowerprice" value="48"/>On call Support and Emergency Hotline</td>
                </tr>
                <tr>
                    <td>Revised Cost for ReAdmission:</td>
                    <td><form:input path="revisedvalue" readonly="true" value="${revisedvalue}" /></td>
                </tr>               
                                               
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Calculate Cost" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>