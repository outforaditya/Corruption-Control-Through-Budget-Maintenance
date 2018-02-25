package com.ccbm.action;

import java.io.IOException;

import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;


public class RequesttoBudgetAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			 
			/*SecureRandom r = new SecureRandom();
			 
			int randnumb = r.nextInt();
			 System.out.println(randnumb);
			if(randnumb<0)
			 
			randnumb=randnumb*(-1);
			 
			StringBuffer newPassword = new StringBuffer();
			 
			//newPassword.append(“prj_name”);
			 
			newPassword.append(String.valueOf(randnumb));
		
			String psw="Dept"+newPassword;
			 
			//return newPassword.toString();
			System.out.println(newPassword+"------>");
			System.out.println(psw);
			 */
		    HttpSession session=request.getSession();
		    String transactionid=null;
		    String path=null;
		    String username=request.getParameter("loginid");
		    String password=request.getParameter("password");
		    String dob=request.getParameter("dob");	    	
		    		try {
						transactionid=new RegisterMgrDelegate().checkUser(dob,username,password);
						
				   if(transactionid==null||transactionid.equalsIgnoreCase("No password Generated.. "))
		    		{
		    			
		    			request.setAttribute("status",UtilConstants._INVALIED_ENTRY );
						path=UtilConstants._VIEW_BUDGETREQ;
		    		}
					
				   else if(transactionid!=null)
		    		{
		    			System.out.println("---"+transactionid);
					   request.setAttribute("trans",transactionid);
						path=UtilConstants._VIEW_TRANSACTIONIDPAGE;
		    		}
		    		}catch(Exception e){
		    			request.setAttribute("status",UtilConstants._INVALIED_ENTRY );
						path=UtilConstants._VIEW_BUDGETREQ;	
		    		}
		    		finally{
                    RequestDispatcher rd=request.getRequestDispatcher(path);
			        rd.forward(request, response);
		    		}
			}
		
		
	}


