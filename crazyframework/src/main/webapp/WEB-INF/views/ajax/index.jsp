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
	<form id="createForm" method="post">
		<table>
			<tr>
				<td align="center">아이디 <font color="red">*</font></td>
				<td align="center"><input type="text" style="width: 92px;"
					name="userid" id="userid" /></td>
			</tr>
			<tr>
				<td align="center">이메일 <font color="red">*</font></td>
				<td align="center"><input type="text" style="width: 92px;"
					name="email" id="email"/></td>
			</tr>
			<tr>
				<td align="center">이름 <font color="red">*</font></td>
				<td align="center"><input type="text" style="width: 92px;"
					name="name" id="name" />
				</td>
			</tr>
		</table>
		<input type="button" value="조회" id="search" /> &nbsp;
		<input type="button" value="저장" id="save" /> 
	</form>

	<!-- javascript -->
	<script src="<c:url value='/js/jquery/jquery-1.6.2.js'/>"
		type="text/javascript"></script>

	<script>
	var listURL = "<c:url value='/ajax/getAll.ajax'/>";
	var saveURL = "<c:url value='/ajax/create.ajax'/>";
	
	//-- window onLoad --------------------------------
	$(document).ready(function() {
        // -- search event --------------------------------
        $("#search").bind("click", function(e) {
        	 params = {
 	        };
        	invokeAjax("POST", listURL, params, 
       	        function (data, textStatus,xhr) {
        			alert(xhr.responseText);
       	        });
    	});
        
     // -- save event --------------------------------
        $("#save").bind("click", function(e) {
        	 params = {
       			 "userid":$("#userid").val(),
                 "email":$("#email").val(),
                  "name":$("#name").val()
 	        };
        	invokeAjax("POST", saveURL, params, 
       	        function (data, textStatus,xhr) {
        			alert(xhr.responseText);
        			alert(xhr.status);
       	        });
    	});
	});

	//ajax library
	function invokeAjax (method,url,parameters,handler) {
        $.ajax({
	      type: method,
	      url: url,
	      data:parameters,
	      beforeSend:function(xhr) {
	      },
	      success:handler,
	      error:function(xhr, textStatus, errorThrown) {
	        if(xhr.status == 400) {
	                alert(xhr.responseText);
	        }else{
	                alert(xhr.responseText);
	        }
	      },
	      complete:function(xhr, textStatus) {
	      },
	      timeout:1000
	  		});// ajax of end
	}
	</script>

</body>
</html>