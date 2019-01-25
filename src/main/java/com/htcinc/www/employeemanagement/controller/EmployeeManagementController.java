package com.htcinc.www.employeemanagement.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.htcinc.www.employeemanagement.bo.Allocation;
import com.htcinc.www.employeemanagement.bo.Department;
import com.htcinc.www.employeemanagement.bo.Employee;
import com.htcinc.www.employeemanagement.bo.Manager;
import com.htcinc.www.employeemanagement.bo.Project;
import com.htcinc.www.employeemanagement.bo.ProjectAllocation;
import com.htcinc.www.employeemanagement.bo.Role;
import com.htcinc.www.employeemanagement.bo.Skill;
import com.htcinc.www.employeemanagement.dao.EmployeeManagementDAO;
import com.htcinc.www.employeemanagement.dao.impl.EmployeeManagementDAOImpl;

@Controller
public class EmployeeManagementController {

	@Autowired
	private EmployeeManagementDAO employeeManagementDAO;
	private EmployeeManagementDAOImpl employeeManagementDAOImpl;
	
	@RequestMapping(value = "/esystem")
	public String homePage() {
		return "home";
	}
	 
	@RequestMapping(value = "/newDept", method = { RequestMethod.POST, RequestMethod.GET })
	public Model newDept(Model model) {
		model.addAttribute(new Department());
		return model;
	}

	@RequestMapping(value = "/newSkill", method = { RequestMethod.POST, RequestMethod.GET })
	public Model newSkill(Model model) {
		model.addAttribute(new Skill());
		return model;
	}

	@RequestMapping(value = "/newProject", method = { RequestMethod.POST, RequestMethod.GET })
	public Model newProject(Model model) {
		model.addAttribute(new Project());
		return model;
	}

	@RequestMapping(value = "/newEmp", method = { RequestMethod.POST, RequestMethod.GET })
	public Model newEmp(Model model) {
		model.addAttribute(new Employee());
		dropDownOnEmpPage(model);
		
		
		return model;
		
	}

	@RequestMapping(value = "/newRole", method = { RequestMethod.POST, RequestMethod.GET })
	public Model newRole(Model model) {
		model.addAttribute(new Role());
		return model;
	}
	
	
	@RequestMapping(value = "/newAllocation", method = { RequestMethod.POST, RequestMethod.GET })
	public Model newAllocaton(Model model) {
		model.addAttribute(new Allocation());
		dropDownOnAllocationPage(model);
		return model;
	}
	

	@RequestMapping(value = "/createDepartment", method = { RequestMethod.POST, RequestMethod.GET })
	public String createDepartment(@ModelAttribute("department") Department department, Model model) {
		
	
		int returnStatus =  employeeManagementDAO.createDepartment(department) ;
			if ( returnStatus == 1) {
				model.addAttribute("status", "New Department added Successfully!");
				model.addAttribute("url", "/newDept");
				return "success";
			}else if( returnStatus == 0) {
				model.addAttribute("status", "Department ID : " + department.getId() + "  already exist ");
				model.addAttribute("url", "/newDept");
				return "failure";
			}else if( returnStatus == -1) {
				model.addAttribute("status", "System Error , Try Later !! ");
				model.addAttribute("url", "/newDept");
				return "failure";
			}else {
				return "failure";
			}
 	}

	@RequestMapping(value = "/createSkill", method = { RequestMethod.POST, RequestMethod.GET })
	public String createSkill(@ModelAttribute("skill") Skill skill, Model model) {
		
		int returnStatus =  employeeManagementDAO.createSkill(skill) ;
		if ( returnStatus == 1) {
			model.addAttribute("status", "New Skill added Successfully!");
			model.addAttribute("url", "/newSkill");
			return "success";
		}else if( returnStatus == 0) {
			model.addAttribute("status", "Skill ID : " + skill.getId() + "  already exist ");
			model.addAttribute("url", "/newSkill");
			return "failure";
		}else if( returnStatus == -1) {
			model.addAttribute("status", "System Error , Try Later !! ");
			model.addAttribute("url", "/newSkill");
			return "failure";
		}else {
			return "failure";
		}
	}

	@RequestMapping(value = "/createProject", method = { RequestMethod.POST, RequestMethod.GET })
	public String createProject(@ModelAttribute("project") Project project, Model model) {
		int returnStatus =  employeeManagementDAO.createProject(project);
		if ( returnStatus == 1) {
			model.addAttribute("status", "New Project added Successfully!");
			model.addAttribute("url", "/newProject");
			return "success";
		}else if( returnStatus == 0) {
			model.addAttribute("status", "Project ID : " + project.getProjectId()+ "  already exist ");
			model.addAttribute("url", "/newProject");
			return "failure";
		}else if( returnStatus == -1) {
			model.addAttribute("status", "System Error , Try Later !! ");
			model.addAttribute("url", "/newProject");
			return "failure";
		}else {
			return "failure";
		}
	}

	@RequestMapping(value = "/createRole", method = { RequestMethod.POST, RequestMethod.GET })
	public String createRole(@ModelAttribute("role") Role role, Model model) {
		int returnStatus =  employeeManagementDAO.createRole(role);
		if ( returnStatus == 1) {
			model.addAttribute("status", "New Role added Successfully!");
			model.addAttribute("url", "/newRole");
			return "success";
		}else if( returnStatus == 0) {
			model.addAttribute("status", "Role ID : " + role.getId()+ "  already exist ");
			model.addAttribute("url", "/newRole");
			return "failure";
		}else if( returnStatus == -1) {
			model.addAttribute("status", "System Error , Try Later !! ");
			model.addAttribute("url", "/newRole");
			return "failure";
		}else {
			return "failure";
		}
	}

	@RequestMapping(value = "/createEmployee", method = { RequestMethod.POST, RequestMethod.GET })
	public String createEmployee(@ModelAttribute("employee") Employee emp, Model model) {
		int returnStatus =  employeeManagementDAO.createEmployee(emp);
		if ( returnStatus == 1) {
			model.addAttribute("status", "New Employee added Successfully!");
			model.addAttribute("url", "/newEmp");
			return "success";
		}else if( returnStatus == 0) {
			model.addAttribute("status", "Employee ID : " + emp.getEmpId() + "  already exist ");
			model.addAttribute("url", "/newEmp");
			return "failure";
		}else if( returnStatus == -1) {
			model.addAttribute("status", "System Error , Try Later !! ");
			model.addAttribute("url", "/newEmp");
			return "failure";
		}else {
			return "failure";
		}
	}
	
	@RequestMapping(value = "/createAllocation", method = { RequestMethod.POST, RequestMethod.GET })
	public String createAllocation(@ModelAttribute("allocation") Allocation allocation, Model model) {
		int returnStatus =  employeeManagementDAO.createAllocation(allocation);
		if ( returnStatus == 1) {
			model.addAttribute("status", "New Allocation added Successfully!");
			model.addAttribute("url", "/newAllocation");
			return "success";
		}else if( returnStatus == 0) {
			model.addAttribute("status", "Employee ID : " + allocation.getEmpId() + " is already allocated to "
					+ allocation.getProjId() + " with Role ID "+ allocation.getRoleId()+ " from date " + allocation.getFromDate());
			model.addAttribute("url", "/newAllocation");
			return "failure";
		}else if( returnStatus == -1) {
			model.addAttribute("status", "System Error , Try Later !! ");
			model.addAttribute("url", "/newAllocation");
			return "failure";
		}else {
			return "failure";
		}
	}

	@RequestMapping(value = "/displayAllocation", method = { RequestMethod.GET })
	public String displayAllocation(@RequestParam(value="id",required=false ) String empId, Model model) {
		
		if(!StringUtils.isEmpty(empId)) {
			
			List<ProjectAllocation> projects = employeeManagementDAO.getProjects(Integer.parseInt(empId)) ;
			
			if(!projects.isEmpty())
			{
				model.addAttribute("result", projects);
			}else
			{
				model.addAttribute("msg","No allocation found for employee ID : "+ empId );
			}	
				
		  }
		return "displayAllocations";
	}
	
//	@RequestMapping(value = "/dropDown", method = { RequestMethod.POST, RequestMethod.GET })
	public void dropDownOnEmpPage(Model model) {
		Map<Integer, String> departmentList = new HashMap<Integer, String>();
		Map<Integer, String> managerList = new HashMap<Integer, String>();
		
		
		List<Department> departments = employeeManagementDAO.getDepartments();
		List<Manager> managers = employeeManagementDAO.getManagers() ;
		
		for (Department department : departments) {
			departmentList.put(department.getId(), department.getName());
		}
		for (Manager manager : managers) {
			managerList.put(manager.getId(),manager.getName());
		}
		
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("managerList", managerList);
		
		

	}
	
	public void dropDownOnAllocationPage(Model model) {
		//Map<Integer, String> empList = new HashMap<Integer, String>();
		//Map<Integer, String> projectList = new HashMap<Integer, String>();
		Map<Integer, String> roleList = new HashMap<Integer, String>();
		
		List<Role> roles = employeeManagementDAO.getRoles() ;
		
		
		List<Manager> managers = employeeManagementDAO.getManagers() ;
		
		for (Role role : roles) {
			roleList.put(role.getId(),role.getName());
		}
		
		model.addAttribute("roleList", roleList);
		
		
	
	
	}

}
