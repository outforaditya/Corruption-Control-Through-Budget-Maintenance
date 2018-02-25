package com.ccbm.action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.bean.BudgetBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;

public class AddStateBudgetAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String deptname=request.getParameter("dname");
		String subdeptname=request.getParameter("subdeptname");
		String budgetamount=request.getParameter("amount");
		String financialyear=request.getParameter("year");
		String path="";
		boolean flag=false;
		BudgetBean bb=new BudgetBean();
		try{
			  bb.setDeptname(deptname);
			  bb.setSubdeptname(subdeptname);
			  bb.setAmount(budgetamount);
			  bb.setYear(financialyear);
			
			 flag = new RegisterMgrDelegate().addStateBudget(bb);
		}
		 catch (ConnectionException ce) {
		
			throw new ServletException("Connection Failed");
			
		}
		 if(flag){
			 
			path="./jsps/adminhome.jsp";
			request.setAttribute("status", "Budget entered  successfull");
		}
		else {
			
			path="./jsps/adminhome.jsp";
			request.setAttribute("status", "Budget not Entered, first enter department officer");
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}

}
