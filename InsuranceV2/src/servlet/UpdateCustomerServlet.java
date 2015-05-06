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
			boolean inserted = Dao.insertCustomer(c);
			List<Customer> clist = Dao.getCustomerList();
			session.setAttribute("clist", clist);
			//response.sendRedirect("admin.jsp" + "?inserted=" + inserted); // Debug Use
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			requestDispatcher.forward(request, response);
		} else if (request.getParameter("btn").equals("Edit")) {
			Customer c = new Customer();
			c.setID(Integer.parseInt(request.getParameter("id_ed")));
			c.setFirstname(request.getParameter("firstname_ed"));
			c.setLastname(request.getParameter("lastname_ed"));
			c.setPolicyNo(request.getParameter("policyno_ed"));
			c.setPhone(request.getParameter("phone_ed"));
			c.setEmail(request.getParameter("email_ed"));
			c.setAAA(request.getParameter("aaa_ed"));
			boolean edited = Dao.editCustomer(c);
			List<Customer> clist = Dao.getCustomerList();
			session.setAttribute("clist", clist);
			//response.sendRedirect("admin.jsp" + "?edited=" + edited);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			requestDispatcher.forward(request, response);
		} else if (request.getParameter("btn").equals("Delete")) {
			int id = Integer.parseInt(request.getParameter("id_del"));
			boolean deleted = Dao.deleteCustomer(id);
			List<Customer> clist = Dao.getCustomerList();
			session.setAttribute("clist", clist);
			//response.sendRedirect("admin.jsp" + "?deleted=" + deleted);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("error.jsp");
		}
	}
}
