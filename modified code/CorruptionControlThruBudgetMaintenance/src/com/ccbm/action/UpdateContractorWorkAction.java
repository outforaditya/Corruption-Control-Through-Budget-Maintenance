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
import com.ccbm.exception.ConnectionException;

public class UpdateContractorWorkAction extends HttpServlet {


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
		TransactionBean tb=new TransactionBean();
		tb.setUserid(username);
		tb.setNoofworkers(request.getParameter("number"));
		tb.setStartdate(request.getParameter("dob"));
		tb.setTargetdate(request.getParameter("dob1"));
		tb.setAmount(request.getParameter("amount"));
		tb.setSpentamount(request.getParameter("spent"));
		tb.setStatus(request.getParameter("status"));
		String photo=request.getParameter("photo");
		String photo1=request.getParameter("photo1");
		if(photo1==null)
			{
			tb.setPhoto(photo);
			}
		else
			{
			tb.setPhoto(photo1);
			}
		
		    flag=new RegisterMgrDelegate().updateContractorwork(tb); 
		}
		 catch (ConnectionException ce) {
			 System.out.println("8");
			throw new ServletException("Connection Failed");
			
		}
		    
		if(flag){
			 System.out.println("5......3");
			path="./jsps/controctorhome.jsp";
			request.setAttribute("status", "Work details updated");
		}
		else {
			 System.out.println("5......4");
			path="./jsps/controctorhome.jsp";
			request.setAttribute("status", "Updation failed");
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}