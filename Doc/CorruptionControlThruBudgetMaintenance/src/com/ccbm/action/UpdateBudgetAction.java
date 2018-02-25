package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

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

public class UpdateBudgetAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("user");
		boolean flag=false;
		String path="";
		
		try{
		BudgetBean tb=new BudgetBean();
		//tb.setUserid(username);
		tb.setDeptname(request.getParameter("dept"));
		tb.setSubdeptname(request.getParameter("subdept"));
		tb.setYear(request.getParameter("year"));
		tb.setAmount(request.getParameter("amt"));
		
		
		
		    flag=new RegisterMgrDelegate().updateBudget(tb); 
		  }
		 catch (ConnectionException ce) {
			 System.out.println("8");
			throw new ServletException("Connection Failed");
			
		}
		    
		if(flag){
			 System.out.println("5......3");
			path="./jsps/adminhome.jsp";
			request.setAttribute("status", "Budget details updated");
		}
		else {
			 System.out.println("5......4");
			path="./jsps/adminhome.jsp";
			request.setAttribute("status", "Updation failed");
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}