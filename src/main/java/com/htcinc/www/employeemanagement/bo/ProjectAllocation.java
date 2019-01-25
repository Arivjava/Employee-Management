package com.htcinc.www.employeemanagement.bo;

import java.sql.Date;

public class ProjectAllocation {

	private String clientName  ;
	private String projectName ;
	private Date fromDate;
	private Date toDate;
	private String roleTitle ;
	
	
	
	public String getClientName() {
		return clientName;
	}



	public void setClientName(String clientName) {
		this.clientName = clientName;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public Date getFromDate() {
		return fromDate;
	}



	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}



	public Date getToDate() {
		return toDate;
	}



	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}



	public String getRoleTitle() {
		return roleTitle;
	}



	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}



	public ProjectAllocation(String clientName, String projectName, Date fromDate, Date toDate, String roleTitle) {
		super();
		this.clientName = clientName;
		this.projectName = projectName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.roleTitle = roleTitle;
	}



	@Override
	public String toString() {
		return "ProjectAllocation [clientName=" + clientName + ", projectName=" + projectName + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", roleTitle=" + roleTitle + "]";
	}



	public ProjectAllocation() {
		// TODO Auto-generated constructor stub
	}

}
