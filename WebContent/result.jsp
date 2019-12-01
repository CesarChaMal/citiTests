<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="citi.test.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teradata Performance Benchmark</title>

<link href="<%=request.getContextPath()%>/module/css/style.css" rel="stylesheet" type="text/css">

<!-- <script type="text/javascript" src="https://www.google.com/jsapi"></script> -->      
<script language="JavaScript" src="<%=request.getContextPath()%>/module/js/jsapi.js" ></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/module/js/functions.js" ></script>

<%
List stats = (List) request.getAttribute("dbStats");
Iterator it = stats.iterator();
%>

<script type="text/javascript">
	google.load("visualization", "1", {packages:["corechart","table"]});
	google.setOnLoadCallback(drawChart);

	  function barMouseOver(e) {     
		  barsVisualization.setSelection([e]);   
	  }    
	  
	  function barMouseOut(e) {     
		  barsVisualization.setSelection([{'row': null, 'column': null}]);   
	  }
	  
	  function drawChart() {
		var data = new google.visualization.DataTable();
		data.addColumn('date', 'Date');
		data.addColumn('number', 'SumIO');
		data.addColumn('number', 'rowct');
		
		var data2 = new google.visualization.DataTable();
		data2.addColumn('date', 'Date');
		data2.addColumn('number', 'cpuskw');
		data2.addColumn('number', 'ioskw');
		data2.addColumn('number', 'pji');
		data2.addColumn('number', 'uii');
		
		var data3 = new google.visualization.DataTable();
		data3.addColumn('date', 'Date');
		data3.addColumn('number', 'queryResponseTime');
		data3.addColumn('number', 'sumCpu');
		
		var myArray2 = [];
		<%
		String string="";
		String debug="";
		String debug1="";
		int size = stats.size();
		for (int i = 0; i < size; i++)
		{
			Stats stat = (Stats)stats.get(i);
			string += "var date = trim(\\'" + stat.getLogDate()+ "\\');";
			string += "/*alert(date);*/";
			string += "if(date.split(\\'/\\')==date){";
			string += "		if(date.split(\\'-\\')==date){";
			string += "			date = new Date();";
			string += "		}else{";
			string += "			date = date.split(\\'-\\');";
			string += "			/*alert(\\' date[2]: \\' + date[2] + \\' date[0]: \\' + date[0] + \\' date[1]: \\' + date[1] );*/";
			string += "			date = new Date(date[0],date[1]-1,date[2]);";
			string += "		} ";
			string += "}else{ ";
			string += "		date = date.split(\\'/\\');";
			string += "		/*alert(\\'date[2]: \\' + date[2] + \\' date[0]: \\' + date[0] + \\' date[1]: \\' + date[1] );*/";
			string += "		date = new Date(date[2],date[0]-1,date[1]);";
			string += "	};";
			string += "/*alert(date);*/";
			//string += "alert(date[2]);";
			//06/27/2011
			//string += "date = date.split(\\'-\\');";
			//2011-06-27
			
			//string += "myArray2.push( new Array(new Date(trim(\\'" + stat.getLogDate()+ "\\')),\\'" + stat.getSumIO() + "\\',\\'"+ stat.getRowCount() +"\\'));";
			//string += "myArray2.push( new Array(new Date(date[2],date[0],date[1]) ,\\'" + stat.getSumIO() + "\\',\\'"+ stat.getRowCount() +"\\'));";
			string += "myArray2.push( new Array(date ," + stat.getSumIO() + ","+ stat.getRowCount() +"));";
			//string += "myArray2.push( new Array(date ,\\'" + stat.getSumIO() + "\\',\\'"+ stat.getRowCount() +"\\'));";


			//debug = "myArray2.push( new Array(Date.parse(\\'" + stat.getLogDate()+ "\\')," + stat.getSumIO() + ","+ stat.getRowCount() +"));";
			//debug1 += "if(typeof "+stat.getSumIO()+"!=\\'number\\') alert("+stat.getSumIO()+");";
			//debug1 += "if(typeof "+stat.getRowCount()+"!=\\'number\\') alert("+stat.getRowCount()+");"; 

			%>//alert('< %=debug%>');<%
		}
		%>
		//alert('< %=string%>');
		eval('<%=string%>');
		//eval('< %=debug1%>');
		
		var myArray3 = [];

		
		<%
		String string3="";
		size = stats.size();
		for (int i = 0; i < size; i++)
		{
			Stats stat = (Stats)stats.get(i);
			
			string3 += "var date = trim(\\'" + stat.getLogDate()+ "\\');";
			string3 += "/*alert(date);*/";
			string3 += "if(date.split(\\'/\\')==date){";
			string3 += "		if(date.split(\\'-\\')==date){";
			string3 += "			date = new Date();";
			string3 += "		}else{";
			string3 += "			date = date.split(\\'-\\');";
			string3 += "			/*alert(\\' date[2]: \\' + date[2] + \\' date[0]: \\' + date[0] + \\' date[1]: \\' + date[1] );*/";
			string3 += "			date = new Date(date[0],date[1]-1,date[2]);";
			string3 += "		} ";
			string3 += "}else{ ";
			string3 += "		date = date.split(\\'/\\');";
			string3 += "		/*alert(\\'date[2]: \\' + date[2] + \\' date[0]: \\' + date[0] + \\' date[1]: \\' + date[1] );*/";
			string3 += "		date = new Date(date[2],date[0]-1,date[1]);";
			string3 += "	};";
			string3 += "/*alert(date);*/";

			//string += "myArray2.push( new Array(new Date(trim(\\'" + stat.getLogDate()+ "\\')),\\'" + stat.getSumIO() + "\\',\\'"+ stat.getRowCount() +"\\'));";
			//string += "myArray2.push( new Array(new Date(date[2],date[0],date[1]) ,\\'" + stat.getSumIO() + "\\',\\'"+ stat.getRowCount() +"\\'));";
			string3 += "myArray3.push( new Array(date," + stat.getCpuSkw() + ","+ stat.getIoSkw() +","+stat.getPji()+","+ stat.getUii()+"));";
		}
		%>
		//alert('< %=string3%>');
		eval('<%=string3%>');
		
		var myArray4 = [];
		<%
		String string4="";
		size = stats.size();
		for (int i = 0; i < size; i++)
		{
			Stats stat = (Stats)stats.get(i);

			string4 += "var date = trim(\\'" + stat.getLogDate()+ "\\');";
			string4 += "/*alert(date);*/";
			string4 += "if(date.split(\\'/\\')==date){";
			string4 += "		if(date.split(\\'-\\')==date){";
			string4 += "			date = new Date();";
			string4 += "		}else{";
			string4 += "			date = date.split(\\'-\\');";
			string4 += "			/*alert(\\' date[2]: \\' + date[2] + \\' date[0]: \\' + date[0] + \\' date[1]: \\' + date[1] );*/";
			string4 += "			date = new Date(date[0],date[1]-1,date[2]);";
			string4 += "		} ";
			string4 += "}else{ ";
			string4 += "		date = date.split(\\'/\\');";
			string4 += "		/*alert(\\'date[2]: \\' + date[2] + \\' date[0]: \\' + date[0] + \\' date[1]: \\' + date[1] );*/";
			string4 += "		date = new Date(date[2],date[0]-1,date[1]);";
			string4 += "	};";
			string4 += "/*alert(date);*/";

			string4 += "myArray4.push( new Array(date," + stat.getQueryResponseTime() + ","+  stat.getSumCPU()+"));";
		}
		%>
		//alert('< %=string4%>');
		eval('<%=string4%>');
		//myArray2.push( new Array( '01/02/2011', 12000000, 20000000) );
		
		//alert(myArray2[1]);

		//var myArray3 = new Array();
		
		//alert(myArray3[1]);
		data.addRows(myArray2);
		data2.addRows(myArray3);
		data3.addRows(myArray4);

		var options = { 
			      width: 1400, height: 700, 
			      title: 'Teradata Performance Benchmark' 
			};
		//google.visualization.DateFormat({pattern:"YYYY-MM-dd"});
		/* google.visualization.data.group(data,
				[0], 
				[{'column': 1, 'aggregation': google.visualization.data.month, 'type': 'date'}]);
		 */
		var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
		var chart2 = new google.visualization.LineChart(document.getElementById('chart_div2'));
		var chart3 = new google.visualization.LineChart(document.getElementById('chart_div3'));
		
		chart.draw(data, options);       
		var options = { 
			      width: 1400, height: 700, 
			      title: '' 
			};
		chart2.draw(data2, options);
		chart3.draw(data3,options);
		
		 /*
		var data4 = new google.visualization.DataTable();
		data4.addColumn('string', 'Date');
		data4.addColumn('number', 'SumIO');
		data4.addColumn('number', 'rowct');
		data4.addColumn('number', 'cpuskw');
		data4.addColumn('number', 'ioskw');
		data4.addColumn('number', 'pji');
		data4.addColumn('number', 'uii');
		data4.addColumn('number', 'queryResponseTime');
		data4.addColumn('number', 'sumCpu');
		 */
		
		<%
		 /*
		String string5="";
		size = stats.size();

		string5 += "data4.addRows(" + size + ");";
		for (int i = 0; i < size; i++)
		{
			Stats stat = (Stats)stats.get(i);

			string5 += "data4.setCell(" + i + ", 0, \\'" + stat.getLogDate()+ "\\');";   
			//string5 += "data4.setCell(" + i + ", 0, date);";   
			string5 += "data4.setCell(" + i + ", 1, " + stat.getQueryResponseTime() + ");";   
			string5 += "data4.setCell(" + i + ", 2, " + stat.getSumCPU() + ");";
			string5 += "data4.setCell(" + i + ", 3, " + stat.getSumIO() + ");";
			string5 += "data4.setCell(" + i + ", 4, " + stat.getCpuSkw() + ");";
			string5 += "data4.setCell(" + i + ", 5, " + stat.getIoSkw() + ");";
			string5 += "data4.setCell(" + i + ", 6, " + stat.getPji() + ");";
			string5 += "data4.setCell(" + i + ", 7, " + stat.getUii() + ");";
			string5 += "data4.setCell(" + i + ", 8, " + stat.getRowCount() + ");";
		}
		 */
		%>
		//alert('< %=string5%>');
		//eval('< %=string5%>');

		/*
	    barsVisualization = new google.visualization.ColumnChart(document.getElementById('mouseoverdiv'));
		var options = { 
			      width: 7000, height: 700, 
			      title: '' 
			};
		
	    barsVisualization.draw(data4, options);
	     */
	    
		var options = { 
		      width: 1000, height: 800, 
              chartArea: {top: '25%', right: 0, bottom: 0},
		      title: '' 
		};
		var table = new google.visualization.Table(document.getElementById('table_div'));
		table.draw(data, options);
    
		var table2 = new google.visualization.Table(document.getElementById('table_div2'));
		table2.draw(data2, options);
     
		var table3 = new google.visualization.Table(document.getElementById('table_div3'));
		table3.draw(data3, options);
	     
	    // Add our over/out handlers.
	    //google.visualization.events.addListener(barsVisualization, 'onmouseover', barMouseOver);     
	    //google.visualization.events.addListener(barsVisualization, 'onmouseout', barMouseOut); 		
	}     
</script>   

</head>

<body>

	<div class="wrapper" style="margin-right: 0px; margin-left: 0px;">	
	
		<a href="<%=request.getContextPath()%>/stats_index.jsp">Home</a>
	
		<div id="chart_div" style="width: 1400px; height: 600px;"></div>  
		<div id="chart_div2" style="width: 1400px; height: 600px;"></div>
		<div id="chart_div3" style="width: 1400px; height: 600px;"></div>

		<!-- <div id="mouseoverdiv" style="width: 7000px; height: 700px; position:relative; left:-41%;"></div> -->

		<div id="table_div" style="width: 1000px; height: 800px; position:relative; left:24%; top:100px;"></div>
		<div id="table_div2" style="width: 1000px; height: 800px; position:relative; left:24%; top:200px;"></div>
		<div id="table_div3" style="width: 1000px; height: 800px; position:relative; left:24%; top:300px;"></div>
<%-- 	
		<table border="1" cellspacing="0" cellpadding="0" style="position:relative; left:24%; top:100px; width: 1000px;">
			<tr class="hd">
				<td >logDate</td>
				<td>QryRespTime</td>	
				<td>SumCPU</td>
				<td>SumIO</td>
				<td>CPUSKW</td>
				<td>IOSKW</td>
				<td>PJI</td>
				<td>UII</td>
				<td>rowct</td>
			</tr>
			<%

			int i = 0;
			String styleClass = "d0";
			while (it.hasNext()) {
				Stats s = (Stats) it.next();

				i++;
				if (i%2==0)
					styleClass = "d0";
				else
					styleClass = "d1";

				out.print("<tr class='"+ styleClass + "'>");
				out.println("<td>" + s.getLogDate() + "</td>");
				out.println("<td>" + s.getQueryResponseTime() + "</td>");
				out.println("<td>" + s.getSumCPU() + "</td>");
				out.println("<td>" + s.getSumIO() + "</td>");
				out.println("<td>" + s.getCpuSkw() + "</td>");
				out.println("<td>" + s.getIoSkw() + "</td>");
				out.println("<td>" + s.getPji() + "</td>");
				out.println("<td>" + s.getUii() + "</td>");
				out.println("<td>" + s.getRowCount() + "</td>");
				out.print("</tr>");
			}
			%>
		</table>
--%>		
	</div>

</body>
</html>
