package com.servlet;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;
import com.bean.Customer;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (request.getParameter("edit").equals("Insert")) {
			Customer customer = new Customer();
			customer.setFirstname(request.getParameter("firstname"));
			customer.setLastname(request.getParameter("lastname"));
			customer.setPolicyNo(request.getParameter("policyno"));
			customer.setPhone(request.getParameter("phone"));
			customer.setEmail(request.getParameter("email"));
			customer.setAAA(request.getParameter("aaa"));
			Dao.addCustomer(customer);
			
			List<Customer> customers = Dao.getAllCustomers();
			session.setAttribute("customerList", customers);
			response.sendRedirect("customerHome.jsp");
		}
		else {
			response.sendRedirect("error.jsp");
		}
		
		
	}

}
