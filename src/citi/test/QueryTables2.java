package citi.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import citi.test.beans.MLOADStats;
import citi.test.dao.MLOADStatsRetriever;

/**
 * Servlet implementation class QueryTables2
 */
public class QueryTables2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTables2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("servlet", "QueryTables2");
		String page = request.getParameter("page");
		int pageNumber = Integer.parseInt(page);

		if (pageNumber == 1)
		{
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			List result = new ArrayList(); 
			List runTimeMinutes = new ArrayList(); 
			List millionIO = new ArrayList(); 
			List cpuKiloSeconds = new ArrayList(); 
			List millionRows = new ArrayList(); 
			List nbrMLOADs = new ArrayList();
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -5); 			
			Date d = new Date();
			//calendar to date
			//cal.getTime()
			//calendar to date to long
			//cal.getTime().getTime()
			d.setTime(cal.getTime().getTime());
			
			//runTimeMinutes
			for (long i = 0; i < 20; i++)
			{
				MLOADStats stats = new MLOADStats();
				stats.setMonthNbr(sdf.format(d));
				d.setTime(d.getTime() + ((long)(86400000)));
				//d.setTime(d.getTime());
				//d.setTime(System.currentTimeMillis() + ((long)(i*86400000)));
				//1000 miliseconds = 1 seconds, 60 seconds = 1 minute, 60 minutes = 1 hour, 24 hour = 1 day
				//(1000 miliseconds * 60 seconds * 60 minutes * 24 hour) = 1 day
				//d.setTime(System.currentTimeMillis() + ((long)(i * (1000 * 60 * 60 * 24) )));

				//stats.setUserName("userName" + i);
				
				stats.setBicoll_p("" + (float) (10 * Math.random()));
				stats.setCbnacom_prod("" + (float) (10 * Math.random()));
				stats.setCbnangds("" + (float) (10 * Math.random()));
				stats.setCmrprod("" + (float) (10 * Math.random()));
				stats.setDmr_etldbusrp("" + (float) (10 * Math.random()));
				stats.setDwimpid("" + (float) (10 * Math.random()));
				stats.setEsprod("" + (float) (10 * Math.random()));
				stats.setNaitprod("" + (float) (10 * Math.random()));
				stats.setOprprod("" + (float) (10 * Math.random()));
				stats.setProdrun("" + (float) (10 * Math.random()));
				stats.setRelprod("" + (float) (10 * Math.random()));
				stats.setRplprod("" + (float) (10 * Math.random()));
				stats.setSymprod("" + (float) (10 * Math.random()));
				stats.setTagadm("" + (float) (10 * Math.random()));
				//stats.setType(citi.test.beans.MLOADStats.Type.RunTimeMinutes);
				stats.setType(citi.test.beans.MLOADStats.RunTimeMinutes);
				runTimeMinutes.add(stats);
			}
			
			//millionIO
			for (long i = 0; i < 25; i++)
			{
				MLOADStats stats = new MLOADStats();
				stats.setMonthNbr(sdf.format(d));
				d.setTime(d.getTime() + ((long)(86400000)));
				//d.setTime(d.getTime());
				//d.setTime(System.currentTimeMillis() + ((long)(i*86400000)));
				//1000 miliseconds = 1 seconds, 60 seconds = 1 minute, 60 minutes = 1 hour, 24 hour = 1 day
				//(1000 miliseconds * 60 seconds * 60 minutes * 24 hour) = 1 day
				//d.setTime(System.currentTimeMillis() + ((long)(i * (1000 * 60 * 60 * 24) )));

				//stats.setUserName("userName" + i);
				
				stats.setBicoll_p("" + (float) (10 * Math.random()));
				stats.setCbnacom_prod("" + (float) (10 * Math.random()));
				stats.setCbnangds("" + (float) (10 * Math.random()));
				stats.setCmrprod("" + (float) (10 * Math.random()));
				stats.setDmr_etldbusrp("" + (float) (10 * Math.random()));
				stats.setDwimpid("" + (float) (10 * Math.random()));
				stats.setEsprod("" + (float) (10 * Math.random()));
				stats.setNaitprod("" + (float) (10 * Math.random()));
				stats.setOprprod("" + (float) (10 * Math.random()));
				stats.setProdrun("" + (float) (10 * Math.random()));
				stats.setRelprod("" + (float) (10 * Math.random()));
				stats.setRplprod("" + (float) (10 * Math.random()));
				stats.setSymprod("" + (float) (10 * Math.random()));
				stats.setTagadm("" + (float) (10 * Math.random()));
				//stats.setType(citi.test.beans.MLOADStats.Type.MillionIO);
				stats.setType(citi.test.beans.MLOADStats.MillionIO);
				
				millionIO.add(stats);
			}

			//cpuKiloSeconds
			for (long i = 0; i < 15; i++)
			{
				MLOADStats stats = new MLOADStats();
				stats.setMonthNbr(sdf.format(d));
				d.setTime(d.getTime() + ((long)(86400000)));
				//d.setTime(d.getTime());
				//d.setTime(System.currentTimeMillis() + ((long)(i*86400000)));
				//1000 miliseconds = 1 seconds, 60 seconds = 1 minute, 60 minutes = 1 hour, 24 hour = 1 day
				//(1000 miliseconds * 60 seconds * 60 minutes * 24 hour) = 1 day
				//d.setTime(System.currentTimeMillis() + ((long)(i * (1000 * 60 * 60 * 24) )));

				//stats.setUserName("userName" + i);
				
				stats.setBicoll_p("" + (float) (10 * Math.random()));
				stats.setCbnacom_prod("" + (float) (10 * Math.random()));
				stats.setCbnangds("" + (float) (10 * Math.random()));
				stats.setCmrprod("" + (float) (10 * Math.random()));
				stats.setDmr_etldbusrp("" + (float) (10 * Math.random()));
				stats.setDwimpid("" + (float) (10 * Math.random()));
				stats.setEsprod("" + (float) (10 * Math.random()));
				stats.setNaitprod("" + (float) (10 * Math.random()));
				stats.setOprprod("" + (float) (10 * Math.random()));
				stats.setProdrun("" + (float) (10 * Math.random()));
				stats.setRelprod("" + (float) (10 * Math.random()));
				stats.setRplprod("" + (float) (10 * Math.random()));
				stats.setSymprod("" + (float) (10 * Math.random()));
				stats.setTagadm("" + (float) (10 * Math.random()));
				//stats.setType(citi.test.beans.MLOADStats.Type.CPUKiloSeconds);
				stats.setType(citi.test.beans.MLOADStats.CPUKiloSeconds);
				
				cpuKiloSeconds.add(stats);
			}
			
			//millionRows
			for (long i = 0; i < 15; i++)
			{
				MLOADStats stats = new MLOADStats();
				stats.setMonthNbr(sdf.format(d));
				d.setTime(d.getTime() + ((long)(86400000)));
				//d.setTime(d.getTime());
				//d.setTime(System.currentTimeMillis() + ((long)(i*86400000)));
				//1000 miliseconds = 1 seconds, 60 seconds = 1 minute, 60 minutes = 1 hour, 24 hour = 1 day
				//(1000 miliseconds * 60 seconds * 60 minutes * 24 hour) = 1 day
				//d.setTime(System.currentTimeMillis() + ((long)(i * (1000 * 60 * 60 * 24) )));

				//stats.setUserName("userName" + i);
				
				stats.setBicoll_p("" + (float) (10 * Math.random()));
				stats.setCbnacom_prod("" + (float) (10 * Math.random()));
				stats.setCbnangds("" + (float) (10 * Math.random()));
				stats.setCmrprod("" + (float) (10 * Math.random()));
				stats.setDmr_etldbusrp("" + (float) (10 * Math.random()));
				stats.setDwimpid("" + (float) (10 * Math.random()));
				stats.setEsprod("" + (float) (10 * Math.random()));
				stats.setNaitprod("" + (float) (10 * Math.random()));
				stats.setOprprod("" + (float) (10 * Math.random()));
				stats.setProdrun("" + (float) (10 * Math.random()));
				stats.setRelprod("" + (float) (10 * Math.random()));
				stats.setRplprod("" + (float) (10 * Math.random()));
				stats.setSymprod("" + (float) (10 * Math.random()));
				stats.setTagadm("" + (float) (10 * Math.random()));
				//stats.setType(citi.test.beans.MLOADStats.Type.MillionRows);
				stats.setType(citi.test.beans.MLOADStats.MillionRows);
				
				millionRows.add(stats);
			}

			//nbrMLOADs
			for (long i = 0; i < 25; i++)
			{
				MLOADStats stats = new MLOADStats();
				stats.setMonthNbr(sdf.format(d));
				d.setTime(d.getTime() + ((long)(86400000)));
				//d.setTime(d.getTime());
				//d.setTime(System.currentTimeMillis() + ((long)(i*86400000)));
				//1000 miliseconds = 1 seconds, 60 seconds = 1 minute, 60 minutes = 1 hour, 24 hour = 1 day
				//(1000 miliseconds * 60 seconds * 60 minutes * 24 hour) = 1 day
				//d.setTime(System.currentTimeMillis() + ((long)(i * (1000 * 60 * 60 * 24) )));

				//stats.setUserName("userName" + i);
				
				stats.setBicoll_p("" + (float) (10 * Math.random()));
				stats.setCbnacom_prod("" + (float) (10 * Math.random()));
				stats.setCbnangds("" + (float) (10 * Math.random()));
				stats.setCmrprod("" + (float) (10 * Math.random()));
				stats.setDmr_etldbusrp("" + (float) (10 * Math.random()));
				stats.setDwimpid("" + (float) (10 * Math.random()));
				stats.setEsprod("" + (float) (10 * Math.random()));
				stats.setNaitprod("" + (float) (10 * Math.random()));
				stats.setOprprod("" + (float) (10 * Math.random()));
				stats.setProdrun("" + (float) (10 * Math.random()));
				stats.setRelprod("" + (float) (10 * Math.random()));
				stats.setRplprod("" + (float) (10 * Math.random()));
				stats.setSymprod("" + (float) (10 * Math.random()));
				stats.setTagadm("" + (float) (10 * Math.random()));
				//stats.setType(citi.test.beans.MLOADStats.Type.NbrMLOADs);
				stats.setType(citi.test.beans.MLOADStats.NbrMLOADs);
				
				nbrMLOADs.add(stats);
			}
			
			result.add(0,runTimeMinutes);
			result.add(1,millionIO);
			result.add(2,cpuKiloSeconds);
			result.add(3,millionRows);
			result.add(4,nbrMLOADs);
			
			request.setAttribute("dbStats", result);
			RequestDispatcher view = request.getRequestDispatcher("result2.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("...... Query Tables2 servlet");
		request.setAttribute("servlet", "QueryTables2");
		MLOADStatsRetriever dbRetiever = new MLOADStatsRetriever();
		System.out.println("...... dbRetriever " + dbRetiever);
		List result = new ArrayList(); 
		List runTimeMinutes = null; 
		List millionIO = null; 
		List cpuKiloSeconds = null; 
		List millionRows = null; 
		List nbrMLOADs = null;
		RequestDispatcher view = null;
		
		ServletContext context = getServletContext();
		Properties props = new Properties();
		props.load(context.getResourceAsStream("/WEB-INF/db_config.properties"));
		dbRetiever.setProperties(props);
		
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println("...... page " + page);
		
		switch (page){
		case 1:
			runTimeMinutes = dbRetiever.queryRunTimeMinutes(); 
			millionIO = dbRetiever.queryMillionIO(); 
			cpuKiloSeconds = dbRetiever.queryCPUKiloSeconds(); 
			millionRows = dbRetiever.queryMillionRows(); 
			nbrMLOADs = dbRetiever.queryNbrMLOADs();
			result.add(0,runTimeMinutes);
			result.add(1,millionIO);
			result.add(2,cpuKiloSeconds);
			result.add(3,millionRows);
			result.add(4,nbrMLOADs);
			
			request.setAttribute("dbStats", result);
			System.out.println("...... result " + result);
			view = request.getRequestDispatcher("result2.jsp");
			break;
		}
		view.forward(request, response);
	}

}
