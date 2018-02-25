package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.bean.FeedbackBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.util.UtilConstants;

public class QueryAction extends HttpServlet {

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

		
		
		String path="";
		boolean flag=false;
		
		FeedbackBean fb=new FeedbackBean();
		fb.setUserid(request.getParameter("from"));
		fb.setQuery(request.getParameter("query"));
		fb.setQdate(request.getParameter("date"));
		fb.setTo(request.getParameter("to"));
		try{
			
			flag=new RegisterMgrDelegate().addQuery(fb);
			
			System.out.println("flag is========"+flag);
			
			
			
			if(flag==true){
				
				request.setAttribute("status", UtilConstants._QUERY_INSERTED);
				
				path="./jsps/queryhome.jsp";
				
				
			}
			else
			{
				
              request.setAttribute("status", UtilConstants._QUERY_NOTINSERTED);
				
              path="./jsps/queryhome.jsp";
				
			}
			}
		catch (Exception e) {
			
			
			
			request.setAttribute("status", UtilConstants._QUERY_NOTINSERTED);
			
			path="./jsps/queryhome.jsp";
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}
		
		
		
		
	}
