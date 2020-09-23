package com.thevarungupta;

import java.sql.SQLException;

public class EmployeeDAOFactory {
    private static EmployeeDAO dao;

    public static EmployeeDAO getEmployeeDao() throws SQLException {
        if(dao ==null){
            dao = new EmployeeDAOImpl();
        }
        return dao;
    }
}
