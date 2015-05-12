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


@WebServlet("/ShowVehicleServlet")
public class ShowVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowVehicleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Customer cus = Dao.getCustomerByID(id);
		session.setAttribute("cus", cus);
		
		List<Vehicle> vlist = Dao.getVehicleListByCusid(id);
		session.setAttribute("vlist", vlist);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer.jsp");
		requestDispatcher.forward(request, response);
	}

}
