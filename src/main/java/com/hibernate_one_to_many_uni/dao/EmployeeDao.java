package com.hibernate_one_to_many_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.hibernate_one_to_many_uni.dto.Employee;
import com.hibernate_one_to_many_uni.dto.Laptop;

public class EmployeeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ritik");
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	// insert method..
	public void insertEmployee(List<Laptop> laptops, Employee employee) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		for (Laptop laptop : laptops) {
			entityManager.persist(laptop);
		}
		entityManager.persist(employee);

		entityTransaction.commit();
		System.out.println("*****Data inserted*****");
		System.out.println("___________________________________________________________________________");
	}

	// update Employee name method
	public void updateEmployeeName(Employee employee, int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Employee employee2 = entityManager.find(Employee.class, id);

		if (employee2 != null) {
			employee2.setName(employee.getName());
			entityTransaction.begin();
			entityManager.merge(employee2);
			entityTransaction.commit();
			System.out.println("***Name Updated***");
			System.out.println("_______________________________________________________________________");

		} else {
			System.out.println("Given id is not Present");
		}
	}

	// update Employee Email method
	public void updateEmployeeEmail(Employee employee, int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Employee employee2 = entityManager.find(Employee.class, id);

		if (employee2 != null) {
			employee2.setEmail(employee.getEmail());
			entityTransaction.begin();
			entityManager.merge(employee2);
			entityTransaction.commit();
			System.out.println("***Email Updated***");
			System.out.println("_______________________________________________________________________");

		} else {
			System.out.println("Given id is not Present");
		}
	}

	// update laptop model method
	public void updateLaptopName(Laptop laptop, int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Laptop laptop2 = entityManager.find(Laptop.class, id);

		if (laptop2 != null) {
			laptop2.setName(laptop.getName());
			entityTransaction.begin();
			entityManager.merge(laptop2);
			entityTransaction.commit();
			System.out.println("***Laptop Model Updated***");
			System.out.println("_______________________________________________________________________");

		} else {
			System.out.println("Given id is not Present");
		}
	}

	// update laptop Price method
	public void updateLaptopPrice(Laptop laptop, int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Laptop laptop2 = entityManager.find(Laptop.class, id);

		if (laptop2 != null) {
			laptop2.setPrice(laptop.getPrice());
			entityTransaction.begin();
			entityManager.merge(laptop2);
			entityTransaction.commit();
			System.out.println("***Laptop Price Updated***");
			System.out.println("_______________________________________________________________________");

		} else {
			System.out.println("Given id is not Present");
		}
	}

	// delete
	public void delete(int id) {
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

		Employee employee = entityManager.find(Employee.class, id);

		List<Laptop> laptops = employee.getLaptops();

		if (employee != null) {

			
			Employee emp=employee;
//			entityManager.remove(employee);

			for (Laptop laptop : laptops) {

				Laptop laptop2 = entityManager.find(Laptop.class, laptop.getId());

				if (laptop2 != null) {
					entityTransaction.begin();
					entityManager.remove(emp);
					entityManager.remove(laptop2);
					entityTransaction.commit();
				} else {
					System.out.println("PLease check the laptop Id");
				}
			}
		} else {
			System.out.println("id not present");
		}

	}

}
