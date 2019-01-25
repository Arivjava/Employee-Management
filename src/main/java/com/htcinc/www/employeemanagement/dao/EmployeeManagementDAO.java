package com.htcinc.www.employeemanagement.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.htcinc.www.employeemanagement.bo.Allocation;
import com.htcinc.www.employeemanagement.bo.Department;
import com.htcinc.www.employeemanagement.bo.Employee;
import com.htcinc.www.employeemanagement.bo.Manager;
import com.htcinc.www.employeemanagement.bo.Project;
import com.htcinc.www.employeemanagement.bo.ProjectAllocation;
import com.htcinc.www.employeemanagement.bo.Role;
import com.htcinc.www.employeemanagement.bo.Skill;

public interface EmployeeManagementDAO {
	
	public int createDepartment(Department department) ;
	public int createSkill(Skill skill);
	public int createProject(Project project);
	public int createRole(Role role);
 	public int createEmployee(Employee employee);
 	public int createAllocation(Allocation allocation);
 	
 	public List<Department> getDepartments();
 	public List<Role> getRoles();
 	public List<Manager> getManagers();
 	
 	public List<ProjectAllocation> getProjects(int empId) ;
	
}
