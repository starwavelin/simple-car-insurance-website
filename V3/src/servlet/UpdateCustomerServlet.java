package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import bean.Customer;


@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//System.out.println("Inside Customer doPost");
		if (request.getParameter("btn").equals("Add")) {
			System.out.println("Inside AddCustomer");
			Customer c = new Customer();
			c.setFirstname(request.getParameter("firstname"));
			c.setLastname(request.getParameter("lastname"));
			c.setPolicyno(request.getParameter("policyno"));
			c.setPhone(request.getParameter("phone"));
			c.setEmail(request.getParameter("email"));
			c.setAaa(request.getParameter("aaa"));
			boolean inserted = Dao.insertCustomer(c);
			List<Customer> clist = Dao.getCustomerList();
			session.setAttribute("clist", clist);
			//response.sendRedirect("admin.jsp" + "?inserted=" + inserted); // Debug Use
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			requestDispatcher.forward(request, response);
		} else if (request.getParameter("btn").equals("Edit")) {
			System.out.println("Inside EditCustomer");
			Customer c = new Customer();
			c.setId(Integer.parseInt(request.getParameter("id")));
			c.setFirstname(request.getParameter("firstname"));
			c.setLastname(request.getParameter("lastname"));
			c.setPolicyno(request.getParameter("policyno"));
			c.setPhone(request.getParameter("phone"));
			c.setEmail(request.getParameter("email"));
			c.setAaa(request.getParameter("aaa"));
			boolean edited = Dao.editCustomer(c);
			List<Customer> clist = Dao.getCustomerList();
			session.setAttribute("clist", clist);
			response.sendRedirect("admin.jsp" + "?edited=" + edited);
			//RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			//requestDispatcher.forward(request, response);
		} else if (request.getParameter("btn").equals("Delete")) {
			System.out.println("Inside DeleteCustomer");
			int id = Integer.parseInt(request.getParameter("id"));
			boolean deleted = Dao.deleteCustomer(id);
			List<Customer> clist = Dao.getCustomerList();
			session.setAttribute("clist", clist);
			response.sendRedirect("admin.jsp" + "?deleted=" + deleted);
			//RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			//requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("error.jsp");
		}
	}
}
