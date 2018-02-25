package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccbm.bean.LoginBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.LoginException;
import com.ccbm.util.UtilConstants;

public class ContractorLoginAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
	     LoginBean lb=new LoginBean();
	     String username=request.getParameter("username");
	     System.out.println(username+"..  .. ..");
	     lb.setUsername(username);
	     String password=request.getParameter("password");
	     System.out.println(password+"..  .. ..");
	     lb.setPassword(password);
	     String target="";
	     String role="";
	     
	    try{	 
	    	 
	           role=(String)new RegisterMgrDelegate().roleCheck(lb);
	           System.out.println("in LoginAction Role is.........."+role);
	}catch (ConnectionException e) {
		
		throw new ServletException("Server busy Plz Try after Some time");
	}
	catch (LoginException e) {
		
		request.setAttribute("status", UtilConstants._INVALID_USER);
  	    RequestDispatcher rd = request.getRequestDispatcher(UtilConstants._CONTRACTOR_LOGIN_FAILED_PAGE);
		rd.forward(request, response);
		
		}

	System.out.println("in LoginAction Role is.........."+role);

	
	if (role.equalsIgnoreCase(UtilConstants._CONTRACTOR))
	{
		
       request.setAttribute("status","Welcome " + username );
		
		target = UtilConstants._CONTRACTOR_HOME;
		
		session.setAttribute(UtilConstants._LOGINUSER, username);
		session.setAttribute(UtilConstants._ROLE, role);
		session.setAttribute(UtilConstants._PASSWORD,password);
		
	}
	else
	{
		request.setAttribute("status", UtilConstants._INVALID_USER);
		
		target = UtilConstants._CONTRACTOR_LOGIN_FAILED_PAGE;
	}
	
	RequestDispatcher rd = request.getRequestDispatcher(target);
	rd.forward(request, response);
		

}
}

