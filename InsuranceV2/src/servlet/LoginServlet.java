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
import bean.User;
import dao.Dao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));

		user = Dao.login(user);
		if (user.isValid()) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			// get Customer List
			List<Customer> clist = Dao.getCustomerList();
			session.setAttribute("clist", clist);

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("admin.jsp" + "?username="
							+ user.getUsername());
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("errorLogin.jsp");
			requestDispatcher.forward(request, response);
		}

	}
}