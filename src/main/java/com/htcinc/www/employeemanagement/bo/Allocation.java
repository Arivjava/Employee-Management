/**
 * 
 */
package com.htcinc.www.employeemanagement.bo;

import java.sql.Date;

/**
 * @author ARIVA
 *
 */
public class Allocation {

	private int empId ;
	private int projId ;
	private int roleId ;
	private Date fromDate ;
	private Date toDate ;
	private int amt; 
	
	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public int getProjId() {
		return projId;
	}


	public void setProjId(int projId) {
		this.projId = projId;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}




	public int getAmt() {
		return amt;
	}


	public void setAmt(int amt) {
		this.amt = amt;
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


	public Allocation(int empId, int projId, int roleId, Date fromDate, Date toDate, int amt) {
		super();
		this.empId = empId;
		this.projId = projId;
		this.roleId = roleId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.amt = amt;
	}


	@Override
	public String toString() {
		return "Allocation [emp_id=" + empId + ", projId=" + projId + ", roleId=" + roleId + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}


	/**
	 * 
	 */
	public Allocation() {
		// TODO Auto-generated constructor stub
	}

}
