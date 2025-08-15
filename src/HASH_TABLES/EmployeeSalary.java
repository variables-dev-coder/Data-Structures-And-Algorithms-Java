package HASH_TABLES;

import java.util.HashMap;
import java.util.Map;

public class EmployeeSalary {
    public static void main(String[] args) {
        // Create a HashMap: employeeID -> salary
        Map<Integer, Double> salaries = new HashMap<>();

        // 1. Add employees with their salaries
        salaries.put(101, 55000.0);
        salaries.put(102, 60000.0);
        salaries.put(103, 75000.0);

        // 2. Get salary of an employee
        System.out.println("Salary of Employee 102: " + salaries.get(102));

        // 3. Give a raise to an employee
        int empIdRaise = 103;
        if (salaries.containsKey(empIdRaise)) {
            salaries.put(empIdRaise, salaries.get(empIdRaise) + 5000);
            System.out.println("Updated salary for Employee " + empIdRaise + ": " + salaries.get(empIdRaise));
        }

        // 4. Remove an employee
        salaries.remove(101);

        // 5. Display all employees and salaries
        System.out.println("\nAll Employee Salaries:");
        for (Map.Entry<Integer, Double> entry : salaries.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " -> Salary: $" + entry.getValue());
        }
    }
}

/*
Salary of Employee 102: 60000.0
Updated salary for Employee 103: 80000.0

All Employee Salaries:
ID: 102 -> Salary: $60000.0
ID: 103 -> Salary: $80000.0

Key Points

Keys = Employee IDs (Integer)
Values = Salaries (Double)
Hashing ensures quick lookups, updates, and deletions.

 */