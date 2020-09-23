package com.thevarungupta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();

        // insert Employee
        // Employee employee = new Employee(1, "Peterson", "p@gmail.com");
        // dao.addEmployee(employee);
        //
        // Employee employee2 = new Employee(2, "Peterson2", "p@gmail.com");
        // dao.addEmployee(employee2);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter EMpId");
        int id = scanner.nextInt();
        System.out.println("Enter Name");
        String name = scanner.next();
        System.out.println("Enter Email");
        String email = scanner.nextLine();

        Employee emp = new Employee(id, name, email);
        dao.addEmployee(emp);

    }
}
