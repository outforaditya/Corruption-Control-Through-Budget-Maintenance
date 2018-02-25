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

public class ViewQueryAction extends HttpServlet {

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
		Vector<FeedbackBean> vb=null;
		
		try{
			
			try{
				
				vb=new RegisterMgrDelegate().viewQuery();
				
			}
			catch (ConnectionException e) {
				
				throw new ServletException("Connection Failed");
				}
			catch (DataNotFoundException e) {
				
				throw new ServletException("Data not Found");
				}
			
			if(!vb.isEmpty()){
				
				
				
				request.setAttribute("query", vb);
				    
				    	path=UtilConstants._VIEW_QUERY;
			}	
			else if(vb.isEmpty())
			{
			
				request.setAttribute("status", "NO QUERIES");
				path=UtilConstants._VIEW_QUERY;
				
			}
			
		}
		catch (Exception e) {
			
			request.setAttribute("status", "NO QUERIES");
			path=UtilConstants._VIEW_QUERY;
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);
		
		

	
}

}