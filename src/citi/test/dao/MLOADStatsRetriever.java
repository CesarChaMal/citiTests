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

import citi.test.beans.MLOADStats;

public class MLOADStatsRetriever {

	private Properties props;
	
	public MLOADStatsRetriever() {
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
	
	public List queryRunTimeMinutes() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List l = new ArrayList();
		try {
			conn = getConnection();
			String query = "sel * from p_bcd_ut1.work_perf_graph1 where metric='RunTimeM' order by MonthNbr";

			pstmt = conn.prepareStatement(query); // create a statement
			rs = pstmt.executeQuery();
			// extract data from the ResultSet
			
			while (rs.next()) {
				MLOADStats stats = new MLOADStats();
				stats.setMonthNbr(String.valueOf(rs.getObject("MonthNbr")));
				stats.setBicoll_p(String.valueOf(rs.getObject("BICOLL_P")));
				stats.setCbnacom_prod(String.valueOf(rs.getObject("CBNACOM_PROD")));
				stats.setCbnangds(String.valueOf(rs.getObject("CBNANGDS")));
				stats.setCmrprod(String.valueOf(rs.getObject("CMRPROD")));
				stats.setDmr_etldbusrp(String.valueOf(rs.getObject("DMR_ETLDBUSRP")));
				stats.setDwimpid(String.valueOf(rs.getObject("DWIMPID")));
				stats.setEsprod(String.valueOf(rs.getObject("ESPROD")));
				stats.setNaitprod(String.valueOf(rs.getObject("NAITPROD")));
				stats.setOprprod(String.valueOf(rs.getObject("OPRPROD")));
				stats.setProdrun(String.valueOf(rs.getObject("PRODRUN")));
				stats.setRelprod(String.valueOf(rs.getObject("RELPROD")));
				stats.setRplprod(String.valueOf(rs.getObject("RPLPROD")));
				stats.setSymprod(String.valueOf(rs.getObject("SYMPROD")));
				stats.setTagadm(String.valueOf(rs.getObject("TAGADM")));
				//stats.setType(citi.test.beans.MLOADStats.Type.RunTimeMinutes);
				stats.setType(citi.test.beans.MLOADStats.RunTimeMinutes);
				
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
	
	public List queryMillionIO() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List l = new ArrayList();
		try {
			conn = getConnection();
			String query = "sel * from p_bcd_ut1.work_perf_graph1 where metric='IOMM' order by MonthNbr";

			pstmt = conn.prepareStatement(query); // create a statement
			rs = pstmt.executeQuery();
			// extract data from the ResultSet
			
			while (rs.next()) {
				MLOADStats stats = new MLOADStats();
				stats.setMonthNbr(String.valueOf(rs.getObject("MonthNbr")));
				stats.setBicoll_p(String.valueOf(rs.getObject("BICOLL_P")));
				stats.setCbnacom_prod(String.valueOf(rs.getObject("CBNACOM_PROD")));
				stats.setCbnangds(String.valueOf(rs.getObject("CBNANGDS")));
				stats.setCmrprod(String.valueOf(rs.getObject("CMRPROD")));
				stats.setDmr_etldbusrp(String.valueOf(rs.getObject("DMR_ETLDBUSRP")));
				stats.setDwimpid(String.valueOf(rs.getObject("DWIMPID")));
				stats.setEsprod(String.valueOf(rs.getObject("ESPROD")));
				stats.setNaitprod(String.valueOf(rs.getObject("NAITPROD")));
				stats.setOprprod(String.valueOf(rs.getObject("OPRPROD")));
				stats.setProdrun(String.valueOf(rs.getObject("PRODRUN")));
				stats.setRelprod(String.valueOf(rs.getObject("RELPROD")));
				stats.setRplprod(String.valueOf(rs.getObject("RPLPROD")));
				stats.setSymprod(String.valueOf(rs.getObject("SYMPROD")));
				stats.setTagadm(String.valueOf(rs.getObject("TAGADM")));
				//stats.setType(citi.test.beans.MLOADStats.Type.MillionIO);
				stats.setType(citi.test.beans.MLOADStats.MillionIO);

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
	
	public List queryCPUKiloSeconds() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List l = new ArrayList();
		try {
			conn = getConnection();
			String query = "sel * from p_bcd_ut1.work_perf_graph1 where metric='CPUsecK' order by MonthNbr";

			pstmt = conn.prepareStatement(query); // create a statement
			rs = pstmt.executeQuery();
			// extract data from the ResultSet
			
			while (rs.next()) {
				MLOADStats stats = new MLOADStats();
				stats.setMonthNbr(String.valueOf(rs.getObject("MonthNbr")));
				stats.setBicoll_p(String.valueOf(rs.getObject("BICOLL_P")));
				stats.setCbnacom_prod(String.valueOf(rs.getObject("CBNACOM_PROD")));
				stats.setCbnangds(String.valueOf(rs.getObject("CBNANGDS")));
				stats.setCmrprod(String.valueOf(rs.getObject("CMRPROD")));
				stats.setDmr_etldbusrp(String.valueOf(rs.getObject("DMR_ETLDBUSRP")));
				stats.setDwimpid(String.valueOf(rs.getObject("DWIMPID")));
				stats.setEsprod(String.valueOf(rs.getObject("ESPROD")));
				stats.setNaitprod(String.valueOf(rs.getObject("NAITPROD")));
				stats.setOprprod(String.valueOf(rs.getObject("OPRPROD")));
				stats.setProdrun(String.valueOf(rs.getObject("PRODRUN")));
				stats.setRelprod(String.valueOf(rs.getObject("RELPROD")));
				stats.setRplprod(String.valueOf(rs.getObject("RPLPROD")));
				stats.setSymprod(String.valueOf(rs.getObject("SYMPROD")));
				stats.setTagadm(String.valueOf(rs.getObject("TAGADM")));
				//stats.setType(citi.test.beans.MLOADStats.Type.CPUKiloSeconds);
				stats.setType(citi.test.beans.MLOADStats.CPUKiloSeconds);
				
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
	
	public List queryMillionRows() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List l = new ArrayList();
		try {
			conn = getConnection();
			String query = "sel * from p_bcd_ut1.work_perf_graph1 where metric='RowCount' order by MonthNbr";

			pstmt = conn.prepareStatement(query); // create a statement
			rs = pstmt.executeQuery();
			// extract data from the ResultSet
			
			while (rs.next()) {
				MLOADStats stats = new MLOADStats();
				stats.setMonthNbr(String.valueOf(rs.getObject("MonthNbr")));
				stats.setBicoll_p(String.valueOf(rs.getObject("BICOLL_P")));
				stats.setCbnacom_prod(String.valueOf(rs.getObject("CBNACOM_PROD")));
				stats.setCbnangds(String.valueOf(rs.getObject("CBNANGDS")));
				stats.setCmrprod(String.valueOf(rs.getObject("CMRPROD")));
				stats.setDmr_etldbusrp(String.valueOf(rs.getObject("DMR_ETLDBUSRP")));
				stats.setDwimpid(String.valueOf(rs.getObject("DWIMPID")));
				stats.setEsprod(String.valueOf(rs.getObject("ESPROD")));
				stats.setNaitprod(String.valueOf(rs.getObject("NAITPROD")));
				stats.setOprprod(String.valueOf(rs.getObject("OPRPROD")));
				stats.setProdrun(String.valueOf(rs.getObject("PRODRUN")));
				stats.setRelprod(String.valueOf(rs.getObject("RELPROD")));
				stats.setRplprod(String.valueOf(rs.getObject("RPLPROD")));
				stats.setSymprod(String.valueOf(rs.getObject("SYMPROD")));
				stats.setTagadm(String.valueOf(rs.getObject("TAGADM")));
				//stats.setType(citi.test.beans.MLOADStats.Type.MillionRows);
				stats.setType(citi.test.beans.MLOADStats.MillionRows);

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

	public List queryNbrMLOADs() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List l = new ArrayList();
		try {
			conn = getConnection();
			String query = "sel * from p_bcd_ut1.work_perf_graph1 where metric='NbrMLOAD' order by MonthNbr";

			pstmt = conn.prepareStatement(query); // create a statement
			rs = pstmt.executeQuery();
			// extract data from the ResultSet
			
			while (rs.next()) {
				MLOADStats stats = new MLOADStats();
				stats.setMonthNbr(String.valueOf(rs.getObject("MonthNbr")));
				stats.setBicoll_p(String.valueOf(rs.getObject("BICOLL_P")));
				stats.setCbnacom_prod(String.valueOf(rs.getObject("CBNACOM_PROD")));
				stats.setCbnangds(String.valueOf(rs.getObject("CBNANGDS")));
				stats.setCmrprod(String.valueOf(rs.getObject("CMRPROD")));
				stats.setDmr_etldbusrp(String.valueOf(rs.getObject("DMR_ETLDBUSRP")));
				stats.setDwimpid(String.valueOf(rs.getObject("DWIMPID")));
				stats.setEsprod(String.valueOf(rs.getObject("ESPROD")));
				stats.setNaitprod(String.valueOf(rs.getObject("NAITPROD")));
				stats.setOprprod(String.valueOf(rs.getObject("OPRPROD")));
				stats.setProdrun(String.valueOf(rs.getObject("PRODRUN")));
				stats.setRelprod(String.valueOf(rs.getObject("RELPROD")));
				stats.setRplprod(String.valueOf(rs.getObject("RPLPROD")));
				stats.setSymprod(String.valueOf(rs.getObject("SYMPROD")));
				stats.setTagadm(String.valueOf(rs.getObject("TAGADM")));
				//stats.setType(citi.test.beans.MLOADStats.Type.NbrMLOADs);
				stats.setType(citi.test.beans.MLOADStats.NbrMLOADs);

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

	public void setProperties(Properties p){
		props = p;
	}
}
