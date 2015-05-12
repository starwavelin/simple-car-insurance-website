package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import bean.Vehicle;
import dao.Dao;


@WebServlet("/UpdateVehicleServlet")
public class UpdateVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateVehicleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer cus = (Customer) session.getAttribute("cus");
		int cusid = cus.getId();
		//System.out.println("Inside Vehicle doPost");
		if (request.getParameter("btn").equals("Add")) {
			//System.out.println("Inside AddVehicle");
			Vehicle v = new Vehicle();
			v.setVin(request.getParameter("vin"));
			v.setMake(request.getParameter("make"));
			v.setModel(request.getParameter("model"));
			v.setType(request.getParameter("type"));
			v.setYear(request.getParameter("year"));
			v.setPicture(request.getParameter("picture"));
			v.setAmount(request.getParameter("amount"));
			v.setCusid(cusid);
			boolean inserted = Dao.insertVehicle(v, cusid);
			List<Vehicle> vlist = Dao.getVehicleListByCusid(cusid);
			session.setAttribute("vlist", vlist);
			//response.sendRedirect("customer.jsp" + "?inserted=" + inserted); // Debug Use
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer.jsp");
			requestDispatcher.forward(request, response);
		} else if (request.getParameter("btn").equals("Edit")) {
			System.out.println("Inside EditVehicle");
			Vehicle v = new Vehicle();
			v.setVin(request.getParameter("vin"));
			v.setMake(request.getParameter("make"));
			v.setModel(request.getParameter("model"));
			v.setType(request.getParameter("type"));
			v.setYear(request.getParameter("year"));
			v.setPicture(request.getParameter("picture"));
			v.setAmount(request.getParameter("amount"));
			v.setCusid(cusid);
			boolean edited = Dao.editVehicle(v);
			List<Vehicle> vlist = Dao.getVehicleListByCusid(cusid);
			session.setAttribute("vlist", vlist);
			response.sendRedirect("customer.jsp" + "?edited=" + edited);
			//RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer.jsp");
			//requestDispatcher.forward(request, response);
		} else if (request.getParameter("btn").equals("Delete")) {
			System.out.println("Inside DeleteVehicle");
			String vin = request.getParameter("vin");
			boolean deleted = Dao.deleteVehicleByVin(vin);
			List<Vehicle> vlist = Dao.getVehicleListByCusid(cusid);
			session.setAttribute("vlist", vlist);
			//response.sendRedirect("customer.jsp" + "?deleted=" + deleted);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer.jsp");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("error.jsp");
		}
	}

}
