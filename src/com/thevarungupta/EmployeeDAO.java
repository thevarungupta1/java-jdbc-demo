package com.thevarungupta;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee) throws Exception;
    void updateEmployee(Employee employee)throws Exception;
    void deleteEmployee(int empId) throws Exception;
    Employee searchEmployee(int empId) throws Exception;
    List<Employee> getEmployees()throws Exception;


}
