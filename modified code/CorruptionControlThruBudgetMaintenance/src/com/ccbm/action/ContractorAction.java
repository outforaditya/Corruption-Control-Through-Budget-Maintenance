package com.ccbm.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.bean.LoginBean;
import com.ccbm.delegate.RegisterMgrDelegate;

public class ContractorAction extends HttpServlet {

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


		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String ta=request.getParameter("ta");
		String deptname=request.getParameter("dept");
		String dist=request.getParameter("dist");
		String workname=request.getParameter("workname");
		
		LoginBean lb=new LoginBean();
		boolean flag=false;
		String path="";
		try{
			
	    lb.setDeptname(deptname) ;
		lb.setDistname(dist);
		lb.setWorkname(workname);
		
		lb.setUsername(username);
		lb.setPassword(password);
		lb.setName(name);
		lb.setTa(ta);
		
		
	     flag=new RegisterMgrDelegate().insertContractor(lb);
		}catch (Exception e) {
			 //
			path="./jsps/contractorrequeststatus.jsp";
			request.setAttribute("status", "Request failed ...try again");
			}
			    
			if(flag){
				 System.out.println("5......3");
				path="./jsps/contractorrequeststatus.jsp";
				request.setAttribute("status", "Request posted succesfully.. View Status later");
			}
			else {
				 System.out.println("5......4");
				 path="./jsps/contractorrequeststatus.jsp";
				 request.setAttribute("status", "Request failed.....Try after some time");
			}
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		}

	}
