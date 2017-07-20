package controller;

import logic.Insert;
import logic.Verify;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.sql.SQLException;

public class CheckVerifyGrantConditionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        int loanId = Integer.parseInt(request.getParameter("loanId"));
        int duration = Integer.parseInt(request.getParameter("duration"));
        BigInteger amount = new BigInteger(request.getParameter("amount"));

        try {
            if (Verify.hasValidCondition(loanId, duration, amount)) {
                Insert.createNewLoanFile(customerId, loanId, duration, amount);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "مقادیر واردشده در هیچ‌یک از شروط اعطای این تسهیلات صدق نمی‌کند!");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
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
