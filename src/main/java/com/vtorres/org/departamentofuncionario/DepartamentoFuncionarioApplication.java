package com.vtorres.org.departamentofuncionario;


import com.vtorres.org.departamentofuncionario.entities.Department;
import com.vtorres.org.departamentofuncionario.entities.HourContract;
import com.vtorres.org.departamentofuncionario.entities.Worker;
import com.vtorres.org.departamentofuncionario.entities.WorkerLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class DepartamentoFuncionarioApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(DepartamentoFuncionarioApplication.class, args);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter department's name: ");
		String departmentName = scanner.nextLine();
		System.out.println("Enter worker data.");
		System.out.println("Name: ");
		String workerName = scanner.nextLine();
		System.out.println("Level: ");
		String workerLevel = scanner.nextLine();
		System.out.println("Base salary: ");
		double baseSalary = scanner.nextDouble();

		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

		System.out.println("How many contratcs to this worker? ");
		int n = scanner.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.println("Date (DD/MM/YYYY)");
			Date contractDate = sdf.parse(scanner.next());
			System.out.print("Value per hour: ");
			int valuePerHour = scanner.nextInt();
			System.out.print("Duration (Hours)");
			int hours = scanner.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}

			System.out.println("Enter month and year to calculate income (MM/YYYY");
			String monthAndYear= scanner.next();
			int month = Integer.parseInt(monthAndYear.substring(0, 2));
			int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name " + worker.getName());
		System.out.printf("Department " + worker.getDepartment().getName());
		System.out.println("Infome for " + monthAndYear + ": " + String.format("%.2f" + worker.income(year, month)));


		scanner.close();
	}



}
