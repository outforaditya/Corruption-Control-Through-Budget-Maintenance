package com.ccbm.serviceImpl;

import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.FeedbackBean;
import com.ccbm.bean.LoginBean;
import com.ccbm.bean.RegisterBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.daoI.RegisterDaoI;
import com.ccbm.daoImpl.RegisterDaoImpl;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.exception.LoginException;
import com.ccbm.serviceI.RegisterServiceI;

public class RegisterServiceImpl implements RegisterServiceI {
	boolean flag=false;
	Vector<RegisterBean> vdo=null;
	Vector<BudgetBean> vb=null;
	Vector<TransactionBean>tb=null;
	Vector<FeedbackBean> fb=null;
	RegisterDaoI rdao=new RegisterDaoImpl();

 public boolean checkAvailability(String userid)throws ConnectionException{
		 
		 flag=rdao.checkAvailability(userid);
		 
		 
			return flag;
		 
	 }
 
 
 public boolean addDept(String dept,String subdept)throws ConnectionException{
	 
	 flag=rdao.addDept(dept,subdept);
	 
	 
		return flag;
	 
 }
 
 
 

public boolean registerCitizen(RegisterBean rb) throws ConnectionException {
	
	
		flag=rdao.registerCitizen(rb);
		return flag;
    }

public boolean addFeedback(FeedbackBean fb) throws ConnectionException {
	
	 
		flag=rdao.addFeedback(fb);
	
		return flag;
   }


public boolean addQuery(FeedbackBean fb) throws ConnectionException {
	
		flag=rdao.addQuery(fb);
	
		return flag;
  }


public boolean replyToQuery(FeedbackBean fb) throws ConnectionException {
	
	 
		flag=rdao.replyToQuery(fb);
		return flag;
 }

public boolean deleteQuery(String qid) throws ConnectionException {
	
	
		flag=rdao.deleteQuery(qid);
		return flag;
}

public String passwordRecovery(RegisterBean rb)throws ConnectionException,DataNotFoundException{
	 
	 String password=rdao.passwordRecovery(rb);
	
		return password;
	 
	 
}

public String checkUser(String dob,String username,String password)throws ConnectionException{
	 
	 String transpassword=rdao.checkUser(dob,username,password);
		return transpassword;
	 
	 
}


public String roleCheck(LoginBean lb)throws LoginException,ConnectionException{
	
	  
	String role="";
	 role=rdao.roleCheck(lb);

	 return role;


}




public Vector<TransactionBean> viewDistricts()throws ConnectionException,DataNotFoundException{
	
	
	tb=rdao.viewDistricts();
	return tb;
	
}


public Vector<BudgetBean> viewDepartments()throws ConnectionException,DataNotFoundException{
	
	
	vb=rdao.viewDepartments();
	return vb;
	
}




public Vector<BudgetBean> viewDistrictsforcitzen()throws ConnectionException,DataNotFoundException{
	
	
	vb=rdao.viewDistrictsforcitzen();
	return vb;
	
}

public Vector<FeedbackBean> viewQuerySolution(String user)throws ConnectionException,DataNotFoundException{
	
	
	fb=rdao.viewQuerySolution(user);
	return fb;
	
}


public Vector<FeedbackBean> viewQuery()throws ConnectionException,DataNotFoundException{
	
	
	fb=rdao.viewQuery();
	return fb;
	
}



public Vector<BudgetBean> viewSubDepartments(String deptname)throws ConnectionException,DataNotFoundException{
	
	
	vb=rdao.viewSubDepartments(deptname);
	return vb;
	
}
}
