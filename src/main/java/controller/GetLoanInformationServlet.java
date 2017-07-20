package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetLoanInformationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("loanName", request.getParameter("loanName"));
		request.setAttribute("interestRate", request.getParameter("interestRate"));
		request.getRequestDispatcher("/define-grant-conditions.jsp").forward(request, response);
	}
}
