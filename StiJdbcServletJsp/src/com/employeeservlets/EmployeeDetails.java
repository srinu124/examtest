package com.employeeservlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeedao.EmployeeDao;
import com.employeedao.EmployeeDaoImpl;

@WebServlet("/employeedetailsform")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeDetails() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("employeedetailsform.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		
		EmployeeDao edao = new EmployeeDaoImpl();
		
		try {
			ResultSet rs = edao.getEmployee(email);
			if(rs.wasNull()) {
				request.setAttribute("notsuccess", true);
				RequestDispatcher rd = request.getRequestDispatcher("employeedetailsform.jsp");
				rd.forward(request, response);
			}else if(rs.next()){
				String name = rs.getString("name");
				request.setAttribute("name", name);
				RequestDispatcher rd = request.getRequestDispatcher("employeedetails.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
