package controller;

import logic.Search;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FindCustomersServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HashMap<String, String>> results = null;

		if (request.getParameter("customerType").equals("real")) {
			results = Search.findRealCustomers(request.getParameter("field"), request.getParameter("value"));
		} else if (request.getParameter("customerType").equals("legal")) {
			results = Search.findLegalCustomers(request.getParameter("field"), request.getParameter("value"));
		}
		request.setAttribute("customers", results);
		request.setAttribute("customerType", request.getParameter("customerType"));

		try {
			request.getRequestDispatcher("/view-results.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
