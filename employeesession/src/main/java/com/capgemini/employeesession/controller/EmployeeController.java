package com.capgemini.employeesession.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.employeesession.beans.EmployeePrimary;
import com.capgemini.employeesession.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	
	@GetMapping("/welcome")
	public String welcomePage() {
		return "welcome";
	}


	@GetMapping("/registerForm")
	public String registerForm() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerEmployee(EmployeePrimary employeeInfoBean, ModelMap map) {
		System.out.println(employeeInfoBean.getId());	
		System.out.println("jkhgvfcghjkljhb");
		boolean isAdded = service.createEmployeeInfo(employeeInfoBean);
			if (isAdded) {
				map.addAttribute("done", "SucessFully Registered");
			} else {
				map.addAttribute("notDone", "Not Registered");
			}
			return "welcome";
		}

	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm(HttpSession session, ModelMap modelMap) {
		if(session.getAttribute("loggedInEmpInfo")!= null) {
			return "addemployeeForm";
		}else {
			modelMap.addAttribute("errMsg", "Please First Login!!");
			return "loginForm";
		}
		
	}

	@PostMapping("/addEmployee")
	public String addEmployee(EmployeePrimary info,ModelMap map,HttpSession session) {
		if(session.getAttribute("loggedInEmpInfo")!= null) {
			System.out.println(info.getId());
			boolean isAdded = service.createEmployeeInfo(info);
			if(isAdded) {
				map.addAttribute("done","Successfully added to the table");
				
			}else {
				map.addAttribute("notDone","Not added to the table");
			}
			return "status";
		}else {
			map.addAttribute("errMsg","Please login First!");
			return "loginForm";
		}
	}

	@GetMapping("/getEmployeeForm")
	public String getSearchForm(HttpSession session, ModelMap modelMap) {
		if(session.getAttribute("loggedInEmpInfo")!= null) {
			return "searchEmployee";
		}else {
			modelMap.addAttribute("errMsg","Please Login First!");
			return "loginForm";

		}

	}

	@GetMapping("/getEmployee")
	public String getDetail(int id,ModelMap map,HttpSession session) {
		if(session.getAttribute("loggedInEmpInfo") != null) {

			EmployeePrimary employeePrimary =  service.getEmployeeDetail(id);
			if(employeePrimary!=null) {
				map.addAttribute("employeeInfo",employeePrimary);

			} else {
				map.addAttribute("errMsg","Employee ID not found");
			}
			return "searchEmployee";
		}else {
			map.addAttribute("errMsg","Please Login First");
			return "loginForm";
		}
	}

	@GetMapping("/deleteEmployeeForm")
	public String getDeleteForm(HttpSession session, ModelMap modelMap) {
		if(session.getAttribute("loggedInEmpInfo")!=null) {
			return "deleteEmployeeForm";
		}else {
			modelMap.addAttribute("errMsg","Please First Login!");
			return "loginForm";
		}
	}

	@GetMapping("/deleteEmployee")
	public String deleted(int id,ModelMap map,HttpSession session) {
		if(session.getAttribute("loggedInEmpInfo")!=null) {
			boolean isDeleted = service.deleteEmployeeInfo(id);
			if(isDeleted) {
				map.addAttribute("done","successfully Deleted");
			}else {
				map.addAttribute("not Done","Not Deleted");
			}
			return "status";
		}else {
			map.addAttribute("errMsg","Please login First!");
			return "loginForm";
		}
	}

	@GetMapping("/allEmployeeDetails")
	public String getAllEmployee(ModelMap map,HttpSession session) {
		if(session.getAttribute("loggedInEmpInfo")!=null) {
			List<EmployeePrimary> beanList = service.getAllRecordsEmployee();
			if(beanList.size()!=0) {
				map.addAttribute("beanList",beanList);
			}else {
				map.addAttribute("zero","No employees are there");
			}
			return "allEmployeeDetails";
		}else {
			map.addAttribute("errMsg","Please Login First!");
			return "loginForm";
		}
	}
	
	@GetMapping("/updateEmployeeForm")
	public String updateEmployeeForm(HttpSession session,ModelMap modelMap) {
		if(session.getAttribute("loggedInEmpInfo")!= null) {
			return "updateEmployeeForm";
		}else {
			modelMap.addAttribute("errMsg", "Please Login First!!");
			return "loginForm";
			
		}
		
	}
	

	@PostMapping("/updateEmployee")
	public String getUpdateForm(EmployeePrimary info,HttpSession session,ModelMap modelMap) {
		if(session.getAttribute("loggedInEmpInfo")!=null) {
			boolean isUpdated = service.updateEmployeeInfo(info);
			if(isUpdated) {
				modelMap.addAttribute("done","Successfully updated");
			}else {
				modelMap.addAttribute("not done","Not updated");
			}
			return "status";
		}else {
			modelMap.addAttribute("errMsg","Please Login First");
			return "loginForm";
		}
	}


	@GetMapping("/loginForm")
	public String getLoginForm() {
		return "loginForm";
	}

	@PostMapping("/login")
	public String loggedIn(int id,String password,HttpServletRequest request) {
		EmployeePrimary record = service.authenticate(id, password);
		if(record != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedInEmpInfo", record);
			return "homePage";
		} else {
			request.setAttribute("errMsg", "Invalid Credentials");
			return "loginForm";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("errMsg","You are logged out successfully");
		return "loginForm";
	}

	@GetMapping("/home")
	public String showHomePage(HttpSession session, ModelMap modelMap) {
		if(session.getAttribute("loggedInEmpInfo")!=null) {
			return "homePage";
		}else {
			modelMap.addAttribute("errMsg","Please Login to Access This page");
			return "loginForm";
		}
		
	}
}
