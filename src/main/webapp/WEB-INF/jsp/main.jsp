<%@ page import="java.util.List"
	import="by.it.academy.newsportal.bean.News" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="local.main.title" var="title" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en"
	var="en_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.registration"
	var="registration_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.authorization"
	var="authorization_button" />
<title><c:out value="${title}" /></title>
</head>
<body>

	<h1 class="headline">
		<c:out value="${title}" />
	</h1>

	<form action="Controller" method="post">
		<input type="hidden" name="local" value="ru" />
		 <input type="hidden" name="command" value="CHANGE_LOCALE" />
			<input type="submit" value="${ru_button} " /><br />
	</form>
	<form action="Controller" method="post">
		<input type="hidden" name="local" value="en" /> 
		<input type="hidden" name="command" value="CHANGE_LOCALE" /> 
		<input type="submit" value="${en_button}" />
	</form>
	<form action="Controller" method="post">
		<input type=hidden name="command" value="registration" /> <input
			type="submit" name="command" value="${registration_button}" />
	</form>
	<form action="Controller" method="post">
		<input type=hidden name="command" value="authorization" /> <input
			type="submit" name="command" value="${authorization_button}" />
	</form>

	<br />

	<form>

	
	<c:if test="${sessionScope.user !=null}">
		<c:out value="${user.name }" /><br />
		<form action="Controller" method="post">
		<input type=hidden name="command" value="LOGOUT" /> <input
			type="submit" name="command" value="LogOut" />
	</form>
		
		<c:if test="${newses!=nul}">
			<c:forEach var="news" items="${newses}">
				<p>
				<h1>
					<c:out value="${news.getTitle()}" />
				</h1>
				<h3>
					<c:out value="${news.getBrief()}" />
				</h3>
				</p>
			</c:forEach>
		</c:if>
		</c:if>
	</form>
</body>
</html>