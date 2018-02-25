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

public class ViewWorkDetailsforCitizenAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String deptname=request.getParameter("deptname");
		String distname=request.getParameter("distname");
		System.out.println(" in action --------->>>"+deptname);
		System.out.println(" in action --------->>>"+distname);
		Vector<TransactionBean> bb=null;
		  String path="",path1="";
		 try {
			 path1=request.getRealPath("/images");
			 System.out.println("Action1");
			 
				bb=new RegisterMgrDelegate().viewWorkDetails(deptname,distname,path1);
				 if(bb==null)
					{
						
						request.setAttribute("status",UtilConstants._NO_WORKS);
							path=UtilConstants._CITIZEN_HOME;
					}
						
					   else 
					{
						
						     request.setAttribute("trans",bb);
							path=UtilConstants._WORKDETAILS;
					}
				
				
			} catch (DataNotFoundException e) {
				
				request.setAttribute("status",UtilConstants._NO_WORKS);
				path=UtilConstants._CITIZEN_HOME;
				
			} catch (ConnectionException e) {
				request.setAttribute("status",UtilConstants._NO_WORKS);
				path=UtilConstants._CITIZEN_HOME;
			}
		  
		
     RequestDispatcher rd=request.getRequestDispatcher(path);
	
	        rd.forward(request, response);
	}




		    
	}


