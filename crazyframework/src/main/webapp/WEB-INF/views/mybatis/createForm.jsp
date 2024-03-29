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
</head>
<body>
	<form id="createForm" method="post" action="<c:url value='/mybatis/create.htm'/>">
		<table>
			<tr>
				<td align="center">아이디 <font color="red">*</font></td>
				<td align="center"><input type="text" style="width: 92px;"
					name="userid" /></td>
			</tr>
			<tr>
				<td align="center">이메일 <font color="red">*</font></td>
				<td align="center"><input type="text" style="width: 92px;"
					name="email" /></td>
			</tr>
			<tr>
				<td align="center">이름 <font color="red">*</font></td>
				<td align="center"><input type="text" style="width: 92px;"
					name="name" />
				</td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="등록"/>
	</form>
	<br />
</body>
</html>