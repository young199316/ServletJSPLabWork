package com.young.chou;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

/**
 * Servlet implementation class DataServlet
 */
//@WebServlet("/data.jsp")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public DataServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException{
//    	ApplicationSettings applicationSettings = new ApplicationSettings();
//    	User a = new User(1, "username", "password");
//    	
//    	List<User> l = new ArrayList<User>();
//    	l.add(a);
//    	applicationSettings.setFormTable(l);
//    	getServletContext().setAttribute("app", applicationSettings);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String id = (String)request.getParameter("id");
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("id")){
					int id = Integer.parseInt(cookie.getValue());
					User user = LoginService.getUserData_ID(id);
					if(user != null){
						request.setAttribute("login", "success");
						request.setAttribute("msg", "HI "+ user.getUsername());
					}
				}
//				if(cookie.getValue().equals(String.valueOf(id))){
//					request.setAttribute("login", "success");
//					request.setAttribute("id", id);
//				}
			}
		}
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
    	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equals("login")){
			String username = (String) request.getParameter("username");
			String password = (String) request.getParameter("password");
			boolean b = LoginService.isUserAuthenticated(username,password);
			if(b){
				if(username.equals("admin")){
					request.setAttribute("admin", "yes");
					ApplicationSettings applicationSettings = new ApplicationSettings();
					applicationSettings.set_datas(LoginService.getUsersData());
					getServletContext().setAttribute("userList", applicationSettings);
				}
				request.setAttribute("msg", "Welcome " + username+ " !");
				//request.setAttribute("id", LoginService.getUserData(username).getId());
				Cookie myCookie =  new Cookie("id", String.valueOf(LoginService.getUserData(username).getId()));
				response.addCookie(myCookie);
			}
			else{
				request.setAttribute("msg", "Wrong username or password !");
			}
			
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
	    	dispatcher.forward(request, response);
		}
		else{
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				cookie.setValue(null);
				response.addCookie(cookie);
			}
			
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
	    	dispatcher.forward(request, response);
		}

	}

}
