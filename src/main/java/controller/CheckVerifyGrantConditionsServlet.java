package controller;

import logic.Insert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

public class CheckVerifyGrantConditionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String customerId = request.getParameter("customerId");
        int loanId = Integer.parseInt(request.getParameter("loanId"));
        int duration = Integer.parseInt(request.getParameter("duration"));
        BigInteger amount = new BigInteger(request.getParameter("amount"));

        try {
            if (Insert.createNewLoanFile(customerId, loanId, duration, amount)) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "مقادیر واردشده در هیچ‌یک از شروط اعطای این تسهیلات صدق نمی‌کند!");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
