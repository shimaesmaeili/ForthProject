package controller;

import logic.Search;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;

public class ShowCustomerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			HashMap<String, String> result = null;
			if (request.getParameter("customerType").equals("real")) {
				result = Search.findRealCustomerById(request.getParameter("id"));
			} else if (request.getParameter("customerType").equals("legal")) {
				result = Search.findLegalCustomerById(request.getParameter("id"));
			}
			request.setAttribute("customerType", request.getParameter("customerType"));
			request.setAttribute("customer", result);
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
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
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
