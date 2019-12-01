package citi.test.beans;

public class MLOADStats {
	private String monthNbr;
	/*
	private String userName;
	private String runTimeMinutes;
	private String millionIO;
	private String cpuKiloSeconds;
	private String millionRows;
	private String NbrMLOADs;
	*/
	private String bicoll_p;
	private String cbnacom_prod;
	private String cbnangds;
	private String cmrprod;
	private String dmr_etldbusrp;
	private String dwimpid;
	private String esprod;
	private String naitprod;
	private String oprprod;
	private String prodrun;
	private String relprod;
	private String rplprod;
	private String symprod;
	private String tagadm;
	private String type;
	public static String RunTimeMinutes = "RunTimeMinutes";
	public static String MillionIO = "MillionIO";
	public static String CPUKiloSeconds = "CPUKiloSeconds";
	public static String MillionRows = "MillionRows";
	public static String NbrMLOADs = "NbrMLOADs";
/*	
	private Type type;

	public enum Type
	{
		RunTimeMinutes, MillionIO, CPUKiloSeconds, MillionRows, NbrMLOADs, NOVALUE;

	    public static Type toType(String str)
	    {
	        try {
	            return valueOf(str);
	        } 
	        catch (IllegalArgumentException ex) {
	            return NOVALUE;
	        }
	    }   
	}
*/	
	public String getMonthNbr() {
		return monthNbr;
	}
	public void setMonthNbr(String monthNbr) {
		this.monthNbr = monthNbr;
	}
	public String getBicoll_p() {
		return bicoll_p;
	}
	public void setBicoll_p(String bicoll_p) {
		this.bicoll_p = bicoll_p;
	}
	public String getCbnacom_prod() {
		return cbnacom_prod;
	}
	public void setCbnacom_prod(String cbnacom_prod) {
		this.cbnacom_prod = cbnacom_prod;
	}
	public String getCbnangds() {
		return cbnangds;
	}
	public void setCbnangds(String cbnangds) {
		this.cbnangds = cbnangds;
	}
	public String getCmrprod() {
		return cmrprod;
	}
	public void setCmrprod(String cmrprod) {
		this.cmrprod = cmrprod;
	}
	public String getDmr_etldbusrp() {
		return dmr_etldbusrp;
	}
	public void setDmr_etldbusrp(String dmr_etldbusrp) {
		this.dmr_etldbusrp = dmr_etldbusrp;
	}
	public String getDwimpid() {
		return dwimpid;
	}
	public void setDwimpid(String dwimpid) {
		this.dwimpid = dwimpid;
	}
	public String getEsprod() {
		return esprod;
	}
	public void setEsprod(String esprod) {
		this.esprod = esprod;
	}
	public String getNaitprod() {
		return naitprod;
	}
	public void setNaitprod(String naitprod) {
		this.naitprod = naitprod;
	}
	public String getOprprod() {
		return oprprod;
	}
	public void setOprprod(String oprprod) {
		this.oprprod = oprprod;
	}
	public String getProdrun() {
		return prodrun;
	}
	public void setProdrun(String prodrun) {
		this.prodrun = prodrun;
	}
	public String getRelprod() {
		return relprod;
	}
	public void setRelprod(String relprod) {
		this.relprod = relprod;
	}
	public String getRplprod() {
		return rplprod;
	}
	public void setRplprod(String rplprod) {
		this.rplprod = rplprod;
	}
	public String getSymprod() {
		return symprod;
	}
	public void setSymprod(String symprod) {
		this.symprod = symprod;
	}
	public String getTagadm() {
		return tagadm;
	}
	public void setTagadm(String tagadm) {
		this.tagadm = tagadm;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

