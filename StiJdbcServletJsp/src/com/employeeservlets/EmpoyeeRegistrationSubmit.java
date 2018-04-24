package com.employeeservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeedao.EmployeeDao;
import com.employeedao.EmployeeDaoImpl;

@WebServlet("/register")
public class EmpoyeeRegistrationSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmpoyeeRegistrationSubmit() {
        super();
       
    }
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		EmployeeDao edao = new EmployeeDaoImpl();
		
		int savedao = 0 ;
		
		try {
			savedao = edao.saveEmployee(name, email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			if(savedao == 1) {
				request.setAttribute("name", name);
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("notsuccess", true);
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);			
			}
	}

}
