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
import com.ccbm.bean.RegisterBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class ViewDeptOffAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		 String path="";
			String dept=request.getParameter("dept");
			Vector<RegisterBean> vdo=null;
			
			try{
				
				try{
					
					vdo=new RegisterMgrDelegate().viewDeptOfficers(dept);
					
				}
				catch (ConnectionException e) {
					
					throw new ServletException("Connection Failed");
					}
				catch (DataNotFoundException e) {
					
					throw new ServletException("Data not Found");
					}
				
				if(!vdo.isEmpty()){
					
					request.setAttribute("status", UtilConstants._DEPT_OFFICERS_DETAILS);
					request.setAttribute("dept",dept);
					request.setAttribute("deptofficers",vdo);
					//session.setAttribute("deptofficers", vdo);
					
					path=UtilConstants._VIEW_DEPT_OFFICERS;
			
				}
				else
				{
					
					request.setAttribute("status", UtilConstants._NO_DEPT_OFFICERS_DETAILS);
					path=UtilConstants._VIEW_DEPT_OFFICERS;
					
				}
				
			}
			catch (Exception e) {
				
				request.setAttribute("status", UtilConstants._INVALIED_ENTRY);
				path=UtilConstants._VIEW_DEPT_OFFICERS;
				
			}
			RequestDispatcher rd=request.getRequestDispatcher(path);
			
			rd.forward(request, response);
			
			
			
		}
				
			}


