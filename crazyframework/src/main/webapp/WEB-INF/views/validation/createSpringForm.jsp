<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (request.getProtocol().equals("HTTP/1.1"))
		response.setHeader("Cache-Control", "no-cache");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>계정 등록</title>
<script>
	function doSubmit() {
		var form = document.member;
		form.action = "<c:url value='/validation/createSpring.htm'/>";
		form.submit();
	}
</script>
</head>
<body>
	<form:form method="POST" commandName="member" name="member">
		<table>
			<tr>
				<td align="center">아이디 <font color="red">*</font></td>
				<td align="center"><form:input path="userid" /> <form:errors
						path="userid" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td align="center">이메일 <font color="red">*</font></td>
				<td align="center"><form:input path="email" /> <form:errors
						path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td align="center">이름 <font color="red">*</font></td>
				<td align="center"><form:input path="name" /> <form:errors
						path="name" cssClass="error" />
				</td>
			</tr>
		</table>
		<br />
		<input type="button" value="등록" onclick="doSubmit();" />
	</form:form>
</body>
</html>