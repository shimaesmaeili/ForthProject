package controller;

import logic.Remove;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RemoveCustomerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getParameter("customerType").equals("real")){
				Remove.removeRealCustomer(request.getParameter("id"));
			} else if (request.getParameter("customerType").equals("legal")) {
				Remove.removeLegalCustomer(request.getParameter("id"));
			}
			request.getRequestDispatcher("/customers.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
