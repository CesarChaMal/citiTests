package citi.test.dao;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import citi.test.beans.Stats;

public class StatsRetriever {

	private Properties props;
	
	public StatsRetriever() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection() throws Exception {
		
		String driver = props.getProperty("prop1");
		String username = props.getProperty("prop2");
		String password = props.getProperty("prop3");
		String url = props.getProperty("prop4");
		
//		System.out.println("................ driver "+driver+" url "+url+" username "+username+" password "+password);
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
//		System.out.println("................ CONNECTED "+conn);
		return conn;
	}
	

	public List queryDB() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List l = new ArrayList();
		try 
		{
			conn = getConnection();
			String query = "select distinct databasename from dbc.tables";
			System.out.println("...... trying to query");
			pstmt = conn.prepareStatement(query); // create a statement
//			pstmt.setInt(1, 1001); // set input parameter
			rs = pstmt.executeQuery();
			// extract data from the ResultSet
			System.out.println("..... query executed "+rs);
			System.out.println("...... "+rs.getString("databasename"));
//			System.out.println("......1 "+rs.getObject(1)+" "+rs.getObject(1).getClass());
			
			int i=0;
			while (rs.next()) {
//				System.out.println(i++);
				l.add(rs.getString("databasename"));
				//l.add(rs.getString(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return l;
		}

	}

	public List queryTables(String db) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List l = new ArrayList();
		try {
			conn = getConnection();
			String query = "select distinct tablename from dbc.tables where databasename like '%"
					+ db + "%'";

			pstmt = conn.prepareStatement(query); // create a statement
//			pstmt.setInt(1, 1001); // set input parameter
			rs = pstmt.executeQuery();

			// extract data from the ResultSet
			while (rs.next()) {
				l.add(rs.getString("tablename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return l;
		}

	}
	public List queryStats(String table) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List l = new ArrayList();
		try {
			conn = getConnection();
			String query = "select * from p_bcd_ut1.work_stats_0411 where tablename = '" + table +"' order by cast(logdate as date format 'mm/dd/yyyy') ASC";
			//String query = "select * from p_bcd_ut1.work_stats_0411"; 

			pstmt = conn.prepareStatement(query); // create a statement
		//pstmt.setInt(1, 1001); // set input parameter
			rs = pstmt.executeQuery();
			// extract data from the ResultSet
			while (rs.next()) {
				Stats stats = new Stats();
				stats.setLogDate(String.valueOf(rs.getObject("logdate")));
				stats.setQueryResponseTime(String.valueOf(rs.getObject("QryRespTime")));
				stats.setSumCPU(String.valueOf(rs.getObject("SumCPU")));
				stats.setCpuSkw(String.valueOf(rs.getObject("CPUSKW")));
				stats.setIoSkw(String.valueOf(rs.getObject("IOSKW")));
				stats.setPji(String.valueOf(rs.getObject("PJI")));
				stats.setUii(String.valueOf(rs.getObject("UII")));
				stats.setRowCount(String.valueOf(rs.getObject("rowct")));
				stats.setSumIO(String.valueOf(rs.getObject("SumIO")));
				// stats.setImpactCpu( String.valueOf( rs.getObject(i) ) );
				l.add(stats);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return l;
		}
	}
	
//	public List queryStatsold(String table) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List l = new ArrayList();
//		try {
//			conn = getConnection();
//			String query = "select "
//			+ " TRIM(TRAILING ';' FROM SUBSTR(QueryText,12,60)) AS TableName,"
//			+ " logdate, sum(EXTRACT (SECOND "
//			+ " FROM FirstRespTime) + (EXTRACT (MINUTE "
//			+ " FROM FirstRespTime) * 60 ) + (EXTRACT (HOUR "
//			+ " FROM FirstRespTime) *60*60 ) + (86400 * (CAST ( FirstRespTime AS DATE) - CAST ( starttime AS DATE) ) ) - (EXTRACT (SECOND "
//			+ " FROM starttime) + (EXTRACT (MINUTE "
//			+ " FROM starttime) * 60 ) + (EXTRACT (HOUR "
//			+ " FROM starttime) *60*60 ) )) AS QryRespTime "
//			+ " , sum(a.AMPCPUTIME) AS SumCPU, sum( "
//			+ " CASE WHEN AMPCPUTime < 1 "
//			+ " OR (AMPCPUTime / (HASHAMP()+1)) =0 THEN 0 "
//			+ " ELSE MaxAMPCPUTime/(AMPCPUTime / (HASHAMP()+1))"
//			+ " END (DEC(8,2))) AS CPUSKW, sum("
//			+ " CASE WHEN AMPCPUTime < 1"
//			+ " OR (TotalIOCount / (HASHAMP()+1)) =0 THEN 0"
//			+ " ELSE MaxAmpIO/(TotalIOCount / (HASHAMP()+1))"
//			+ " END (DEC(8,2))) AS IOSKW, sum( "
//			+ " CASE WHEN AMPCPUTime < 1 "
//			+ " OR TotalIOCount = 0 THEN 0 ELSE (a.AMPCPUTime"
//			+ " *1000)/a.TotalIOCount END ) AS PJI, sum("
//			+ " CASE WHEN AMPCPUTime < 1"
//			+ " OR AMPCPUTime = 0 THEN 0 ELSE"
//			+ " a.TotalIOCount/(a.AMPCPUTime *1000)"
//			+ " END ) AS UII,"
//			+ " sum(coalesce(utilityrowcount,0)) as rowct,"
//			+ " sum(a.TotalIOCount) AS SumIO"
//			+ " from PDCRINFO.DBQLogTbl a"
//			+ " where a.logdate >= '2011-01-01'"
//			+ " and a.logdate <= '2011-07-05'"
//			+ " and trim(a.statementType)='Execute Mload'"
//			+ " and querytext like '%" + table + "%'" + "group by 1,2 "; 
//
//
//
//
//			pstmt = conn.prepareStatement(query); // create a statement
//		//pstmt.setInt(1, 1001); // set input parameter
//			rs = pstmt.executeQuery();
//			// extract data from the ResultSet
//			while (rs.next()) {
//				Stats stats = new Stats();
//				stats.setLogDate(String.valueOf(rs.getObject("logdate")));
//				stats.setQueryResponseTime(String.valueOf(rs.getObject("QryRespTime")));
//				stats.setSumCPU(String.valueOf(rs.getObject("SumCPU")));
//				stats.setCpuSkw(String.valueOf(rs.getObject("CPUSKW")));
//				stats.setIoSkw(String.valueOf(rs.getObject("IOSKW")));
//				stats.setPji(String.valueOf(rs.getObject("PJI")));
//				stats.setUii(String.valueOf(rs.getObject("UII")));
//				stats.setRowCount(String.valueOf(rs.getObject("rowct")));
//				stats.setSumIO(String.valueOf(rs.getObject("SumIO")));
//				// stats.setImpactCpu( String.valueOf( rs.getObject(i) ) );
//				l.add(stats);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//				pstmt.close();
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return l;
//		}
//	}
	
	public void setProperties(Properties p){
		props = p;
	}
}
