package com.capgemini.employeesession.dao;

import java.util.List;

import com.capgemini.employeesession.beans.EmployeePrimary;

public interface EmployeeDAO {
public EmployeePrimary authenticate(int id,String password); 
	
	boolean updateEmployeeInfo(EmployeePrimary info);
	boolean deleteEmployeeInfo(int id);
	boolean createEmployeeInfo(EmployeePrimary info);
	List<EmployeePrimary>  getAllRecordsEmployee();
	EmployeePrimary getEmployeeDetail(int id);
}
