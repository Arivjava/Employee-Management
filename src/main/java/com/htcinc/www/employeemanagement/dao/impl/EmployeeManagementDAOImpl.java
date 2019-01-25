package com.htcinc.www.employeemanagement.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.htcinc.www.employeemanagement.bo.Allocation;
import com.htcinc.www.employeemanagement.bo.Department;
import com.htcinc.www.employeemanagement.bo.Employee;
import com.htcinc.www.employeemanagement.bo.Manager;
import com.htcinc.www.employeemanagement.bo.Project;
import com.htcinc.www.employeemanagement.bo.ProjectAllocation;
import com.htcinc.www.employeemanagement.bo.Role;
import com.htcinc.www.employeemanagement.bo.Skill;
import com.htcinc.www.employeemanagement.dao.EmployeeManagementDAO;
import com.htcinc.www.employeemanagement.rowmapper.DepartmentRowMapper;
import com.htcinc.www.employeemanagement.rowmapper.ProjectAllocationRowMapper;
import com.htcinc.www.employeemanagement.rowmapper.RoleRowMapper;


@Repository
public class EmployeeManagementDAOImpl implements EmployeeManagementDAO {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private static final String CREATE_DEPARTMENT = "INSERT INTO department(dept_id, dept_name, dept_location) VALUES (:id, :name, :location)";
	private static final String CREATE_SKILL = "INSERT INTO skill(skill_id, skill_name) VALUES (:id, :name)";
	private static final String CREATE_PROJECT = "INSERT INTO PROJECT(project_id, project_name,client_name,deadline) VALUES (:id, :name, :clientname, :deadline)";
	private static final String CREATE_ROLE = "INSERT INTO role(role_id, role_title) VALUES (:roleid, :roletitle)";
	private static final String CREATE_EMP = "INSERT INTO employee(emp_id,emp_name,hiredate,salary,mgr_id,dept_id) VALUES (:empid,:empname,:hiredate,:salary,:mgrid,:deptid)";
	private static final String CREATE_ALLOCATION = "INSERT INTO allocation(emp_id,project_id,role_id,from_date,to_date,amount_perday) VALUES (:empid,:projectid,:roleid,:fromdate,:todate,:amt)";
	private static final String GET_MANAGERS = "SELECT emp_id , emp_name FROM employee WHERE emp_id IN (SELECT emp_id FROM allocation WHERE role_id = (\r\n" + 
			"	SELECT role_id FROM role WHERE role_title = 'pm'  ))" ;
	private static final String GET_DEPARTMENTS = "SELECT dept_id, dept_name, dept_location from department";
	private static final String GET_ROLES = "SELECT role_id, role_title from role";
	private static final String GET_PROJECTS = "SELECT al.from_date, al.to_date,p1.client_name, p1.project_name, r1.role_title FROM allocation al" + 
			" INNER JOIN project p1 ON al.project_id = p1.project_id" + 
			" INNER JOIN role r1 ON al.role_id=r1.role_id" + 
			" WHERE al.emp_id=:empid" ;
		
	@Override
	public int createDepartment(Department department) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", department.getId());
		params.addValue("name", department.getName());
		params.addValue("location", department.getLocation());
		int count = 0;
		try {
			count = namedParameterJdbcTemplate.update(CREATE_DEPARTMENT, params);
			} 
		catch(DuplicateKeyException e) {
			count = 0 ;
			//errMsg =  department.getId() + " already exist " ;
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO: handle exception
			count = -1; 
		  e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int createSkill(Skill skill) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", skill.getId());
		params.addValue("name", skill.getName());
        
		int count = 0;
		try {
		 count = namedParameterJdbcTemplate.update(CREATE_SKILL, params);
		} 
		catch(DuplicateKeyException e) {
			count = 0 ;
			//errMsg =  department.getId() + " already exist " ;
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO: handle exception
			count = -1; 
		  e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int createProject(Project project) {
		MapSqlParameterSource params = new MapSqlParameterSource();

		java.sql.Date d1 = new java.sql.Date(project.getDeadLine().getTime());

		params.addValue("id", project.getProjectId());
		params.addValue("name", project.getProjectName());
		params.addValue("clientname", project.getClientName());
		params.addValue("deadline", d1);

		int count = 0;
		try {
		 count = namedParameterJdbcTemplate.update(CREATE_PROJECT, params);
		} 
		catch(DuplicateKeyException e) {
			count = 0 ;
			//errMsg =  department.getId() + " already exist " ;
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO: handle exception
			count = -1; 
		  e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int createRole(Role role) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("roleid", role.getId());
		params.addValue("roletitle", role.getName());

		int count = 0;
		try {
		 count = namedParameterJdbcTemplate.update(CREATE_ROLE, params);
		} 
		catch(DuplicateKeyException e) {
			count = 0 ;
			//errMsg =  department.getId() + " already exist " ;
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO: handle exception
			count = -1; 
		  e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int createEmployee(Employee employee) {
		MapSqlParameterSource params = new MapSqlParameterSource();

		java.sql.Date d1 = new java.sql.Date(employee.getHireDate().getTime());

		params.addValue("empid", employee.getEmpId());
		params.addValue("empname", employee.getEmpName());
		params.addValue("hiredate", d1);
		params.addValue("salary", employee.getSalary());
		params.addValue("mgrid", employee.getMgrId());
		params.addValue("deptid", employee.getDepId());

		int count = 0;
		try {
		 count = namedParameterJdbcTemplate.update(CREATE_EMP, params);
		} 
		catch(DuplicateKeyException e) {
			count = 0 ;
			//errMsg =  department.getId() + " already exist " ;
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO: handle exception
			count = -1; 
		  e.printStackTrace();
		}
		
		return count;

	}

	@Override
	public int createAllocation(Allocation allocation) {
		MapSqlParameterSource params = new MapSqlParameterSource();

		java.sql.Date fromDate = new java.sql.Date(allocation.getFromDate().getTime());
		java.sql.Date toDate = new java.sql.Date(allocation.getToDate().getTime());
		
		
		params.addValue("empid", allocation.getEmpId());
		params.addValue("projectid", allocation.getProjId());
		params.addValue("roleid", allocation.getRoleId());
		params.addValue("fromdate",fromDate);
		params.addValue("todate",toDate);
		params.addValue("amt", allocation.getAmt());

		int count = 0;
		try {
		 count = namedParameterJdbcTemplate.update(CREATE_ALLOCATION, params);
		} 
		catch(DuplicateKeyException e) {
			count = 0 ;
			//errMsg =  department.getId() + " already exist " ;
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO: handle exception
			count = -1; 
		  e.printStackTrace();
		}
		
		return count;
	}
	
	
	
	@Override
	public List<Department> getDepartments() {
		return namedParameterJdbcTemplate.query(GET_DEPARTMENTS, new DepartmentRowMapper());
	}
	
	@Override
	public List<Role> getRoles() {
		return namedParameterJdbcTemplate.query(GET_ROLES, new RoleRowMapper());
	}
	
	@Override
	public List<ProjectAllocation> getProjects(int empId) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
        		 
		params.addValue("empid", empId);
		return namedParameterJdbcTemplate.query(GET_PROJECTS,params, new ProjectAllocationRowMapper());
	}
	

	@Override
	public List<Manager> getManagers() {
		 		
		return namedParameterJdbcTemplate.query(GET_MANAGERS, (rs, idx) -> {
			
			int mgrId = rs.getInt(1);
			String mgrName = rs.getString(2);
			
			
			return new Manager(mgrId, mgrName);
		});
	}
}
