package com.dummy.controller.session;

public class UserInfoAzure {
	String displayName;
	String employeeId;
	String onPremisesSamAccountName;
	
	public UserInfoAzure() {
	}
	
	public UserInfoAzure(String displayName, String employeeId, String onPremisesSamAccountName) {
		super();
		this.displayName = displayName;
		this.employeeId = employeeId;
		this.onPremisesSamAccountName = onPremisesSamAccountName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getOnPremisesSamAccountName() {
		return onPremisesSamAccountName;
	}
	public void setOnPremisesSamAccountName(String onPremisesSamAccountName) {
		this.onPremisesSamAccountName = onPremisesSamAccountName;
	}
}
