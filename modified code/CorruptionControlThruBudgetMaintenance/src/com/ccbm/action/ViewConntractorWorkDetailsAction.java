package com.ccbm.action;
import java.io.IOException;

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


public class ViewConntractorWorkDetailsAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
         String loginid=request.getParameter("uname");
         System.out.println("user.........>>>"+loginid);
		Vector<BudgetBean> bb=null;
		  String path="";
		 try {
			 
			 System.out.println("Action1");
			 
				bb=new RegisterMgrDelegate().viewContractorWorkDetails(loginid);
				 System.out.println("Action2");
				
			} catch (DataNotFoundException e) {
				System.out.println("....123");
				request.setAttribute("status",UtilConstants._NO_WORKS);
				path=UtilConstants._CONTRACTOR_HM;
				
			} catch (ConnectionException e) {
				request.setAttribute("status",UtilConstants._NO_WORKS);
				path=UtilConstants._CONTRACTOR_HM;
			}
		   if(bb==null)
		{
			
			request.setAttribute("status",UtilConstants._NO_WORKS);
				path=UtilConstants._CONTRACTOR_HM;
		}
			
		   else if(!bb.isEmpty())
		{
			
			     request.setAttribute("trans",bb);
				path=UtilConstants._CONTRACTORS_WORK_INFO;
		}
		
       RequestDispatcher rd=request.getRequestDispatcher(path);
	
	        rd.forward(request, response);
	}




		    
	}

