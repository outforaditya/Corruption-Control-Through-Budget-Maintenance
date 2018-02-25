package com.ccbm.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.util.UtilConstants;

/**
 * 
 * Class For Check Contractor user id Available or Not
 *
 */
public class ChekContractorUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="";
		boolean flag=false;
		String target="./jsps/registrationform.jsp";
		try{
			String userid=request.getParameter("userName");
			//String role=request.getParameter("role");
     		flag=new RegisterMgrDelegate().checkAvailability(userid);
					if(flag==false){
				request.setAttribute("status", UtilConstants._USER_AVAILABLE);
				path=target;
			}
			else
			{
              request.setAttribute("status", UtilConstants._USER_NO_AVAILABLE);
              path=target;
				
			}
			}
		catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("status", UtilConstants._INVALIED_ENTRY);
			
			path=target;
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}

	
}
