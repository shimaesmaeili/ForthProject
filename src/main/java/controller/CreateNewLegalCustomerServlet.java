package controller;

import logic.Insert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Date;

public class CreateNewLegalCustomerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		BigInteger eCode = new BigInteger(request.getParameter("eCode"));
		String name = request.getParameter("name");
		Date registrationDate = Date.valueOf(request.getParameter("registrationDate"));
		try {
			String id = Insert.insertNewLegalCustomer(eCode, name, registrationDate);
			if (id != null) {
				request.setAttribute("id", id);
				request.getRequestDispatcher("/show-new-customer-id.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "مشتری با این کد اقتصادی قبلا ثبت شده است.");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
