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
import com.ccbm.bean.TransactionBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class ViewContractorApplicationAction extends HttpServlet {

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
		 
		
		
		Vector<TransactionBean> bb=null;
		  String path="";
		 try {
			 
			
			 
				bb=new RegisterMgrDelegate().viewContractorApplication(loginid);
				 
				
			} catch (DataNotFoundException e) {
				
				request.setAttribute("status","No Application");
				path=UtilConstants._DIST_OFFICER_HOME;
				
			} catch (ConnectionException e) {
				request.setAttribute("status","Try later...");
				path=UtilConstants._DIST_OFFICER_HOME;
			}
		   if(bb==null)
		{
			
			request.setAttribute("status","No Applications");
				path=UtilConstants._DIST_OFFICER_HOME;
		}
			
		   else 
		{
			
			     request.setAttribute("trans",bb);
				path=UtilConstants._CONTRACTORS_APPLICATION;
		}
		
     RequestDispatcher rd=request.getRequestDispatcher(path);
	
	        rd.forward(request, response);
	}




		    
	}

