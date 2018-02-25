package com.ccbm.daoI;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.TransactionBean;

public interface BudgetDaoI {

	
	 public boolean insertdistrictbudget(TransactionBean tb);
	 public boolean insertdistbudget(TransactionBean tb);
	 public boolean insertworkbudget(BudgetBean tb);
	 public boolean deleteBudget(String dept,String subdept)throws FileNotFoundException;
	 public boolean updateBudget(BudgetBean tb)throws FileNotFoundException;
	 public boolean addStateBudget(BudgetBean bb);
	 public Vector<BudgetBean> viewStateBudget();
	 public Vector<TransactionBean> checkUsertransaction(String loginid,String transid);
	 public Vector<BudgetBean> viewDistBudget(String loginid,String transid);
	 public Vector<BudgetBean> viewDistBudgetofDept(String distbudgetid);
	 public Vector<BudgetBean> viewDistDistributedBudget(String loginid);
	 public Vector<BudgetBean> viewDistBudget();
	 public Vector<BudgetBean> viewDistBudget(String distname);
	 public Vector<BudgetBean> viewDistBudgetByDco(String user);
	
}
