package com.ccbm.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.util.UtilConstants;

/**
 * 
 * Class for Add Departments. This class is used to add departments and sub
 * department under departments.
 * 
 */
public class AddDeptAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dept = request.getParameter("deptname");
		String subdept = request.getParameter("subdeptname");
		String path = "";
		boolean flag = false;
		try {

			flag = new RegisterMgrDelegate().addDept(dept, subdept);
			if (flag == true) {
				request.setAttribute("status", UtilConstants._DEPT_INSERTED);
				path = "./jsps/adminhome.jsp";
			} else {
				request.setAttribute("status", UtilConstants._DEPT_NOTINSERTED);
				path = "./jsps/adddepartment.jsp";
			}
		} catch (ConnectionException e) {
			request.setAttribute("status",e.getMessage());
			path = "./jsps/adddepartment.jsp";

		}
		catch (Exception e) {
			request.setAttribute("status", UtilConstants._DEPT_NOTINSERTED);
			path = "./jsps/adddepartment.jsp";

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
