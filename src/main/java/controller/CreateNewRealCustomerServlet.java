package controller;

import logic.Insert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;

public class CreateNewRealCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		BigInteger idCode = new BigInteger(request.getParameter("idCode"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		try {
			String id = Insert.insertNewRealCustomer(idCode, firstName, lastName, fatherName, birthDate);
			if (id != null) {
				request.setAttribute("id", id);
				request.getRequestDispatcher("/show-new-customer-id.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "مشتری با این کد ملی قبلا ثبت شده است.");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
