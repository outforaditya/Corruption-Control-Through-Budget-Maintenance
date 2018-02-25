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
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class DistributeBudgettoWorkAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		       doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String distbudgetid=request.getParameter("distbudgetid");
			System.out.println("role.........>"+distbudgetid);
			String path="";
			Vector<BudgetBean> vb=null;
			
			try{
				
				try{
					
					vb=new RegisterMgrDelegate().viewDistBudgetofDept(distbudgetid);
					
				}
				catch (ConnectionException e) {
					
					throw new ServletException("Connection Failed");
					}
				catch (DataNotFoundException e) {
					
					throw new ServletException("Data not Found");
					}
				
				if(!vb.isEmpty()){
					
					//request.setAttribute("status", UtilConstants._DEPT_OFFICERS_DETAILS);
					
					request.setAttribute("distbudget", vb);
					   
				    path=UtilConstants._WORKFUND_DISTRIBUTION;
				}
				else if(vb.isEmpty())
				{
					
					request.setAttribute("status", UtilConstants._NO_STATEBUDGET);
					path=UtilConstants._VIEW_DISTBUDGET1;
					
				}
				
			}
			catch (Exception e) {
				
				request.setAttribute("status", UtilConstants._NO_STATEBUDGET);
				path=UtilConstants._VIEW_DISTBUDGET1;
			}
			RequestDispatcher rd=request.getRequestDispatcher(path);
			
			rd.forward(request, response);
			
			

		
	}

	}
