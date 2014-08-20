package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Vehicle;
import com.dao.Dao;

/**
 * Servlet implementation class AddVehicle
 */
@WebServlet("/AddVehicle")
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddVehicle() {
        super();       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (request.getParameter("edit").equals("Add")) {
			int cusid = Integer.parseInt(request.getParameter("cusid")); 
			Vehicle v = new Vehicle();
			v.setVin(request.getParameter("vin"));
			v.setMake(request.getParameter("make"));
			v.setModel(request.getParameter("model"));
			v.setType(request.getParameter("type"));
			v.setYear(Integer.parseInt(request.getParameter("year")));
			v.setPicture(request.getParameter("picture"));
			v.setAmount(Double.parseDouble(request.getParameter("amount")));
			v.setCusid(cusid);
			
			Dao.insertVehicle(v);
			List<Vehicle> vlist = Dao.getAllVehicles(cusid);
			session.setAttribute("vehicleList", vlist);
			response.sendRedirect("vehicles.jsp");
		}
	}

}
