package com.ccbm.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.util.UtilConstants;

/**
 * 
 * Class for AcceptContractor.
 * This is used to accept contractor by District Budget officer.
 * It is verifies contractor acceptance based on contractor's id.
 *
 */
public class AcceptContractorAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         String cid=request.getParameter("cid");
		boolean flag=false;
		  String path="";
		 try {
			 
				flag=new RegisterMgrDelegate().acceptContractor(cid);
				
			}  catch (ConnectionException e) {
				e.printStackTrace();
				request.setAttribute("status", e.getMessage());
				path=UtilConstants._CONTRACTORS_APPLICATION1;
			}
			catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("status",UtilConstants._NO_DATAA);
				path=UtilConstants._CONTRACTORS_APPLICATION1;
			}
		   if(flag)
		{
			   request.setAttribute("flag","yes");
			   request.setAttribute("status","Contractorship Accepted");
			   path=UtilConstants._CONTRACTORS_APPLICATION1;
		}
		   else 
		{
			
			     request.setAttribute("status","Already Accepted");
			     request.setAttribute("flag","no");
				 path=UtilConstants._CONTRACTORS_APPLICATION1;
		}
		
           RequestDispatcher rd=request.getRequestDispatcher(path);
	        rd.forward(request, response);
	}    
	}

