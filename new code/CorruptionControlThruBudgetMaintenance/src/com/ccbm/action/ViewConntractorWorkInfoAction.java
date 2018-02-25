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

public class ViewConntractorWorkInfoAction extends HttpServlet {

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
         System.out.println("user.........>>>"+loginid);
		Vector<BudgetBean> bb=null;
		  String path="";
		 try {
			 
			 System.out.println("Action1");
			 
				bb=new RegisterMgrDelegate().viewContractorWorkDetails(loginid);
				 System.out.println("Action2");
				
			} catch (DataNotFoundException e) {
				System.out.println("....123");
				request.setAttribute("status","Update work details");
				path="./jsps/contractortransactions.jsp";
				
			} catch (ConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   if(bb==null)
		{
			
			request.setAttribute("status","Update work details");
				path="./jsps/contractortransactions.jsp";
		}
			
		   else 
		{
			
			     request.setAttribute("trans",bb);
				path=UtilConstants._CONTRACTORS_WORKINFO;
		}
		
       RequestDispatcher rd=request.getRequestDispatcher(path);
	
	        rd.forward(request, response);
	}




		    
	}

