package controller;

import logic.Remove;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveCustomerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("customerType").equals("real")){
			Remove.removeRealCustomer(request.getParameter("id"));
		} else if (request.getParameter("customerType").equals("legal")) {
			Remove.removeLegalCustomer(request.getParameter("id"));
		}
		try {
			request.getRequestDispatcher("/customers.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
