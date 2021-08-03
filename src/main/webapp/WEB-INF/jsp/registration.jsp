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
<fmt:message bundle="${loc}" key="local.registrationpage.title"
	var="registrationTitle" />
<fmt:message bundle="${loc}" key="local.registrationpage.titleTable"
	var="titleTable" />
<fmt:message bundle="${loc}" key="local.registrationpage.userName"
	var="userName" />
<fmt:message bundle="${loc}"
	key="local.registrationpage.userPlaceholder" var="userPlaceholder" />
<fmt:message bundle="${loc}" key="local.registrationpage.userSurname"
	var="surname" />
<fmt:message bundle="${loc}"
	key="local.registrationpage.userSurnamePlaceholder"
	var="surnamePlaceholder" />
<fmt:message bundle="${loc}" key="local.registrationpage.age" var="age" />
<fmt:message bundle="${loc}" key="local.registrationpage.agePlaceholder"
	var="agePlaceholder" />
<fmt:message bundle="${loc}" key="local.registrationpage.email"
	var="email" />
	<fmt:message bundle="${loc}" key="local.registrationpage.emailPlaceholder"
	var="emailPlaceholder" />
	<fmt:message bundle="${loc}" key="local.registrationpage.role"
	var="role" />
	<fmt:message bundle="${loc}" key="local.registrationpage.rolePlaceholder"
	var="rolePlaceholder" />
<fmt:message bundle="${loc}"
	key="local.registrationpage.emailPlaceholder" var="emailPlaceholder" />
<fmt:message bundle="${loc}" key="local.registrationpage.login"
	var="login" />
<fmt:message bundle="${loc}"
	key="local.registrationpage.loginPlaceholder" var="loginPlaceholder" />
<fmt:message bundle="${loc}" key="local.registrationpage.password"
	var="password" />
	<fmt:message bundle="${loc}" key="local.registrationpage.passwordPlaceholder"
	var="passwordPlaceholder" />
<fmt:message bundle="${loc}" key="local.registrationpage.button.send"
	var="send_button" />
	<fmt:message bundle="${loc}" key="local.registrationpage.reference"
	var="reference_main" />

<title>${registrationTitle}</title>
</head>
<body>
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
		<input type="hidden" name="command" value="REGISTRATION_NEW_USER">
		${userName}<br /> <input type="text" name="name" class="login-input"
			placeholder="${userPlaceholder}" autofocus value="">
		${surname}<br /> <input type="text" name="surname"
			class="login-input" placeholder="${surnamePlaceholder}" autofocus
			value=""> ${age}<br /> <input type="text" name="age"
			class="login-input" placeholder="${agePlaceholder}" autofocus
			value=""> ${email}<br /> <input type="text" name="email"
			class="login-input" placeholder="${emailPlaceholder}" autofocus
			value=""> 
			${role}<br /> <input type="text" name="role"
			class="login-input" placeholder="${rolePlaceholder}" autofocus value="">
			${login}<br /> <input type="text" name="login"
			class="login-input" placeholder="${loginPlaceholder}" autofocus
			value=""> 
		${password}<br /> <input type="password" name="password"
			class="login-input" placeholder="${passwordPlaceholder}" value="" /> <input
			type="submit" value="${send_button}" class="login-submit">
		<p class="login-help">
			<a href="index.jsp"><c:out value="${reference_main}" /></a>
		</p>
		<br /> <br /> <br /> <br />
	</form>

</body>
</html>