package com.capgemini.employeesession.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.employeesession.beans.EmployeePrimary;
import com.capgemini.employeesession.dao.EmployeeDAO;

@Service
public class EmployeeServiceImplement implements EmployeeService{
	
	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeePrimary authenticate(int id, String password) {
		if(id<1 || password==null||password.isEmpty()||password.trim().isEmpty()) {
			return null;
		}
		return dao.authenticate(id, password);
	}

	@Override
	public boolean updateEmployeeInfo(EmployeePrimary info) {
		if(info != null) {
			return dao.updateEmployeeInfo(info);
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		if(id<1) {
			return false;
		}else {
			return dao.deleteEmployeeInfo(id);
		}
	}

	@Override
	public boolean createEmployeeInfo(EmployeePrimary info) {
		if(info != null) {
			return dao.createEmployeeInfo(info);
		}else {
			return false;
		}
	}

	@Override
	public List<EmployeePrimary> getAllRecordsEmployee() {
		// TODO Auto-generated method stub
		return dao.getAllRecordsEmployee();
	}

	@Override
	public EmployeePrimary getEmployeeDetail(int id) {
		if(id<1) {
			return null;
		} else {
			return dao.getEmployeeDetail(id);
		}
	}

}
