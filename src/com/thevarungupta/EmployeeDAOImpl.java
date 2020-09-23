package com.thevarungupta;

import java.sql.*;
import java.util.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static Statement statement = null;

    public EmployeeDAOImpl() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        statement = con.createStatement();
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        String sql = "insert into employee values ("+employee.getEmpId()+", '"+employee.getName()+"', '"+employee.getEmail()+"')";
        int count = statement.executeUpdate(sql);
        if(count> 0){
            System.out.println("Employee saved");
        }else{
            System.out.println("Not completed");
        }
    }

    @Override
    public void updateEmployee(Employee employee) throws Exception {
        String sql = "update employee set name = '"+employee.getName()+"', email = '"+employee.getEmail()+"') where empId = "+ employee.getEmpId();
        int count = statement.executeUpdate(sql);
        if(count> 0){
            System.out.println("Employee updated");
        }else{
            System.out.println("Not completed");
        }
    }

    @Override
    public void deleteEmployee(int empId) throws Exception {
        String sql = "delete from  employee where empId = "+ empId;
        int count = statement.executeUpdate(sql);
        if(count> 0){
            System.out.println("Employee Delete");
        }else{
            System.out.println("Not completed");
        }
    }

    @Override
    public Employee searchEmployee(int empId) throws Exception {
        Employee emp = new Employee();
        String sql = "select * from employee where empId ="+ empId;
        ResultSet rs = statement.executeQuery(sql);
       if(rs.next()){
           int id = rs.getInt("empId");
           String name = rs.getString("name");
           String email = rs.getString("email");
           emp.setEmpId(id);
           emp.setName(name);
           emp.setEmail(email);
       }
       return emp;
    }

    @Override
    public List<Employee> getEmployees() throws Exception {
        List<Employee> list = new ArrayList<>();
        String sql = "select * from employee";
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            int id = rs.getInt("empId");
            String name = rs.getString("name");
            String email = rs.getString("email");
            Employee employee = new Employee(id, name, email);
            list.add(employee);
        }
        return list;
    }
}
