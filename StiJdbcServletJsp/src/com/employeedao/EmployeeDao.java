package com.employeedao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeDao {
	
	public Connection createConnection();
	
	public int saveEmployee(String name, String email, String password) throws SQLException;
	
	public ResultSet getEmployee(String email) throws SQLException;

}
