package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.bean.TransactionBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class DistributeBudgettoDistrictsAction extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		     doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptname=request.getParameter("deptname");
		String subdeptname=request.getParameter("subdept");
		String amount=request.getParameter("budget");
		String availfund=request.getParameter("availfund");
		  Vector<TransactionBean> vb=null;
		  String path="";
		  try {
				vb=new RegisterMgrDelegate().viewDistricts();
				
				
			} catch (DataNotFoundException e) {
				
				request.setAttribute("status",UtilConstants._NO_DISTRICTS );
				path=UtilConstants._DIST_PAGE;
				
			} catch (ConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   if(vb==null)
		{
			
			request.setAttribute("status",UtilConstants._NO_DISTRICTS );
				path=UtilConstants._DIST_PAGE;
		}
			
		   else 
		{
			
			   request.setAttribute("district",vb);
			   request.setAttribute("deptname", deptname);
			   request.setAttribute("subdept",subdeptname);
			   request.setAttribute("budget", amount);
			   request.setAttribute("availfund",availfund);
				path=UtilConstants._VIEW_DISTRICTS;
		}
		
          RequestDispatcher rd=request.getRequestDispatcher(path);
	
	        rd.forward(request, response);
	}	
		
	}


