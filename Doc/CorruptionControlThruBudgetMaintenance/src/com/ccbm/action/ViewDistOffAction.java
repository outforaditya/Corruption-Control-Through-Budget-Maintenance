package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.bean.RegisterBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class ViewDistOffAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String path="";
		String dist=request.getParameter("dist");
		System.out.println(",,,,"+dist);
		Vector<RegisterBean> vdo=null;
		
		try{
			
			try{
				System.out.println("....."+dist);
				vdo=new RegisterMgrDelegate().viewDistOfficers(dist);
				System.out.println(",,,,"+dist);
				
			}
			catch (ConnectionException e) {
				
				throw new ServletException("Connection Failed");
				}
			catch (DataNotFoundException e) {
				
				throw new ServletException("Data not Found");
				}
			
			if(!vdo.isEmpty()){
				
				request.setAttribute("status", UtilConstants._DEPT_OFFICERS_DETAILS);
				request.setAttribute("dept",dist);
				request.setAttribute("deptofficer",vdo);
				//session.setAttribute("deptofficers", vdo);
				
				path=UtilConstants._VIEW_DIST_OFFICERS1;
		
			}
			else
			{
				
				request.setAttribute("status", "No Data ...");
				path=UtilConstants._VIEW_DIST_OFFICERS1;
				
			}
			
		}
		catch (Exception e) {
			
			request.setAttribute("status", "No Data .");
			path=UtilConstants._VIEW_DIST_OFFICERS1;
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);
		
		
		
	}
			
		}


