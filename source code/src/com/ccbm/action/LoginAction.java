package com.ccbm.action;

import java.io.IOException;

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

public class LoginAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		LoginBean lb = new LoginBean();
		String username = request.getParameter("username");
		System.out.println(username + "..  .. ..");
		lb.setUsername(username);
		String password = request.getParameter("password");
		System.out.println(password + "..  .. ..");
		lb.setPassword(password);
		String target = "";
		String role = "";

		try {

			role = (String) new RegisterMgrDelegate().roleCheck(lb);
			if (role.equalsIgnoreCase(UtilConstants._ADMIN)) {

				request.setAttribute("status", "Welcome " + username);

				target = UtilConstants._ADMIN_HOME;

				session.setAttribute(UtilConstants._LOGINUSER, username);
				session.setAttribute(UtilConstants._ROLE, role);
				session.setAttribute(UtilConstants._PASSWORD, password);

			}

			else if (role.equalsIgnoreCase(UtilConstants._DEPT_OFFICER)) {

				request.setAttribute("status", "Welcome " + username);

				target = UtilConstants._DEPT_OFFICER_HOME;

				session.setAttribute(UtilConstants._LOGINUSER, username);
				session.setAttribute(UtilConstants._ROLE, role);
				session.setAttribute(UtilConstants._PASSWORD, password);

			} else if (role.equalsIgnoreCase(UtilConstants._DIST_OFFICER)) {

				request.setAttribute("status", "Welcome " + username);

				target = UtilConstants._DIST_OFFICER_HOME;

				session.setAttribute(UtilConstants._LOGINUSER, username);
				session.setAttribute(UtilConstants._ROLE, role);
				session.setAttribute(UtilConstants._PASSWORD, password);

			}

			else {
				request.setAttribute("status", UtilConstants._INVALID_USER);

				target = UtilConstants._LOGIN_FAILED;
			}
		
		} catch (ConnectionException e) {
			request.setAttribute("status", UtilConstants._SERVER_BUSY);
			target = UtilConstants._LOGIN_FAILED_PAGE;
		} catch (LoginException e) {

			request.setAttribute("status", UtilConstants._INVALID_USER);
			target = UtilConstants._LOGIN_FAILED_PAGE;

		} catch (Exception e) {

			request.setAttribute("status", UtilConstants._SERVER_BUSY);
			target = UtilConstants._LOGIN_FAILED_PAGE;

		}

     finally{

		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
     }
	}
}
