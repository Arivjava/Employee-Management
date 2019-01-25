package com.htcinc.www.employeemanagement.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.htcinc.www.employeemanagement.bo.Department;

public class DepartmentRowMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("dept_id"));
		dep.setName(rs.getString("dept_name"));
		dep.setLocation(rs.getString("dept_location"));
		return dep;
	}

}
