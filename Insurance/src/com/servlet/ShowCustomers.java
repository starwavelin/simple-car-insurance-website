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
import com.dao.Dao;
/**
 * Servlet implementation class ShowCustomers
 */
@WebServlet("/ShowCustomers")
public class ShowCustomers extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private Dao dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCustomers() {
        super();
        dao = new Dao();
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
		HttpSession session = request.getSession();
		if (request.getParameter("action").equals("show")) {
			List<Customer> customers = dao.getAllCustomers();
			session.setAttribute("customerList", customers);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
