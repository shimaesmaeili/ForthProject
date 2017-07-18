package controller;

import logic.Search;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class FindCustomersServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<HashMap<String, String>> results = null;
			if (request.getParameter("customerType").equals("real")) {
				results = Search.findRealCustomers(request.getParameter("field"), request.getParameter("value"));
			} else if (request.getParameter("customerType").equals("legal")) {
				results = Search.findLegalCustomers(request.getParameter("field"), request.getParameter("value"));
			}
			request.setAttribute("customers", results);
			request.setAttribute("customerType", request.getParameter("customerType"));
			request.getRequestDispatcher("/view-results.jsp").forward(request, response);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
