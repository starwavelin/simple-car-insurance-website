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
		if (request.getParameter("btn").equals("Add")) {
			Customer c = new Customer();
			c.setFirstname(request.getParameter("firstname"));
			c.setLastname(request.getParameter("lastname"));
			c.setPolicyNo(request.getParameter("policyno"));
			c.setPhone(request.getParameter("phone"));
			c.setEmail(request.getParameter("email"));
			c.setAAA(request.getParameter("aaa"));
			boolean inserted = Dao.insert(c);
			List<Customer> clist = Dao.showCustomerList();
			session.setAttribute("clist", clist);
			//response.sendRedirect("admin.jsp" + "?inserted=" + inserted); Test Use
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp"
					+ "?inserted=" + inserted);
			requestDispatcher.forward(request, response);
		} else if (request.getParameter("btn").equals("Edit")) {
			
		} else if (request.getParameter("btn").equals("Delete")) {
			
		} else {
			response.sendRedirect("error.jsp");
		}
		
	}

}
