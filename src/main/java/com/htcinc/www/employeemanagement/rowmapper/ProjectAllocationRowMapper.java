package com.htcinc.www.employeemanagement.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htcinc.www.employeemanagement.bo.Department;
import com.htcinc.www.employeemanagement.bo.ProjectAllocation;

public class ProjectAllocationRowMapper implements RowMapper<ProjectAllocation> {

	@Override
	public ProjectAllocation mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectAllocation proj = new ProjectAllocation();
		proj.setClientName(rs.getString(3));
		proj.setProjectName(rs.getString(4));
		proj.setRoleTitle(rs.getString(5));
		proj.setFromDate(rs.getDate(1));
		proj.setToDate(rs.getDate(2));
		 
		return proj;
	}
	public ProjectAllocationRowMapper() {
		// TODO Auto-generated constructor stub
	}

}
