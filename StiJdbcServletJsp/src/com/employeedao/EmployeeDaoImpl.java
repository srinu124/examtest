package com.employeedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Connection createConnection() {
		
		String url="jdbc:postgresql://localhost:5432/stidb";
		String user="vaste";
		String pwd="saste";
		
		Connection con=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

	@Override
	public int saveEmployee(String name, String email, String password) throws SQLException {
		
		Connection con = createConnection();
		
		String sql="insert into customer(name, email, password) values(?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, password);
		
		int result = ps.executeUpdate();
		con.close();
		/*Statement stm = con.createStatement();
		String sql = "insert into customer(name, email, password) values(name, email, password)";
		int result = stm.executeUpdate(sql);*/
		
		return result;
	}

	@Override
	public ResultSet getEmployee(String email) throws SQLException {
		Connection con = createConnection();
		
		String sql = "select name from customer where email =" + "'" +email+ "'";
		
		Statement stm = con.createStatement();
		ResultSet result = stm.executeQuery(sql);
		
		return result;
	}

}
