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

public class DeleteQueryAction extends HttpServlet {

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
           
		
		String qid=request.getParameter("qid");
		boolean flag=false;
		String path="";
		
try{
			
			flag=new RegisterMgrDelegate().deleteQuery(qid);
			
			System.out.println("flag is========"+flag);
			
			
			
			if(flag==true){
				
				request.setAttribute("status", "Query deleted");
				
				path="./jsps/queryhome.jsp";
				
				
			}
			else
			{
				
              request.setAttribute("status", "Query deletion failed.. try later");
				
              path="./jsps/queryhome.jsp";
				
			}
			}
		catch (Exception e) {
			
			
			
			request.setAttribute("status",  "Query deletion failed.. try later");
			
			path="./jsps/queryhome.jsp";
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}
		
		
		
		
	}
