package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.delegate.RegisterMgrDelegate;

public class InsertWorkBudgetAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	  doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String workname=request.getParameter("workname");
		String lastdate=request.getParameter("dob");
		String targetdate=request.getParameter("dob1");
		String name=request.getParameter("name");
		String amount=request.getParameter("amount");
		String year=request.getParameter("year");
		String distbudgetid=request.getParameter("distbudgetid");
		System.out.println("=================="+distbudgetid);
		boolean flag=false;
		String path="";
		try{
			
		BudgetBean tb=new BudgetBean();
		
		tb.setWorkname(workname);
		tb.setLastdate(lastdate);
		tb.setTargetdate(targetdate);
		tb.setDistributedby(name);
		tb.setAmount(amount);
		tb.setYear(year);
		tb.setDistbudgetid(distbudgetid);
		flag=new RegisterMgrDelegate().insertworkbudget(tb);
		}catch (Exception e) {
			 //
			path="./jsps/distcohome.jsp";
			request.setAttribute("status", "try again");
			}
			    
			if(flag){
				 System.out.println("5......3");
				path="./jsps/distcohome.jsp";
				request.setAttribute("status", "District Budget Distributed");
			}
			else {
				 System.out.println("5......4");
				 path="./jsps/distcohome.jsp";
				 request.setAttribute("status", "Try after some time");
			}
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		}

	}