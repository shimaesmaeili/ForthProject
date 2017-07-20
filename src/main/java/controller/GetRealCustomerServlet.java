package controller;

import com.google.gson.Gson;
import logic.Search;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class GetRealCustomerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("customerId");
        System.out.println(id);
		try {
			HashMap<String, String> customer = Search.findRealCustomerById(id);
			ArrayList<HashMap<String, String>> loans = Search.findLoans();
//			loans.add(customer);

			HashMap<String, Object> result = new HashMap<String, Object>();
			result.put("customer", customer);
			result.put("loans", loans);

//			request.setAttribute("customer", customer);
//			request.setAttribute("loans", loans);
//			request.getRequestDispatcher("/create-new-loan-file.jsp").forward(request, response);

            String json = new Gson().toJson(result);


            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
