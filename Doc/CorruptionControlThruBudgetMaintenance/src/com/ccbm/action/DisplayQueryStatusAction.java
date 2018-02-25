package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.FeedbackBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class DisplayQueryStatusAction extends HttpServlet {

	
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

		String loginid=request.getParameter("uname");
		 
		String path="";
		Vector<FeedbackBean> vb=null;
		
		
			
			try{
				System.out.println("1");
				vb=new RegisterMgrDelegate().viewQuerySolution(loginid);
				
				
				if(!vb.isEmpty()){
					System.out.println("3");
					//request.setAttribute("status", UtilConstants._DEPT_OFFICERS_DETAILS);
					
					request.setAttribute("answer",vb);
					   
					    	
					path=UtilConstants._VIEW_SOLUTIONS;
				}	
				
			}
			catch (ConnectionException e) {
				System.out.println("2");
				request.setAttribute("status", "No replies...");
				path=UtilConstants._CITIZEN_HOME;
				}
			catch (DataNotFoundException e) {
				System.out.println("2.1");
				request.setAttribute("status", "No replies...");
				path=UtilConstants._CITIZEN_HOME;
				}
			catch (Exception e) {
				System.out.println("5");
				
				request.setAttribute("status", "No replies...");
				path=UtilConstants._CITIZEN_HOME;
			}
			
			
			
			
		
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);
		
		

	
}

}