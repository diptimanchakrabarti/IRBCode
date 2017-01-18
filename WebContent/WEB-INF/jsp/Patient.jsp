<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
</head>
<body>
    <div align="center">
        <form:form action="searchpatient" method="post" commandName="patientrequestForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Patient Details</h2></td>
                </tr>
                <tr>
                    <td>Select or Enter Patient ID:</td>
                    <td><form:select path="patientid" >
                        <form:option value="NONE"> --SELECT--</form:option>
                        <form:options items="${patientList}"></form:options>
                        </form:select>
                    </td>
                </tr>
                              
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Search" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>