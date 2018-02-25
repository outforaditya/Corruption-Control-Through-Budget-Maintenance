package com.ccbm.serviceI;

import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.FeedbackBean;
import com.ccbm.bean.LoginBean;
import com.ccbm.bean.RegisterBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.exception.LoginException;

public interface RegisterServiceI {

	
	 public boolean checkAvailability(String userid)throws ConnectionException;
	 public boolean addDept(String dept,String subdept)throws ConnectionException;
	 public boolean registerCitizen(RegisterBean rb)throws ConnectionException;
	 public boolean addFeedback(FeedbackBean fb)throws ConnectionException;
	 public boolean addQuery(FeedbackBean fb)throws ConnectionException;
	 public boolean replyToQuery(FeedbackBean fb)throws ConnectionException;
	 public boolean deleteQuery(String qid)throws ConnectionException;
	 public String passwordRecovery(RegisterBean rb)throws ConnectionException,DataNotFoundException;
	 public String checkUser(String dob,String username,String password)throws ConnectionException;
	 public String roleCheck(LoginBean lb)throws LoginException,ConnectionException;
	 public Vector<TransactionBean> viewDistricts()throws ConnectionException,DataNotFoundException;
	 public Vector<BudgetBean> viewDepartments()throws ConnectionException,DataNotFoundException;
	 public Vector<BudgetBean> viewDistrictsforcitzen()throws ConnectionException,DataNotFoundException;
	 public Vector<FeedbackBean> viewQuerySolution(String user)throws ConnectionException,DataNotFoundException;
	 public Vector<FeedbackBean> viewQuery()throws ConnectionException,DataNotFoundException;
	 public Vector<BudgetBean> viewSubDepartments(String deptname)throws ConnectionException,DataNotFoundException;
}
