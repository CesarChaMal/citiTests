<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="citi.test.beans.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MLOAD Hist Performance Data</title>

<link href="<%=request.getContextPath()%>/module/css/style.css" rel="stylesheet" type="text/css">

<!-- <script type="text/javascript" src="https://www.google.com/jsapi"></script> -->      
<script language="JavaScript" src="<%=request.getContextPath()%>/module/js/jsapi.js" ></script>
<script language="JavaScript" src="<%=request.getContextPath()%>/module/js/functions.js" ></script>

<%
List stats = (List) request.getAttribute("dbStats");
Iterator it = stats.iterator();
%>

<script type="text/javascript">
	//google.load("visualization", "1", {packages:["corechart"]});
    google.load('visualization', '1.1', {packages: ['controls']});
	google.setOnLoadCallback(drawChart);

	  function barMouseOver(e) {     
		  barsVisualization.setSelection([e]);   
	  }    
	  
	  function barMouseOut(e) {     
		  barsVisualization.setSelection([{'row': null, 'column': null}]);   
	  }
	  
	  function drawChart() {
		<%
		int size = stats.size();
		String string="";
		String string2="";
		for (int i = 0; i < size; i++)
		{
			List statList = (List) stats.get(i);
			String tipo="";
			System.out.println(((MLOADStats)statList.get(i)).getType());
			//System.out.println(citi.test.beans.MLOADStats.Type.RunTimeMinutes);
/*			
			switch (((MLOADStats)statList.get(i)).getType())
			{
			    case RunTimeMinutes:
			    	tipo="runTimeMinutes";
			    	break;                
			    case MillionIO:
			    	tipo="millionIO";
			    	break;                
			    case CPUKiloSeconds:
			    	tipo="cpuKiloSeconds";
			    	break;                
			    case MillionRows:
			    	tipo="millionRows";
			    	break;                
			    case NbrMLOADs:
			    	tipo="nbrMLOADs";
			    	break;                
			    default:
			}
*/			
			if(((MLOADStats)statList.get(i)).getType().equals(citi.test.beans.MLOADStats.RunTimeMinutes))
				tipo="runTimeMinutes";
			else if(((MLOADStats)statList.get(i)).getType().equals(citi.test.beans.MLOADStats.MillionIO))
			    tipo="millionIO";
			else if(((MLOADStats)statList.get(i)).getType().equals(citi.test.beans.MLOADStats.CPUKiloSeconds))
		    	tipo="cpuKiloSeconds";
			else if(((MLOADStats)statList.get(i)).getType().equals(citi.test.beans.MLOADStats.MillionRows))
	    		tipo="millionRows";
			else if(((MLOADStats)statList.get(i)).getType().equals(citi.test.beans.MLOADStats.NbrMLOADs))
			    tipo="nbrMLOADs";

			string = "var " + tipo + " = google.visualization.arrayToDataTable([";
			string += "[\\'MONTHNBR\\', \\'BICOLL_P\\', \\'CBNACOM_PROD\\', \\'CBNANGDS\\', \\'CMRPROD\\', \\'DMR_ETLDBUSRP\\', \\'DWIMPID\\', \\'ESPROD\\', \\'NAITPROD\\', \\'OPRPROD\\', \\'PRODRUN\\', \\'RELPROD\\', \\'RPLPROD\\', \\'SYMPROD\\', \\'TAGADM\\'],";

			for (int j = 0; j < statList.size(); j++)
			{
				MLOADStats type = (MLOADStats)statList.get(j);
				string += "[";
 				string += "\\'" + type.getMonthNbr() + "\\',";
				string += type.getBicoll_p() + ",";
				string += type.getCbnacom_prod() + ",";
				string += type.getCbnangds() + ",";
				string += type.getCmrprod() + ",";
				string += type.getDmr_etldbusrp() + ",";
				string += type.getDwimpid() + ",";
				string += type.getEsprod() + ",";
				string += type.getNaitprod() + ",";
				string += type.getOprprod() + ",";
				string += type.getProdrun() + ",";
				string += type.getRelprod() + ",";
				string += type.getRplprod() + ",";
				string += type.getSymprod() + ",";
				string += type.getTagadm();
				string += "],";

// 				string += "[";
// 				string += "\\'" + type.getMonthNbr() + "\\',";
// 				string += "\\'" + type.getBicoll_p() + "\\',";
// 				string += "\\'" + type.getCbnacom_prod() + "\\',";
// 				string += "\\'" + type.getCbnangds() + "\\',";
// 				string += "\\'" + type.getCmrprod() + "\\',";
// 				string += "\\'" + type.getDmr_etldbusrp() + "\\',";
// 				string += "\\'" + type.getDwimpid() + "\\',";
// 				string += "\\'" + type.getEsprod() + "\\',";
// 				string += "\\'" + type.getNaitprod() + "\\',";
// 				string += "\\'" + type.getOprprod() + "\\',";
// 				string += "\\'" + type.getProdrun() + "\\',";
// 				string += "\\'" + type.getRelprod() + "\\',";
// 				string += "\\'" + type.getRplprod() + "\\',";
// 				string += "\\'" + type.getSymprod() + "\\',";
// 				string += "\\'" + type.getTagadm() + "\\'";
// 				string += "],";

				string2 = "[";
 				string2 += "\\'" + type.getMonthNbr() + "\\',";
				string2 += type.getBicoll_p() + ",";
				string2 += type.getCbnacom_prod() + ",";
				string2 += type.getCbnangds() + ",";
				string2 += type.getCmrprod() + ",";
				string2 += type.getDmr_etldbusrp() + ",";
				string2 += type.getDwimpid() + ",";
				string2 += type.getEsprod() + ",";
				string2 += type.getNaitprod() + ",";
				string2 += type.getOprprod() + ",";
				string2 += type.getProdrun() + ",";
				string2 += type.getRelprod() + ",";
				string2 += type.getRplprod() + ",";
				string2 += type.getSymprod() + ",";
				string2 += type.getTagadm();
				string2 += "],";
				%>/* alert('< %=string2%>'); */<%
				
				%>/* if (typeof '<%=type.getMonthNbr()%>' != 'number' && typeof '<%=type.getMonthNbr()%>' != 'string')alert('MonthNbr: ' + typeof '<%=type.getMonthNbr()%>');*/ <%
				%>/* if (typeof <%=type.getMonthNbr()%> != 'number' && typeof <%=type.getMonthNbr()%> != 'string')alert('MonthNbr: ' + typeof <%=type.getMonthNbr()%>); */<%
				%>/* if (typeof <%=type.getBicoll_p()%> != 'number' && typeof <%=type.getBicoll_p()%> != 'string')alert('Bicoll_p: ' + typeof <%=type.getBicoll_p()%>); */<%
				%>/* if (typeof <%=type.getCbnacom_prod()%> != 'number' && typeof <%=type.getCbnacom_prod()%> != 'string')alert('Cbnacom_prod: ' + typeof <%=type.getCbnacom_prod()%>); */<%
				%>/* if (typeof <%=type.getCbnangds()%> != 'number' && typeof <%=type.getCbnangds()%> != 'string')alert('Cbnangds: ' + typeof <%=type.getCbnangds()%>); */<%
				%>/* if (typeof <%=type.getCmrprod()%> != 'number' && typeof <%=type.getCmrprod()%> != 'string')alert('Cmrprod: ' + typeof <%=type.getCmrprod()%>); */<%
				%>/* if (typeof <%=type.getDmr_etldbusrp()%> != 'number' && typeof <%=type.getDmr_etldbusrp()%> != 'string')alert('Dmr_etldbusrp: ' + typeof <%=type.getDmr_etldbusrp()%>); */<%
				%>/* if (typeof <%=type.getDwimpid()%> != 'number' && typeof <%=type.getDwimpid()%> != 'string')alert('Dwimpid: ' + typeof <%=type.getDwimpid()%>); */<%
				%>/* if (typeof <%=type.getEsprod()%> != 'number' && typeof <%=type.getEsprod()%> != 'string')alert('Esprod: ' + typeof <%=type.getEsprod()%>); */<%
				%>/* if (typeof <%=type.getNaitprod()%> != 'number' && typeof <%=type.getNaitprod()%> != 'string')alert('Naitprod: ' + typeof <%=type.getNaitprod()%>); */<%
				%>/* if (typeof <%=type.getOprprod()%> != 'number' && typeof <%=type.getOprprod()%> != 'string')alert('Oprprod: ' + typeof <%=type.getOprprod()%>); */<%
				%>/* if (typeof <%=type.getProdrun()%> != 'number' && typeof <%=type.getProdrun()%> != 'string')alert('Prodrun: ' + typeof <%=type.getProdrun()%>); */<%
				%>/* if (typeof <%=type.getRelprod()%> != 'number' && typeof <%=type.getRelprod()%> != 'string')alert('Relprod: ' + typeof <%=type.getRelprod()%>); */<%
				%>/* if (typeof <%=type.getRplprod()%> != 'number' && typeof <%=type.getRplprod()%> != 'string')alert('Rplprod: ' + typeof <%=type.getRplprod()%>); */<%
				%>/* if (typeof <%=type.getSymprod()%> != 'number' && typeof <%=type.getSymprod()%> != 'string')alert('Symprod: ' + typeof <%=type.getSymprod()%>);*/ <%
				%>/* if (typeof <%=type.getTagadm()%> != 'number' && typeof <%=type.getTagadm()%> != 'string')alert('Tagadm: ' + typeof <%=type.getTagadm()%>); */<%
				
			}
			string = string.substring(0,string.lastIndexOf(','));
			string += "]);";
			%> /*alert('< %=string%>');*/<%
			%> eval('<%=string%>'); <%
			System.out.println(string); 
		}		 
		//System.out.println(string); 
		%>
		//alert('< %=string%>');
		//eval('< %=string%>');

		var MonthNbrPicker1 = new google.visualization.ControlWrapper({
		    'controlType': 'CategoryFilter',
		    'containerId': 'control1',
		    'options': {
		      'filterColumnLabel': 'MONTHNBR',
		      'ui': {
		        'labelStacking': 'vertical',
                'allowNone': true,
                'allowTyping': true,
                'allowMultiple': true,
                'caption' : 'Choose a value',
                'selectedValuesLayout': 'belowStacked'
		      }
		    }
		});
		
        var runTimeMinutesTable = new google.visualization.ChartWrapper({
          'chartType': 'Table',
          'containerId': 'runTimeMinutesTable',
          'options': {
            'width': '100%',
            'height': '100%'
          }
        });		
		
        var runTimeMinutesChart = new google.visualization.ChartWrapper({
            'chartType': 'ColumnChart',
            'containerId': 'runTimeMinutes',
            'options': {
              'title' : 'Total Run Time',
              'width': 1400,
              'height': 700,
              'chartArea': {top: '5%', right: 0, left: '15%', bottom: 0},
              'isStacked': true,
              'vAxis': {title: 'data', titleTextStyle: {color: 'black',fontName: 'Calibri', fontSize: 18},textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 14}},
              'hAxis': {title: 'date', titleTextStyle: {color: 'black',fontName: 'Calibri', fontSize: 18},textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 14},'slantedText': true,'slantedTextAngle': '90'},
              'legend' : {position: 'right', textStyle: {color: 'black', fontSize: 12, fontName: 'Calibri'}},
              'titleTextStyle': {color: 'black',fontName: 'Calibri', fontSize: 16},
              'tooltip' : {/*trigger:'none'*/trigger:'hover',textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 11}},
              'seriesType': 'bars'
            }
            //,'view': {'columns': [0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]}
          });

        new google.visualization.Dashboard(document.getElementById('dashboard')).
        //bind(MonthNbrPicker1, runTimeMinutesChart).
        bind(MonthNbrPicker1, [runTimeMinutesChart, runTimeMinutesTable]).
        // Draw the dashboard
        draw(runTimeMinutes);
        
		var MonthNbrPicker2 = new google.visualization.ControlWrapper({
		    'controlType': 'CategoryFilter',
		    'containerId': 'control2',
		    'options': {
		      'filterColumnLabel': 'MONTHNBR',
		      'ui': {
		        'labelStacking': 'vertical',
                'allowNone': true,
                'allowTyping': true,
                'allowMultiple': true,
                'caption' : 'Choose a value',
                'selectedValuesLayout': 'belowStacked'
		      }
		    }
		});
		
        var millionIOTable = new google.visualization.ChartWrapper({
          'chartType': 'Table',
          'containerId': 'millionIOTable',
          'options': {
            'width': '100%',
            'height': '100%'
          }
        });
        		
        var millionIOChart = new google.visualization.ChartWrapper({
            'chartType': 'ColumnChart',
            'containerId': 'millionIO',
            'options': {
              'title' : 'I/O in Million',
              'width': 1400,
              'height': 700,
              'chartArea': {top: '5%', right: 0, left: '15%', bottom: 0},
              'isStacked': true,
              'vAxis': {title: 'data', titleTextStyle: {color: 'black',fontName: 'Calibri', fontSize: 18},textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 14}},
              'hAxis': {title: 'date', titleTextStyle: {color: 'black',fontName: 'Calibri', fontSize: 18},textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 14},'slantedText': true,'slantedTextAngle': '90'},
              'legend' : {position: 'right', textStyle: {color: 'black', fontSize: 12, fontName: 'Calibri'}},
              'titleTextStyle': {color: 'black',fontName: 'Calibri', fontSize: 16},
              'tooltip' : {/*trigger:'none'*/trigger:'hover',textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 11}},
              'seriesType': 'bars'
            }
            //,'view': {'columns': [0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]}
          });

        new google.visualization.Dashboard(document.getElementById('dashboard')).
        //bind(MonthNbrPicker2, millionIOChart).
        bind(MonthNbrPicker2, [millionIOChart, millionIOTable]).
        // Draw the dashboard
        draw(millionIO);

		var MonthNbrPicker3 = new google.visualization.ControlWrapper({
		    'controlType': 'CategoryFilter',
		    'containerId': 'control3',
		    'options': {
		      'filterColumnLabel': 'MONTHNBR',
		      'ui': {
		        'labelStacking': 'vertical',
                'allowNone': true,
                'allowTyping': true,
                'allowMultiple': true,
                'caption' : 'Choose a value',
                'selectedValuesLayout': 'belowStacked'
		      }
		    }
		});
		
        var cpuKiloSecondsTable = new google.visualization.ChartWrapper({
          'chartType': 'Table',
          'containerId': 'cpuKiloSecondsTable',
          'options': {
            'width': '100%',
            'height': '100%'
          }
        });
        
        var cpuKiloSecondsChart = new google.visualization.ChartWrapper({
            'chartType': 'ColumnChart',
            'containerId': 'cpuKiloSeconds',
            'options': {
              'title' : 'CPU Usage in Kilo Seconds',
              'width': 1400,
              'height': 700,
              'chartArea': {top: '5%', right: 0, left: '15%', bottom: 0},
              'isStacked': true,
              'vAxis': {title: 'data', titleTextStyle: {color: 'black',fontName: 'Calibri', fontSize: 18},textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 14}},
              'hAxis': {title: 'date', titleTextStyle: {color: 'black',fontName: 'Calibri', fontSize: 18},textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 14},'slantedText': true,'slantedTextAngle': '90'},
              'legend' : {position: 'right'/*position: 'in'*/, textStyle: {color: 'black', fontSize: 12, fontName: 'Calibri'}},
              'titleTextStyle': {color: 'black',fontName: 'Calibri', fontSize: 16},
              'tooltip' : {/*trigger:'none'*/trigger:'hover',textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 11}},
              'seriesType': 'bars'
            }
            //,'view': {'columns': [0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]}
          });

        new google.visualization.Dashboard(document.getElementById('dashboard')).
        //bind(MonthNbrPicker3, cpuKiloSecondsChart).
        bind(MonthNbrPicker3, [cpuKiloSecondsChart, cpuKiloSecondsTable]).
        // Draw the dashboard
        draw(cpuKiloSeconds);

		var MonthNbrPicker4 = new google.visualization.ControlWrapper({
		    'controlType': 'CategoryFilter',
		    'containerId': 'control4',
		    'options': {
		      'filterColumnLabel': 'MONTHNBR',
		      'ui': {
		        'labelStacking': 'vertical',
                'allowNone': true,
                'allowTyping': true,
                'allowMultiple': true,
                'caption' : 'Choose a value',
                'selectedValuesLayout': 'belowStacked'
		      }
		    }
		});
		
        var millionRowsTable = new google.visualization.ChartWrapper({
          'chartType': 'Table',
          'containerId': 'millionRowsTable',
          'options': {
            'width': '100%',
            'height': '100%'
          }
        });
        
        var millionRowsChart = new google.visualization.ChartWrapper({
            'chartType': 'ColumnChart',
            'containerId': 'millionRows',
            'options': {
              'title' : 'Row Counts in Million',
              'width': 1400,
              'height': 700,
              'chartArea': {top: '5%', right: 0, left: '15%', bottom: 0},
              'isStacked': true,
              'vAxis': {title: 'data', titleTextStyle: {color: 'black',fontName: 'Calibri', fontSize: 18},textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 14}},
              'hAxis': {title: 'date', titleTextStyle: {color: 'black',fontName: 'Calibri', fontSize: 18},textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 14},'slantedText': true,'slantedTextAngle': '90'},
              'legend' : {position: 'right', textStyle: {color: 'black', fontSize: 12, fontName: 'Calibri'}},
              'titleTextStyle': {color: 'black',fontName: 'Calibri', fontSize: 16},
              'tooltip' : {/*trigger:'none'*/trigger:'hover',textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 11}},
              'seriesType': 'bars'
            }
            //,'view': {'columns': [0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]}
          });

        new google.visualization.Dashboard(document.getElementById('dashboard')).
        //bind(MonthNbrPicker4, millionRowsChart).
        bind(MonthNbrPicker4, [millionRowsChart, millionRowsTable]).
        // Draw the dashboard
        draw(millionRows);

		var MonthNbrPicker5 = new google.visualization.ControlWrapper({
		    'controlType': 'CategoryFilter',
		    'containerId': 'control5',
		    'options': {
		      'filterColumnLabel': 'MONTHNBR',
		      'ui': {
		        'labelStacking': 'vertical',
                'allowNone': true,
                'allowTyping': true,
                'allowMultiple': true,
                'caption' : 'Choose a value',
                'selectedValuesLayout': 'belowStacked'
		      }
		    }
		});
		
        var nbrMLOADsTable = new google.visualization.ChartWrapper({
          'chartType': 'Table',
          'containerId': 'nbrMLOADsTable',
          'options': {
            'width': '100%',
            'height': '100%'
          }
        });
        
        var nbrMLOADsChart = new google.visualization.ChartWrapper({
            'chartType': 'ColumnChart',
            'containerId': 'nbrMLOADs',
            'options': {
              'title' : 'Number of Batch Mloads',
              'width': 1400,
              'height': 700,
              'chartArea': {top: '5%', right: 0, left: '15%', bottom: 0},
              'isStacked': true,
              'vAxis': {title: 'data', titleTextStyle: {color: 'black',fontName: 'Calibri', fontSize: 18},textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 14}},
              'hAxis': {title: 'date', titleTextStyle: {color: 'black',fontName: 'Calibri', fontSize: 18},textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 14},'slantedText': true,'slantedTextAngle': '90'},
              'legend' : {position: 'right', textStyle: {color: 'black', fontSize: 12, fontName: 'Calibri'}},
              'titleTextStyle': {color: 'black',fontName: 'Calibri', fontSize: 16},
              'tooltip' : {/*trigger:'none'*/trigger:'hover',textStyle: {color: '#000000',fontName: 'Calibri', fontSize: 11}},
              'seriesType': 'bars'
            }
            //,'view': {'columns': [0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]}
          });

        new google.visualization.Dashboard(document.getElementById('dashboard')).
        //bind(MonthNbrPicker5, nbrMLOADsChart).
        bind(MonthNbrPicker5, [nbrMLOADsChart, nbrMLOADsTable]).
        // Draw the dashboard
        draw(nbrMLOADs);

	    // Add our over/out handlers.
	    //google.visualization.events.addListener(barsVisualization, 'onmouseover', barMouseOver);     
	    //google.visualization.events.addListener(barsVisualization, 'onmouseout', barMouseOut); 		
	}     
</script>   

</head>

<body>

	<div class="wrapper" style="margin-right: 0px; margin-left: 0px;">	

		<a href="<%=request.getContextPath()%>/stats_index.jsp">Home</a>
		
	    <div id="dashboard">
	      <table>
	        <tr style='vertical-align: top'>
	          <td style='width: 400px; font-size: 0.9em;'>
	            <div id="control3" style="display:none;"></div>
	          </td>
	          <td style='width: 1400px'>
	            <div style="float: left;" id="cpuKiloSeconds"></div>
	          </td>
	          <td style='width: 1400px'>
	            <div style="float: right;" id="cpuKiloSecondsTable"></div>
	          </td>
	        </tr>
	      </table>
	      <table>
	        <tr style='vertical-align: top'>
	          <td style='width: 400px; font-size: 0.9em;'>
	            <div id="control5" style="display:none;"></div>
	          </td>
	          <td style='width: 1400px'>
	            <div style="float: left;" id="nbrMLOADs"></div>
	          </td>
	          <td style='width: 1400px'>
	            <div style="float: right;" id="nbrMLOADsTable"></div>
	          </td>
	        </tr>
	      </table>
	      <table>
	        <tr style='vertical-align: top'>
	          <td style='width: 400px; font-size: 0.9em;'>
	            <div id="control1" style="display:none;"></div>
	          </td>
	          <td style='width: 1400px'>
	            <div style="float: left;" id="runTimeMinutes"></div>
	          </td>
	          <td style='width: 1400px'>
	            <div style="float: right;" id="runTimeMinutesTable"></div>
	          </td>
	        </tr>
	      </table>
	      <table>
	        <tr style='vertical-align: top'>
	          <td style='width: 400px; font-size: 0.9em;'>
	            <div id="control4" style="display:none;"></div>
	          </td>
	          <td style='width: 1400px'>
	            <div style="float: left;" id="millionRows"></div>
	          </td>
	          <td style='width: 1400px'>
	            <div style="float: right;" id="millionRowsTable"></div>
	          </td>
	        </tr>
	      </table>
	      <table>
	        <tr style='vertical-align: top'>
	          <td style='width: 400px; font-size: 0.9em;'>
	            <div id="control2" style="display:none;"></div>
	          </td>
	          <td style='width: 1400px'>
	            <div style="float: left;" id="millionIO"></div>
	          </td>
	          <td style='width: 1400px'>
	            <div style="float: right;" id="millionIOTable"></div>
	          </td>
	        </tr>
	      </table>
	    </div>

<%--	
		<table border="1" cellspacing="0" cellpadding="0" style="position:relative; left:24%; top:100px; width: 1000px;">
			<tr class="hd">
				<td >MonthNbr</td>
				<td>UserName</td>	
				<td>Run Time (mins)</td>
				<td>I/O (MM)</td>
				<td>CPU sec (K)</td>
				<td>Row Count (MM)</td>
				<td>Nbr MLOADs</td>
			</tr>
			<%

			int i = 0;
			String styleClass = "d0";
			while (it.hasNext()) {
				MLOADStats s = (MLOADStats) it.next();

				i++;
				if (i%2==0)
					styleClass = "d0";
				else
					styleClass = "d1";
					
				out.print("<tr class='"+ styleClass + "'>");
				out.println("<td>" + s.getMonthNbr() + "</td>");
				out.println("<td>" + s.getUserName() + "</td>");
				out.println("<td>" + s.getRunTimeMinutes() + "</td>");
				out.println("<td>" + s.getMillionIO() + "</td>");
				out.println("<td>" + s.getCpuKiloSeconds() + "</td>");
				out.println("<td>" + s.getMillionRows() + "</td>");
				out.println("<td>" + s.getNbrMLOADs() + "</td>");
				out.print("</tr>");
			}
			%>
		</table>
--%>		
	</div>

</body>
</html>
