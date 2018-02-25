package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.delegate.RegisterMgrDelegate;

public class DeleteDeptofficerAction extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 
		String username=request.getParameter("qid");
		boolean flag=false;
		
		String path="";
		
	       try{
				
				flag=new RegisterMgrDelegate().deleteDeptoff(username);
				
				if(flag==true){
					
					request.setAttribute("status", " officer deleted");
					
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
