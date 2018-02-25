package com.ccbm.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.beanutils.BeanUtils;

import com.ccbm.bean.RegisterBean;
import com.ccbm.delegate.RegisterMgrDelegate;
import com.ccbm.exception.ConnectionException;




public class RegistrationAction extends HttpServlet {

	
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
        boolean flag=false;
        String path="";
        System.out.println("111");
		RegisterBean rb=new RegisterBean();
		System.out.println("2");
		//Map map=request.getParameterMap();
		System.out.println("3");
		
		System.out.println("4");
		 try {
			 RegisterMgrDelegate rmd=new RegisterMgrDelegate();
			 System.out.println("5");
			// BeanUtils.populate(rb, map);
			 rb.setUserName(request.getParameter("userName"));
			 rb.setPassword(request.getParameter("password"));
			 
			 rb.setSquest(request.getParameter("squest"));
			 rb.setSecrete(request.getParameter("secrete"));
			 rb.setRole(request.getParameter("role"));
			 System.out.println("...."+request.getParameter(" role"));
			 rb.setEmail(request.getParameter("email"));
			 rb.setFirstName(request.getParameter("firstName"));
			 rb.setLastName(request.getParameter("lastName"));
			 rb.setGender(request.getParameter("gender"));
			 rb.setDob(request.getParameter("dob"));
			 rb.setHouseNo(request.getParameter("houseNo"));
			 rb.setStreet(request.getParameter("street"));
			 
			 rb.setPhoneNo(request.getParameter("phoneNo"));
			 rb.setDistrict(request.getParameter("district"));
			 rb.setState(request.getParameter("state"));
			 rb.setCountry(request.getParameter("country"));
			 rb.setPin(request.getParameter("pin"));
			 rb.setCity(request.getParameter("city"));
			 rb.setAddressid(request.getParameter("addressid"));
			 rb.setAddresstype(request.getParameter("addresstype"));
			 
			 rb.setPhoto(request.getParameter("photo"));
			 System.out.println("5...1");
			 flag=rmd.registerCitizen(rb);
			 System.out.println("5......2");
			 
			
		} 
		
		 
		 catch (ConnectionException ce) {
			 System.out.println("8");
			throw new ServletException("Connection Failed");
			
		}
		    
		if(flag){
			 System.out.println("5......3");
			path="./jsps/login.jsp";
			request.setAttribute("status", "Registeration is successfull");
		}
		else {
			 System.out.println("5......4");
			path="./jsps/login.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
	}

}
