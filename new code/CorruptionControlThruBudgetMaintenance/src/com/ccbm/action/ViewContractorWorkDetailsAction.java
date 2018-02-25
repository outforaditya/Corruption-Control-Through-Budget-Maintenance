package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class ViewContractorWorkDetailsAction extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("user");
		
		System.out.println("username"+username);
		
		Vector<TransactionBean> bb=null;
		  String path="";
		  String path1="";
		 try {
			 path1=request.getRealPath("/images");
			 System.out.println("Action1");
			 
				bb=new RegisterMgrDelegate().viewContractorWorksDetails(username,path1);
				 System.out.println("Action2");
				
			} catch (DataNotFoundException e) {
				System.out.println("....Servlet Action");
				request.setAttribute("status",UtilConstants._NO_WORKS);
				path=UtilConstants._CONTRACTOR_HM;
				
			} catch (ConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   if(bb==null)
		{
			
			request.setAttribute("status",UtilConstants._NO_WORKS);
				path=UtilConstants._CONTRACTOR_HM;
		}
			
		   else if(!bb.isEmpty())
		{
			
			     request.setAttribute("trans",bb);
				path=UtilConstants._WORKUPDATION;
		}
		
     RequestDispatcher rd=request.getRequestDispatcher(path);
	
	        rd.forward(request, response);
	}




		    
	}

