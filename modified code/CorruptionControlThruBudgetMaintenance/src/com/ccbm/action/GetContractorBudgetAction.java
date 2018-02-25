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

import com.ccbm.bean.TransactionBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class GetContractorBudgetAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  HttpSession session=request.getSession();
		  String loginid=(String) session.getAttribute("user");
		  String transid=request.getParameter("password");
		  TransactionBean tb=new TransactionBean();
		  Vector<TransactionBean> vb=null;
		  String path="";
		  try {
				vb=new RegisterMgrDelegate().checkContractortransaction(loginid,transid);
				 if(vb.isEmpty())
			  		{
			  			
			  			request.setAttribute("status",UtilConstants._NO_DATAA );
							path=UtilConstants._CONTRACTOR_HM;
			  		}
						
					   else 
			  		{
			  			
						   request.setAttribute("trans",vb);
							path=UtilConstants._CONTRACTORS_WORKAMOUNT;
			  		}
				
			} catch (DataNotFoundException e) {
				request.setAttribute("status",UtilConstants._INVALIED_ENTRY );
				path=UtilConstants._CONTRACTOR_HM;
				
			} catch (ConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
  		
            RequestDispatcher rd=request.getRequestDispatcher(path);
	
	        rd.forward(request, response);
	}


}
