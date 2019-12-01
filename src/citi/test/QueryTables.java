package citi.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
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

import org.apache.jasper.tagplugins.jstl.core.Out;

import citi.test.beans.Stats;
import citi.test.dao.StatsRetriever;

/**
 * Servlet implementation class QueryTables
 */
public class QueryTables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTables() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("servlet", "QueryTables");
		String db = request.getParameter("db");
		String table = request.getParameter("table");
		String page = request.getParameter("page");
		int pageNumber = Integer.parseInt(page);
		if (pageNumber == 1)
		{
			//List<String> dbNames = new ArrayList<String>();
			List dbNames = new ArrayList();
			for (int i = 0; i <10; i++)
			{
				dbNames.add("DB"+i);
			}
			request.setAttribute("dbNames", dbNames);
			RequestDispatcher view = request.getRequestDispatcher("db_names.jsp");
			view.forward(request, response);
		}
		else if (pageNumber==2) 
		{
			PrintWriter out = response.getWriter();
			out.print("pl" + db);
			//List<String> tableNames = new ArrayList<String>();
			List tableNames = new ArrayList();
			for (int i = 0; i <10; i++)
			{
				tableNames.add("Table :"+i);
			}
			request.setAttribute("tableNames", tableNames);
			RequestDispatcher view = request.getRequestDispatcher("table_names.jsp");
			view.forward(request, response);
		}
		else if (pageNumber==3)
		{
			String dbName = (String) request.getParameter("dbName");
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			//List<Stats> list = new ArrayList<Stats>();
			List list = new ArrayList();
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, -1); 			
			Date d = new Date();
			//calendar to date
			//cal.getTime()
			//calendar to date to long
			//cal.getTime().getTime()
			d.setTime(cal.getTime().getTime());
			
			for (long i = 0; i < 100; i++)
			{
				Stats stats = new Stats();
				stats.setLogDate(sdf.format(d));
				d.setTime(d.getTime() + ((long)(86400000)));
				//d.setTime(System.currentTimeMillis() + ((long)(i*86400000)));
				//1000 miliseconds = 1 seconds, 60 seconds = 1 minute, 60 minutes = 1 hour, 24 hour = 1 day
				//(1000 miliseconds * 60 seconds * 60 minutes * 24 hour) = 1 day
				//d.setTime(System.currentTimeMillis() + ((long)(i * (1000 * 60 * 60 * 24) )));
				stats.setSumIO("" + (float) (10 * Math.random()));
				stats.setRowCount("" + (float) (10 * Math.random()));
				stats.setCpuSkw("" + (float) (10 * Math.random()));
				stats.setIoSkw("" + (float) (10 * Math.random()));
				stats.setPji("" + (float) (10 * Math.random()));
				stats.setUii("" + (float) (10 * Math.random()));
				stats.setSumCPU("" + (float) (10 * Math.random()));
				stats.setQueryResponseTime("" + (float) (10 * Math.random()));
				list.add(stats);
			}
			request.setAttribute("dbStats", list);
			RequestDispatcher view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
		
		}
	}

    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("...... Query Tables servlet");
		request.setAttribute("servlet", "QueryTables");
		String db = request.getParameter("db");
		String table = request.getParameter("table");
		StatsRetriever dbRetiever = new StatsRetriever();
		ResultSet rs = null;
		List result = null;
		RequestDispatcher view = null;
		
		ServletContext context = getServletContext();
		Properties props = new Properties();
		props.load(context.getResourceAsStream("/WEB-INF/db_config.properties"));
		dbRetiever.setProperties(props);
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		switch (page){
		case 1:
			if (db == null || db == "" && table == null || table == "") 
			{// get db names
				result = dbRetiever.queryDB();
				Collections.sort(result);
				request.setAttribute("dbNames", result);
				view = request.getRequestDispatcher("db_names.jsp");
				HttpSession session = request.getSession();
				
			} 
			break;
		case 2:
			if (db != null && db != "" ) 
			{// get table names
				result = dbRetiever.queryTables(db);
				Collections.sort(result);
				request.setAttribute("tableNames", result);
				view = request.getRequestDispatcher("table_names.jsp");
			}
			break;
		case 3: 
			if (table != null && table != "") 
			{// get table stats
				result = dbRetiever.queryStats(table);
				request.setAttribute("dbStats", result);
				view = request.getRequestDispatcher("result.jsp");
			}
			break;
		}
		view.forward(request, response);
	}
}
