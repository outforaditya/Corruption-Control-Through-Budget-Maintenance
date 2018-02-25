package com.ccbm.serviceI;

import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.LoginBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.exception.LoginException;

public interface ContractorServiceI {

	public boolean insertcontractorworkdetails(TransactionBean tb)throws ConnectionException; 
	 public boolean insertContractor(LoginBean lb)throws ConnectionException; 
	 public boolean checkContractorshipStatus(String username);
	 public boolean updateContractorwork(TransactionBean tb)throws ConnectionException;
	 public String contractorroleCheck(LoginBean lb)throws LoginException,ConnectionException;
	 public Vector<TransactionBean> checkContractortransaction(String loginid,String transid)throws ConnectionException,DataNotFoundException;
	 public Vector<BudgetBean> viewContractorWorkDetails(String loginid)throws ConnectionException,DataNotFoundException;
	 public Vector<TransactionBean> viewContractorApplication(String loginid)throws ConnectionException,DataNotFoundException;
	 public Vector<TransactionBean> viewContractorWorksDetails(String loginid,String path1)throws ConnectionException,DataNotFoundException;
	 public boolean acceptContractor(String cid)throws ConnectionException;
	 public Vector<BudgetBean> viewWorkDetails()throws ConnectionException,DataNotFoundException;
	 public Vector<TransactionBean> viewContractorWorkInfo(String loginid)throws ConnectionException,DataNotFoundException;
	 public Vector<TransactionBean> viewWorkDetails(String deptname,String distname,String path1)throws ConnectionException,DataNotFoundException;
}
