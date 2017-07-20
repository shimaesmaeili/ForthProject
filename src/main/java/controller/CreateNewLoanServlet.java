package controller;

import logic.Insert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CreateNewLoanServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loanName = request.getParameter("loanName");
		int interestRate = Integer.parseInt(request.getParameter("interestRate"));

		String[] names = request.getParameterValues("name");
		String[] minDurations = request.getParameterValues("minDuration");
		String[] maxDurations = request.getParameterValues("maxDuration");
		String[] minAmounts = request.getParameterValues("minAmount");
		String[] maxAmounts = request.getParameterValues("maxAmount");

		try {
			Insert.insertNewLoan(loanName, interestRate, names, minDurations, maxDurations, minAmounts, maxAmounts);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
