package com.ssafy.happyhouse.model;

public class HouseParamDto {
	private String URL;
	private String LAWD_CD;
	private String DEAL_YMD;
	private String numOfRows;
	private String serviceKey;
    
	public String getLAWD_CD() {
		return LAWD_CD;
	}
	public void setLAWD_CD(String lAWD_CD) {
		LAWD_CD = lAWD_CD;
	}
	public String getDEAL_YMD() {
		return DEAL_YMD;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public void setDEAL_YMD(String dEAL_YMD) {
		DEAL_YMD = dEAL_YMD;
	}
	public String getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(String numOfRows) {
		this.numOfRows = numOfRows;
	}
	public String getServiceKey() {
		return serviceKey;
	}
	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}
	@Override
	public String toString() {
		return "HouseParamDto [URL=" + URL + ", LAWD_CD=" + LAWD_CD + ", DEAL_YMD=" + DEAL_YMD + ", numOfRows="
				+ numOfRows + ", serviceKey=" + serviceKey + "]";
	}
    
}
