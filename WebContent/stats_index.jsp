<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Properties" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teradata Performance Benchmark</title>

<link href="<%=request.getContextPath()%>/module/css/style.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="<%=request.getContextPath()%>/module/js/functions.js" ></script>

</head>
<body>
<% 
ServletContext context = getServletContext();
Properties props = new Properties();
props.load(context.getResourceAsStream("/WEB-INF/db_config.properties"));
String method = props.getProperty("method");
//System.out.println(method);
%>	
<!-- <div class="wrapper" style="margin-right: 10%; margin-left: 10%;"> -->	
<div class="wrapper" style="margin-right: 0px; margin-left: 0px;">	
	<form action="" method="<%=method%>" name="myform">
		<input type="hidden" name="page" value="1">
		
		<table cellspacing="10" cellpadding="10">
		<tr style='vertical-align: top'>
			<td>
				<a class="button" href="#" 
				onclick="this.blur();submitform(document.forms.myform,'QueryTables2')" 
				style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_a.gif') no-repeat scroll top right;">
					<span style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_span.gif') no-repeat;">MLOAD History Performance By FID</span>
				</a>
			</td>
		</tr>
		<tr style='vertical-align: top'>
			<td>
				<a class="button" href="#" 
				onclick="this.blur();submitform(document.forms.myform,'QueryTables')" 
				style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_a.gif') no-repeat scroll top right;">
					<span style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_span.gif') no-repeat;">Teradata Performance Benchmark</span>
				</a>
			</td>
		</tr>
		</table>
		
		<!-- <input type="submit" value="Teradata Performance Benchmark" /> -->
	</form>
</div>

</body>
</html>