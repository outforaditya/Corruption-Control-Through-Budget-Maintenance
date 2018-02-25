package com.ccbm.serviceImpl;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.FeedbackBean;
import com.ccbm.bean.RegisterBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.daoI.OfficerDaoI;
import com.ccbm.daoImpl.OfficerDaoImpl;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.serviceI.OfficerServiceI;

public class OfficersRegisterServiceImpl implements OfficerServiceI{

	boolean flag=false;
	Vector<RegisterBean> vdo=null;
	Vector<BudgetBean> vb=null;
	Vector<TransactionBean>tb=null;
	Vector<FeedbackBean> fb=null;
	OfficerDaoI rdao=new OfficerDaoImpl();
	
	public boolean registerDeptOfficer(RegisterBean rb) throws ConnectionException {
		
		 try {
			 System.out.println("in service reg DEPT");
			flag=rdao.registerDeptOfficer(rb);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 
			return flag;
	   }

	public Vector<RegisterBean> viewDeptOfficers()throws ConnectionException,DataNotFoundException{
		
		
		vdo=rdao.viewDeptOfficers();
		if(vdo==null)
		{
			throw new ConnectionException();
			
		}
		else if (vdo.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vdo;
		
	}
	
	public Vector<RegisterBean> viewDeptOfficers(String dept)throws ConnectionException,DataNotFoundException{
		
		
		vdo=rdao.viewDeptOfficers(dept);
		if(vdo==null)
		{
			throw new ConnectionException();
			
		}
		else if (vdo.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vdo;
		
	}
	
	public Vector<RegisterBean> viewDistOfficers()throws ConnectionException,DataNotFoundException{
		
		
		vdo=rdao.viewDistOfficers();
		if(vdo==null)
		{
			throw new ConnectionException();
			
		}
		else if (vdo.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vdo;
		
	}


	public Vector<RegisterBean> viewDistOfficers(String dist)throws ConnectionException,DataNotFoundException{
		
		
		vdo=rdao.viewDistOfficers(dist);
		if(vdo==null)
		{
			throw new ConnectionException();
			
		}
		else if (vdo.isEmpty()) {
			
			throw new DataNotFoundException();
			
		}
		return vdo;
		
	}

	
	public boolean deleteDeptoff(String qid) throws ConnectionException {
		
		 try {
			 System.out.println("in service");
			flag=rdao.deleteDeptoff(qid);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 
			return flag;
	}
	
	public boolean deleteDistoff(String qid) throws ConnectionException {
		
		 try {
			 System.out.println("in service");
			flag=rdao.deleteDistoff(qid);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 
			return flag;
	}
}
