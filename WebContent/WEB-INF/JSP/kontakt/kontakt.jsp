<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link href="css/form.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>WDS//Kontakt</title>
</head>
<body class="body_form">
	<form:form action="kontakt.html" modelAttribute="kontakt" method="post">
		<div class="naslov">Kontakt forma</div>
		<div class="label_div">
			<label class="label_style"><b>::</b> Osoba za kontakt</label>
			<form:select path="kontaktOsoba" cssStyle="width:120px;">
				<form:option value=""/>
				<form:option value="davor.butorac@gmail.com">Davor Butorac</form:option>
				<form:option value="tintilinic82@gmail.com">Tin Vasiljević</form:option>
			</form:select>			
		</div>
		<div class="label_div">
			<label class="label_style"><b>::</b> Vaš email</label><form:input path="email" cssStyle="width:180px;"/>
		</div>
		<div class="label_div">
			<label class="label_style"><b>::</b> Tekst poruke</label><form:textarea path="tekstPoruke" cssStyle="width:500px;height:150px;"/>
		</div>
		<div class="label_div">
			<label class="label_style"></label><input class="submit_input" value="Pošalji" name="button" type="submit"> <input class="submit_input" value="Odustani" name="button" type="submit">
		</div>
		<spring:hasBindErrors name="kontakt">
			<div class="error">
				<c:forEach var="err" items="${errors.allErrors}">  
			    	<spring:message code="${err.code}"/>  
			   	</c:forEach>  
		   	</div>
		</spring:hasBindErrors>
		<div class="poruka">
			<c:if test="${not empty poruka}">
				${poruka}
			</c:if>
		</div>
	</form:form>
</body>
</html>