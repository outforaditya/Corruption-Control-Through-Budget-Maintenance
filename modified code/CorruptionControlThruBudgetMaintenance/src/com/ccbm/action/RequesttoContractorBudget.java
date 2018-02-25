package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class RequesttoContractorBudget extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		      doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 HttpSession session=request.getSession();
		    String transactionid=null;
		    String path=null;
		    String username=request.getParameter("loginid");
		    String password=request.getParameter("password");
		    String dob=request.getParameter("dob");
		   

		    	
		    		try {
						transactionid=new RegisterMgrDelegate().checkUser(dob,username,password);
				   if(transactionid==null||transactionid.equalsIgnoreCase("No password Generated.. "))
		    		{
		    			
		    			request.setAttribute("status",UtilConstants._INVALIED_ENTRY );
						path=UtilConstants._VIEW_CONTRACTOR_BUDGETREQ;
		    		}
					
				   else if(transactionid!=null)
		    		{
		    			System.out.println("---"+transactionid);
					   request.setAttribute("trans",transactionid);
						path=UtilConstants._VIEW_CONTRACTOR_TRANSACTIONIDPAGE;
		    		}
		    		
		    		}
		    
		   catch(Exception e){
			   request.setAttribute("status",UtilConstants._INVALIED_ENTRY );
				path=UtilConstants._VIEW_CONTRACTOR_BUDGETREQ;
		   }
		   finally{
         RequestDispatcher rd=request.getRequestDispatcher(path);
			
			       rd.forward(request, response);
			}
	}
	}
