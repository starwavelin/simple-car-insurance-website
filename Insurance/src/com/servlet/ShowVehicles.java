package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Customer;
import com.bean.Vehicle;
import com.dao.Dao;

/**
 * Servlet implementation class ShowVehicles
 */
@WebServlet("/ShowVehicles")
public class ShowVehicles extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ShowVehicles() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int cusID = Integer.parseInt(request.getParameter("cusID"));
		if (request.getParameter("showVehicles").equals("ShowVehicles")) {
			List<Vehicle> vehicles = Dao.getAllVehicles(cusID);
			session.setAttribute("vehicleList", vehicles);
			session.setAttribute("cusid", cusID);
			response.sendRedirect("vehicles.jsp");
		} 
		else {
			response.sendRedirect("error.jsp");
		}
	}

}
