package com.hibernate_one_to_many_uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hibernate_one_to_many_uni.dto.Employee;
import com.hibernate_one_to_many_uni.dto.Laptop;
import com.hibernate_one_to_many_uni.service.EmployeeService;

public class EmployeeController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeService service = new EmployeeService();
		while (true) {
			Laptop laptop = new Laptop();
			Employee employee = new Employee();
			System.out.println("___________________________________________________________________________");
			System.out.println("|-----------------****Employee Mangement Application****------------------|");
			System.out.println("___________________________________________________________________________");
			System.out.println("''''1. Insert Data\n''''2. Update Data\n''''3. Delete Data");
			int choice = scanner.nextInt();
			switch (choice) {

			//-----INSERT CASE-----
			case 1: {
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("How many laptops you want to insert");
				int size = scanner.nextInt();
				List<Laptop> list = new ArrayList<Laptop>();
				for (int i = 1; i <= size; i++) {
					Laptop laptop1 = new Laptop();
					System.out.println("......Enter " + i + " Laptop Details......");
					System.out.println("      Enter the laptop model:");
					System.out.println("");
					laptop1.setName(scanner.next());
					System.out.println("      Enter the Price of Laptop:");
					System.out.println("");
					laptop1.setPrice(scanner.nextDouble());
					list.add(laptop1);
					System.out.println("===========================");
				}
				System.out.println("...Enter the Employee Details...");
				System.out.println("   Enter the Employee Name:");
				employee.setName(scanner.next());
				System.out.println("   Enter the Employee Email:");
				employee.setEmail(scanner.next());
				employee.setLaptops(list);
				service.insertEmployee(list, employee);

			}

				break;

			// --------UPDATE CASES--------------
			case 2: {
				System.out.println("----------------------------------------------------------------------------");
				System.out.println(
						"1. Update Employee name\n2. Update Employee Email\n3. Update laptop Model\n4. Update Price of Laptop");
				int choose = scanner.nextInt();
				switch (choose) {

				// update Employee name case
				case 1: {
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("Enter the id which you want to update.");
					int id = scanner.nextInt();
					System.out.println("Enter the New Name");
					employee.setName(scanner.next());
					service.updateEmployeeName(employee, id);

				}

					break;

				// update Employee Email case
				case 2: {
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("Enter the id which you want to update.");
					int id = scanner.nextInt();
					System.out.println("Enter the New Email");
					employee.setEmail(scanner.next());
					service.updateEmployeeEmail(employee, id);
				}
					break;

				// Update laptop Model Case
				case 3: {
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("Enter the id of laptop which you want to update.");
					int id = scanner.nextInt();
					System.out.println("Enter the new model of laptop");
					laptop.setName(scanner.next());
					service.updateLaptopName(laptop, id);

				}

				// Update Laptop Price Case
				case 4: {
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("Enter the id of laptop which you want to update.");
					int id = scanner.nextInt();
					System.out.println("Enter the new model of laptop");
					laptop.setPrice(scanner.nextDouble());
					service.updateLaptopPrice(laptop, id);

				}

					break;

				default:
					break;
				}
			}
				break;
				
				
				
			//------DELETE CASE-------
			case 3: {
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("Enter the Which you want to Delete");
				int id =scanner.nextInt();
				service.delete(id);
			}
				break;

			default:
				break;
			}

		}

	}

}
