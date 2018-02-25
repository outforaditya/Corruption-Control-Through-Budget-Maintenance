package com.ccbm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccbm.bean.FeedbackBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.util.UtilConstants;

public class ReplytoQueryAction extends HttpServlet {

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
         String userid=(String)session.getAttribute("user");
		String qid=request.getParameter("qid");
		session.setAttribute("qid",qid);
		String ans=request.getParameter("ans");
		String adate=request.getParameter("date");
		FeedbackBean fb=new FeedbackBean();
		fb.setAdate(adate);
		fb.setAns(ans);
		fb.setQid(qid);
		fb.setUserid(userid);
		boolean flag=false;
		String path="";
		
try{
			
			flag=new RegisterMgrDelegate().replyToQuery(fb);
			
			System.out.println("flag is========"+flag);
			
			
			
			if(flag==true){
				
				request.setAttribute("status", "Reply Posted");
				
				path="./jsps/queryhome.jsp";
				
				
			}
			else
			{
				
              request.setAttribute("status", "Reply failed");
				
              path="./jsps/queryhome.jsp";
				
			}
			}
		catch (Exception e) {
			
			
			
			request.setAttribute("status", UtilConstants._QUERY_NOTINSERTED);
			
			path="./jsps/queryhome.jsp";
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
	}
		
		
		
		
	}
