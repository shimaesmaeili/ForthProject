package controller;

import logic.Insert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateNewLoanServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String loanName = request.getParameter("loanName");
		int interestRate = Integer.parseInt(request.getParameter("interestRate"));

		String[] names = request.getParameterValues("name");
		String[] minDurations = request.getParameterValues("minDuration");
		String[] maxDurations = request.getParameterValues("maxDuration");
		String[] minAmounts = request.getParameterValues("minAmount");
		String[] maxAmounts = request.getParameterValues("maxAmount");

		Insert.insertNewLoan(loanName, interestRate, names, minDurations, maxDurations, minAmounts, maxAmounts);

		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
