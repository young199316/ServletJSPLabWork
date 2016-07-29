package com.young.chou;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("/register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		if(username.equals("admin")){
			request.setAttribute("msg", "Admin is the reserve username. Please use another username!");
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
	    	dispatcher.forward(request, response);
		}
		if(username.isEmpty() == false && password.isEmpty() == false){
			User newUser = LoginService.registerUser(username, password);
			if(newUser != null){
				request.setAttribute("msg", "Welcome " + username+ " !");
				request.setAttribute("id", LoginService.getUserData(username).getId());
				Cookie myCookie =  new Cookie("id", String.valueOf(LoginService.getUserData(username).getId()));
				response.addCookie(myCookie);
		    	//request.getRequestDispatcher("/login.jsp");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		    	dispatcher.forward(request, response);
			}
			else{
				request.setAttribute("msg", "Username is already registered. Please use another username!");
		    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		    	dispatcher.forward(request, response);
			}
		}
		else{
			request.setAttribute("msg", "Empty username or password.");
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
	    	dispatcher.forward(request, response);
		}
	}

}
