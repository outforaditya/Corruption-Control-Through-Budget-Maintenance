package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.util.UtilConstants;

public class ContractorStatusAction extends HttpServlet {

	
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
		System.out.println("user"+username);
		try{
			flag=new RegisterMgrDelegate().checkContractorshipStatus(username); 
             if(flag==false){
				
				request.setAttribute("status", UtilConstants._STATUS_NO);
				
				path="./jsps/contractorrequeststatus.jsp";
				
				
			}
			else
			{
				
              request.setAttribute("status", UtilConstants._STATUS_YES);
				
              path="./jsps/contractortransactions.jsp";
				
			}
			}
		catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("status", UtilConstants._STATUS_NO);
			
			path="./jsps/contractorrequeststatus.jsp";
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}

	
}
