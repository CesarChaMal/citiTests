<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
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
String servlet = (String) request.getAttribute("servlet");

ServletContext context = getServletContext();
Properties props = new Properties();
props.load(context.getResourceAsStream("/WEB-INF/db_config.properties"));
String method = props.getProperty("method");
//System.out.println(method);
%>	
<!-- <div class="wrapper" style="margin-right: 10%; margin-left: 10%;"> -->	
<div class="wrapper" style="margin-right: 0px; margin-left: 0px;">	

	<form action="" method="<%=method%>" name="myform">
	
		<input type="hidden" name="page" value="3">
	
		<%
		List stats = (List) request.getAttribute("tableNames");
		Iterator it = stats.iterator();
		out.print("<select name =\"table\">");
		while(it.hasNext())
		{
			String s = (String )it.next();
			
			out.println("<option>" + s + "</option>");
		}
		out.print("</select>");
		%>	
	 
		<a class="button" href="#" 
		onclick="this.blur();submitform(document.forms.myform,'<%=servlet%>')" 
		style="position:relative; *top:-22px; _top:-22px; background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_a.gif') no-repeat scroll top right;">
			<span style="background: transparent url('<%=request.getContextPath()%>/module/img/bg_button_span.gif') no-repeat;">Table</span>
		</a>
		<!-- <input type="submit" value="Table" /> -->
	</form>
</div>	
</body>
</html>