package com.ccbm.serviceI;

import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;

public interface BudgetServiceI {
	
	 public boolean insertdistrictbudget(TransactionBean tb)throws ConnectionException; 
	 public boolean insertdistbudget(TransactionBean tb)throws ConnectionException; 
	 public boolean insertworkbudget(BudgetBean tb)throws ConnectionException; 
	 public boolean deleteBudget(String dept,String subdept)throws ConnectionException;
	 public boolean updateBudget(BudgetBean tb)throws ConnectionException;
	 public boolean addStateBudget(BudgetBean bb)throws ConnectionException;
	 public Vector<BudgetBean> viewStateBudget()throws ConnectionException,DataNotFoundException;
	 public Vector<TransactionBean> checkUsertransaction(String loginid,String transid)throws ConnectionException,DataNotFoundException;
     public Vector<BudgetBean> viewDistBudget(String loginid,String transid)throws ConnectionException,DataNotFoundException;
	 public Vector<BudgetBean> viewDistBudgetofDept(String distbudgetid)throws ConnectionException,DataNotFoundException;
	 public Vector<BudgetBean> viewDistDistributedBudget(String loginid)throws ConnectionException,DataNotFoundException;
	 public Vector<BudgetBean> viewDistBudget()throws ConnectionException,DataNotFoundException;
	 public Vector<BudgetBean> viewDistBudget(String distname)throws ConnectionException,DataNotFoundException;
	 public Vector<BudgetBean> viewDistBudgetByDco(String user)throws ConnectionException,DataNotFoundException;

}
