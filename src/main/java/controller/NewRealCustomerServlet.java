package controller;

import logic.Insert;
import logic.Uniqueness;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;

public class NewRealCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BigInteger idCode = new BigInteger(request.getParameter("idCode"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		try {
			if (Uniqueness.getRealId(idCode) == null){
				String id = Insert.insertRealCustomer(idCode, firstName, lastName, fatherName, birthDate);
				request.setAttribute("id", id);
				request.getRequestDispatcher("/show-new-customer-id.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "مشتری با این کد ملی قبلا ثبت شده است.");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
