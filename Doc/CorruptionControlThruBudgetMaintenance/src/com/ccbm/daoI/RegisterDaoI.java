package com.ccbm.daoI;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.FeedbackBean;
import com.ccbm.bean.LoginBean;
import com.ccbm.bean.RegisterBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.exception.ConnectionException;

public interface RegisterDaoI {
	
	 public boolean checkAvailability(String userid)throws ConnectionException;
	 public boolean addDept(String dept,String subdept)throws ConnectionException;
	 
	 public boolean registerCitizen(RegisterBean rb)throws ConnectionException;
	 public boolean addFeedback(FeedbackBean fb)throws ConnectionException;
	 public boolean addQuery(FeedbackBean fb)throws ConnectionException;
	 public boolean replyToQuery(FeedbackBean fb)throws ConnectionException;
	 public boolean deleteQuery(String qid)throws ConnectionException;
	 public String passwordRecovery(RegisterBean rb)throws ConnectionException;
	 public String checkUser(String dob,String username,String password)throws ConnectionException;
	 public String roleCheck(LoginBean lb)throws ConnectionException;
	
	 public Vector<TransactionBean> viewDistricts()throws ConnectionException;
	 public Vector<BudgetBean> viewDepartments()throws ConnectionException;
	 public Vector<BudgetBean> viewDistrictsforcitzen()throws ConnectionException;
	 public Vector<FeedbackBean> viewQuery()throws ConnectionException;
	 public Vector<FeedbackBean> viewQuerySolution(String user)throws ConnectionException;
	 public Vector<BudgetBean> viewSubDepartments(String deptname)throws ConnectionException;
}
