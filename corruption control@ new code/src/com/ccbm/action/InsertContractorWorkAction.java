package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccbm.bean.TransactionBean;
import com.ccbm.delegate.RegisterMgrDelegate;

public class InsertContractorWorkAction extends HttpServlet {

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

		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("user");
        System.out.println("username"+username);
		String workname=request.getParameter("workname");
		String deptname=request.getParameter("dept");
		String noofworkers=request.getParameter("number");
		String startdate=request.getParameter("dob");
		String enddate=request.getParameter("dob1");
		String releasedamt=request.getParameter("amount");
		
		String spentamt=request.getParameter("spent");
		String status=request.getParameter("status");
		String photo=request.getParameter("photo");
		boolean flag=false;
		String path="";
		try{
			
		TransactionBean tb=new TransactionBean();
		
		tb.setWorkname(workname);
		tb.setDeptname(deptname);
		tb.setSpentamount(spentamt);
		tb.setAmount(releasedamt);
		tb.setPhoto(photo);
		System.out.println("username"+username);
		tb.setUserid(username);
		tb.setStartdate(startdate);
		tb.setLastdate(enddate);
		tb.setNoofworkers(noofworkers);
		tb.setStatus(status);
		flag=new RegisterMgrDelegate().insertcontractorworkdetails(tb);
		System.out.println("flag....."+flag);
		}catch (Exception e) {
			 //
			path="./jsps/contractortransactions.jsp";
			request.setAttribute("status", "try again");
			}
			    
			if(flag){
				 System.out.println("5......3");
				path="./jsps/contractortransactions.jsp";
				request.setAttribute("status", "Data Inserted");
			}
			else {
				 System.out.println("5......4");
				 path="./jsps/contractortransactions.jsp";
				 request.setAttribute("status", "Your  Data already Inserted.. If want to modify data Please Update");
			}
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		}

	}