<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/style.css">
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />
	<fmt:message bundle="${loc}" key="local.authorizationpage.title"
	var="title" />
	<fmt:message bundle="${loc}" key="local.authorizationpage.titleTable"
	var="titleTable" />
	<fmt:message bundle="${loc}" key="local.authorizationpage.login"
	var="login" />
	<fmt:message bundle="${loc}" key="local.authorizationpage.loginPlaceholder"
	var="loginPlaceholder" />
	<fmt:message bundle="${loc}" key="local.authorizationpage.password"
	var="password" />
	<fmt:message bundle="${loc}" key="local.authorizationpage.passwordPlaceholder"
	var="passwordPlaceholder" />
	<fmt:message bundle="${loc}" key="local.authorizationpage.buttom"
	var="send_buttom" />
	<fmt:message bundle="${loc}" key="local.authorizationpage.reference"
	var="reference" />
<title>${title} </title>
</head>
<body>
	<br />
	<font color="white" size="4"> <c:if
			test="${param['message']!=null} ">
			<c:out value="message" />
		</c:if>
	</font>
	<form action="Controller" method="post">
		<input type="hidden" name="local" value="ru" /> <input type="hidden"
			name="command" value="CHANGE_LOCALE" /> <input type="submit"
			value="${ru_button}" /><br />
	</form>
	<form action="Controller" method="post">
		<input type="hidden" name="local" value="en" /> <input type="hidden"
			name="command" value="CHANGE_LOCALE" /> <input type="submit"
			value="${en_button}" />
	</form>
	<br />
	<form action="Controller" method="post" class="login">
		<h1 class="headline">${titleTable}</h1>
		<input type="hidden" name="command" value="SIGN_IN">
		 ${login}<input
			type="text" name="login" class="login-input" placeholder="${loginPlaceholder}"
			autofocus value="" /> <br />
			 ${password}<input type="password"
			name="command" class="login-input" placeholder="${passwordPlaceholder}" value="" /><br />
		<input type="submit" value="${send_buttom}" class="login-submit">
		<p class="login-help">
			<a href="index.jsp"><c:out value="${reference}" /></a>
		</p>
		<br /> <br />
	</form>
</body>
</html>