package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccbm.bean.RegisterBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class RecoverPasswordAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
		RequestDispatcher rd=null;

		String pass="";
		String path="";
		
	RegisterBean rb=new RegisterBean();
		
		
		
	 
		
	try{
		
		try{
			rb.setUserName(request.getParameter("username"));
			rb.setSquest(request.getParameter("squest"));
			rb.setSecrete(request.getParameter("sanswer"));
		    System.out.println(".."+request.getParameter("username"));
	
		    
		    
		          
		  pass=new RegisterMgrDelegate().passwordRecovery(rb);
		    	
	     System.out.println("password.........>"+pass);
		
	}
	    catch (DataNotFoundException ce) {
		throw new ServletException("server busy please try again");
	    }
	    
	   if(pass.equalsIgnoreCase("nopassword")){
		   
         request.setAttribute("status", UtilConstants._RECOVER_PASSWORD_FAILED);
		   
		   path=UtilConstants._RECOVER_PASSWORD;
		   
		   
		  
		   
		    }
	   else{
           request.setAttribute("status", UtilConstants._RECOVER_PASSWORD_SUCCESS+pass);
		   
		   path=UtilConstants._LOGIN_PAGE;
		   System.out.println("password.........>"+pass);
		   }
		    	
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
		
		
		request.setAttribute("status", "INVALID ENTRIES");
		   
		    path = UtilConstants._RECOVER_PASSWORD;
		
}
	
	rd=request.getRequestDispatcher(path);
	
	rd.forward(request, response);

}
		
	}


