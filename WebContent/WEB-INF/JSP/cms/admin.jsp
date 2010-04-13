<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WDS//CSM//admin</title>
<link href="css/cms.css" rel="stylesheet" type="text/css">
</head>
<body class="body_cms">
	<form action="AdminServlet" method="post">
		<div class="naslov">CMS//Login</div>
		<div class="label_div">
			<label class="label_style">Username</label><input name="username" type="text">
		</div>
		<div class="label_div">
			<label class="label_style">Password</label><input name="password" type="password">
		</div>
		<div class="label_div">
			<label class="label_style"></label><input class="submit_input" value="Login" type="submit">
		</div>
		<div class="p_t10">Useri/Passovi (Tin/ttt, Davor/ddd, Vlaho/vvv)</div>
		<div class="p_t10">${pogreska}</div>
	</form>
</body>
</html>