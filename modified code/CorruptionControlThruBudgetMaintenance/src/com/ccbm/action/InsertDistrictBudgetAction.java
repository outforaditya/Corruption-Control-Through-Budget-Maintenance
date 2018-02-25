package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.bean.TransactionBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;

public class InsertDistrictBudgetAction extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		  doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          
		
		String deptname=request.getParameter("deptname");
		String subdeptname=request.getParameter("subdept");
		String dname=request.getParameter("dname");
		String amount=request.getParameter("amount");
		String year=request.getParameter("year");
		String availfund=request.getParameter("availfund");
		
		boolean flag=false;
		String path="";
		try{
			
		TransactionBean tb=new TransactionBean();
		
		tb.setDeptname(deptname);
		tb.setSubdeptname(subdeptname);
		tb.setAmount(amount);
		tb.setYear(year);
		tb.setDistrict(dname);
		tb.setAvailfund(availfund);
		//flag=new RegisterMgrDelegate().insertdistrictbudget(tb);
		flag=new RegisterMgrDelegate().insertdistbudget(tb);
		}catch (Exception e) {
			 //
			path="./jsps/deptofficerhome.jsp";
			request.setAttribute("status", "try again");
			}
			    
			if(flag){
				 System.out.println("5......3");
				path="./jsps/deptofficerhome.jsp";
				request.setAttribute("status", "District Budget Distributed");
			}
			else {
				 System.out.println("5......4");
				 path="./jsps/deptofficerhome.jsp";
				 request.setAttribute("status", "Try after some time...and Provide correct Data");
			}
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		}

	}