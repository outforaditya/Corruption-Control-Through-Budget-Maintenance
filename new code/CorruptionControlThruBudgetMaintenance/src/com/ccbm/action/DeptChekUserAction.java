package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.util.UtilConstants;

public class DeptChekUserAction extends HttpServlet {

private static final long serialVersionUID = 1L;


	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String path="";
		boolean flag=false;
		
		String target="./jsps/adddepartmentofficers.jsp";
		String deptname=request.getParameter("deptname");
		
		try{
			
			
			String userid=request.getParameter("userName");
			String role=request.getParameter("role");
			
			System.out.println("in check user availability.........userid....."+userid);
			
			
			
			
			flag=new RegisterMgrDelegate().checkAvailability(userid);
			
			System.out.println("flag is========"+flag);
			
			
			
			if(flag==false){
				
				request.setAttribute("status", UtilConstants._USER_AVAILABLE);
				request.setAttribute("departmentname",deptname);
				
				path=target;
				
				
			}
			else
			{
				
              request.setAttribute("status", UtilConstants._USER_NO_AVAILABLE);
				
              request.setAttribute("departmentname",deptname);
              path=target;
				
			}
			}
		catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("departmentname",deptname);
			request.setAttribute("status", UtilConstants._INVALIED_ENTRY);
			
			path=target;
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}

	
}
