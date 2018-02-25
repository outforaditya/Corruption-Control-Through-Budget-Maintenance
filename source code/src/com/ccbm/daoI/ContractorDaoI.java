package com.ccbm.daoI;

import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.LoginBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.exception.ConnectionException;

public interface ContractorDaoI {
	
	public boolean insertcontractorworkdetails(TransactionBean tb);
	 public boolean insertContractor(LoginBean lb);
	 public boolean checkContractorshipStatus(String userid);
	 public boolean updateContractorwork(TransactionBean tb)throws FileNotFoundException;
	 public String contractorroleCheck(LoginBean lb);
	 public Vector<TransactionBean> checkContractortransaction(String loginid,String transid);
	 public Vector<BudgetBean> viewContractorWorkDetails(String loginid);
	 public Vector<TransactionBean> viewContractorApplication(String loginid);
	 public Vector<TransactionBean> viewContractorWorkInfo(String loginid);
	 public Vector<TransactionBean> viewContractorWorksDetails(String loginid,String path1);
	 public boolean acceptContractor(String cid)throws ConnectionException;
	 public Vector<BudgetBean> viewWorkDetails();
	 public Vector<TransactionBean> viewWorkDetails(String deptname,String distname,String path1);
	 
		

}
