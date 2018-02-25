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

import com.ccbm.bean.RegisterBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class GetDeptBudgetAction extends HttpServlet {

	
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
				vb=new RegisterMgrDelegate().checkUsertransaction(loginid,transid);
				 if(vb==null)
			  		{
			  			
			  			request.setAttribute("status",UtilConstants._NO_DATA );
							path=UtilConstants._GET_DEPTBUDGET;
			  		}
						
					   else 
			  		{
			  			
						   request.setAttribute("trans",vb);
							path=UtilConstants._VIEW_DEPTBUDGET;
			  		}
			  		
				
			} catch (DataNotFoundException e) {
				System.out.println("....123");
				request.setAttribute("status",UtilConstants._INVALIED_ENTRY );
				path=UtilConstants._GET_DEPTBUDGET;
				
			} catch (ConnectionException e) {
				System.out.println("123");
				request.setAttribute("status",UtilConstants._INVALIED_ENTRY );
				path=UtilConstants._GET_DEPTBUDGET;
				e.printStackTrace();
			}
		  finally{
            RequestDispatcher rd=request.getRequestDispatcher(path);
	
	        rd.forward(request, response);
	}
	}

}
