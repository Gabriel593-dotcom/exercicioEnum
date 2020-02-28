package exercicioEnumeracao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Worker worker = new Worker();

		System.out.print("Enter department's name: ");
		String department = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.next();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(department));
		System.out.print("How many contracts to this worker: ");

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Enter Contract #" + i + " data:");
			System.out.print("data: (DD/MM/YYYY): ");
			Date dateContract = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.println("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(dateContract, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.println("Enter month and year to calcule income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + worker.income(year, month));

		sc.close();
	}

}
