package com.ccbm.serviceImpl;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.FeedbackBean;
import com.ccbm.bean.RegisterBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.serviceI.BudgetServiceI;
import com.ccbm.daoI.BudgetDaoI;
import com.ccbm.daoImpl.BudgetDaoImpl;

public class BudgetServiceImpl implements BudgetServiceI{
	
	boolean flag=false;
	Vector<RegisterBean> vdo=null;
	Vector<BudgetBean> vb=null;
	Vector<TransactionBean>tb=null;
	Vector<FeedbackBean> fb=null;
	BudgetDaoI rdao=new BudgetDaoImpl();
	
	public boolean insertdistrictbudget(TransactionBean tb) throws ConnectionException {
		System.out.println("in service reg DEPT");
		flag=rdao.insertdistrictbudget(tb);
			return flag;
	   }
	
	public boolean insertdistbudget(TransactionBean tb) throws ConnectionException {
		System.out.println("in service reg DEPT");
		flag=rdao.insertdistbudget(tb);
			return flag;
	   }
	public boolean insertworkbudget(BudgetBean tb) throws ConnectionException {
		System.out.println("in service reg DEPT");
		flag=rdao.insertworkbudget(tb);
		System.out.println("flag in service impl"+flag);
			return flag;
	   }

	public boolean deleteBudget(String dept,String subdept) throws ConnectionException {
		
		 try {
			 System.out.println("in service");
			flag=rdao.deleteBudget(dept,subdept);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 
			return flag;
	}
	
	public boolean updateBudget(BudgetBean tb) throws ConnectionException {
		
		 try {
			 System.out.println("in service");
			flag=rdao.updateBudget(tb);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			return flag;
	  }
	
	public boolean addStateBudget(BudgetBean bb) throws ConnectionException {
		System.out.println("in service reg DEPT");
		flag=rdao.addStateBudget(bb);
			return flag;
	   }
	
	
	public Vector<TransactionBean> checkUsertransaction(String loginid,String transid)throws ConnectionException,DataNotFoundException{
		
		
		tb=rdao.checkUsertransaction(loginid,transid);
		if(tb==null)
		{
			throw new ConnectionException();
			
		}
		else if (tb.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return tb;
		
	}

	public Vector<BudgetBean> viewDistBudget(String loginid,String transid)throws ConnectionException,DataNotFoundException{
		
		
		vb=rdao.viewDistBudget(loginid,transid);
		if(vb==null)
		{
			throw new ConnectionException();
			
		}
		else if (vb.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vb;
		
	}
	
	public Vector<BudgetBean> viewDistBudgetofDept(String distbudgetid)throws ConnectionException,DataNotFoundException{
		
		
		vb=rdao.viewDistBudgetofDept(distbudgetid);
		if(vb==null)
		{
			throw new ConnectionException();
			
		}
		else if (vb.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vb;
		
	}

	public Vector<BudgetBean> viewDistDistributedBudget(String loginid)throws ConnectionException,DataNotFoundException{
		
		
		vb=rdao.viewDistDistributedBudget(loginid);
		if(vb==null)
		{
			throw new ConnectionException();
			
		}
		else if (vb.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vb;
		
	}
	
	public Vector<BudgetBean> viewDistBudget()throws ConnectionException,DataNotFoundException{
		
		
		vb=rdao.viewDistBudget();
		if(vb==null)
		{
			throw new ConnectionException();
			
		}
		else if (vb.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vb;
		
	}
	
	public Vector<BudgetBean> viewDistBudget(String distname)throws ConnectionException,DataNotFoundException{
		
		
		vb=rdao.viewDistBudget(distname);
		if(vb==null)
		{
			throw new ConnectionException();
			
		}
		else if (vb.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vb;
		
	}
	
public Vector<BudgetBean> viewDistBudgetByDco(String user)throws ConnectionException,DataNotFoundException{
		
		
		vb=rdao.viewDistBudgetByDco(user);
		if(vb==null)
		{
			throw new ConnectionException();
			
		}
		else if (vb.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vb;
		
	}
	public Vector<BudgetBean> viewStateBudget()throws ConnectionException,DataNotFoundException{
		
		
		vb=rdao.viewStateBudget();
		if(vb==null)
		{
			throw new ConnectionException();
			
		}
		else if (vb.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vb;
		
	}
	
}
