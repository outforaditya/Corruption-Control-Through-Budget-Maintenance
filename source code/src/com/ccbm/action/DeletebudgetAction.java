package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.delegate.RegisterMgrDelegate;

public class DeletebudgetAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		
		String dept=request.getParameter("dept");
		String subdept=request.getParameter("subdept");
		boolean flag=false;
		
		String path="";
		
	       try{
				
				flag=new RegisterMgrDelegate().deleteBudget(dept,subdept);
				
				System.out.println("flag is========"+flag);
				
				
				
				if(flag){
					
					request.setAttribute("status",  dept+" and "+subdept+" budget deleted");
					
					path="./jsps/adminhome.jsp";
					
					
				}
				else
				{
					
	              request.setAttribute("status", "Deletion failed.. try later");
					
	              path="./jsps/adminhome.jsp";
					
				}
				}
			catch (Exception e) {
				
				
				
				request.setAttribute("status",  "Deletion failed.. try later");
				
				path="./jsps/adminhome.jsp";
				
			}
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
			
			
		}
			
			
			
			
		}
