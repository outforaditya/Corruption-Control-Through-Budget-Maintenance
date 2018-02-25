package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.RegisterBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.util.UtilConstants;

public class ViewDepartmentAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		      doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		    String path="";
			String dept=request.getParameter("dname");
			String dept1=request.getParameter("user");
			
			System.out.println("dept;;;;;>"+dept1);
			Vector<BudgetBean> vb=null;
			
			try{
				
				try{
					
					vb=new RegisterMgrDelegate().viewDepartments();
					
				}
				catch (ConnectionException e) {
					
					throw new ServletException("Connection Failed");
					}
				catch (DataNotFoundException e) {
					
					throw new ServletException("Data not Found");
					}
				
				if(!vb.isEmpty()){
					
					//request.setAttribute("status", UtilConstants._DEPT_OFFICERS_DETAILS);
					System.out.println("1111111");
					request.setAttribute("deptart", vb);
					
					 if(dept1==null){
							path=UtilConstants._VIEW_DEPARTMENTS;
						}
					 else if(dept1.equalsIgnoreCase("deptoff"))
					{
						path=UtilConstants._VIEW_DEPARTOFF;
					}
					
					else if(dept1.equalsIgnoreCase("distoff"))
					{
						path=UtilConstants._VIEW_DISTOFF;
						
					}
					
					
				}	
				else if(vb.isEmpty())
				{
					
					
					System.out.println("2222");
					request.setAttribute("status", UtilConstants._NO_DEPARTMENTS);
					path=UtilConstants._VIEW_DEPARTMENTS;
					
				}
				
			}
			catch (Exception e) {
				
				System.out.println("3333333333");
				request.setAttribute("status", UtilConstants._NO_DEPARTMENTS);
			}
			RequestDispatcher rd=request.getRequestDispatcher(path);
			
			rd.forward(request, response);
			
			

		
	}

}
