package controller;

import com.google.gson.Gson;
import logic.Search;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GetRealCustomerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("customerId");
		HashMap<String, String> customer = Search.findRealCustomerById(id);
		ArrayList<HashMap<String, String>> loans = Search.findLoans();
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("customer", customer);
		result.put("loans", loans);
		String json = new Gson().toJson(result);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
            response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
