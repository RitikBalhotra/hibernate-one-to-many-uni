package com.hibernate_one_to_many_uni.service;

import java.util.List;

import com.hibernate_one_to_many_uni.dao.EmployeeDao;
import com.hibernate_one_to_many_uni.dto.Employee;
import com.hibernate_one_to_many_uni.dto.Laptop;

public class EmployeeService {

	EmployeeDao dao = new EmployeeDao();

	// insert method..
	public void insertEmployee(List<Laptop> laptops, Employee employee) {
		dao.insertEmployee(laptops, employee);
	}

	// update Employee name method
	public void updateEmployeeName(Employee employee, int id) {
		dao.updateEmployeeName(employee, id);
	}

	// update Employee Email method
	public void updateEmployeeEmail(Employee employee, int id) {
		dao.updateEmployeeEmail(employee, id);
	}

	// update laptop model method
	public void updateLaptopName(Laptop laptop, int id) {
		dao.updateLaptopName(laptop, id);
	}

	// update laptop Price method
	public void updateLaptopPrice(Laptop laptop, int id) {
		dao.updateLaptopPrice(laptop, id);
	}

	// delete
	public void delete(int id) {
		dao.delete(id);
	}
}
