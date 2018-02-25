package com.ccbm.serviceImpl;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.FeedbackBean;
import com.ccbm.bean.LoginBean;
import com.ccbm.bean.RegisterBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.daoI.ContractorDaoI;
import com.ccbm.daoImpl.ContractorDaoImpl;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.exception.LoginException;
import com.ccbm.serviceI.ContractorServiceI;

public class ContractorServiceImpl implements ContractorServiceI{

	boolean flag=false;
	Vector<RegisterBean> vdo=null;
	Vector<BudgetBean> vb=null;
	Vector<TransactionBean>tb=null;
	Vector<FeedbackBean> fb=null;
	ContractorDaoI rdao=new ContractorDaoImpl();
	
	public boolean insertcontractorworkdetails(TransactionBean tb) throws ConnectionException {
		System.out.println("in service reg DEPT");
		flag=rdao.insertcontractorworkdetails(tb);
			return flag;
	   }
	
	public boolean insertContractor(LoginBean lb) throws ConnectionException {
		System.out.println("in service reg DEPT");
		flag=rdao.insertContractor(lb);
		System.out.println("flag in service impl"+flag);
			return flag;
	   }

	 public boolean checkContractorshipStatus(String userid){
		 
		 flag=rdao.checkContractorshipStatus(userid);
		 
		 
			return flag;
		 
	 }
	 
	 public boolean updateContractorwork(TransactionBean tb) throws ConnectionException {
			
		 try {
			 System.out.println("in service");
			flag=rdao.updateContractorwork(tb);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			return flag;
	   }
	 public String contractorroleCheck(LoginBean lb)throws LoginException,ConnectionException{
			
		  
			String role="";
			 role=rdao.contractorroleCheck(lb);
			 
			 if(role==null){
				 
				 throw new ConnectionException();
				 
				 
			 }
			 else if (lb.getUsername()==null || lb.getPassword()==null) {
				 
				 throw new ConnectionException();
				
			}
			 
			 return role;


		}
	 
	 public Vector<TransactionBean> checkContractortransaction(String loginid,String transid)throws ConnectionException,DataNotFoundException{
			
			
			tb=rdao.checkContractortransaction(loginid,transid);
			if(tb==null)
			{
				throw new ConnectionException();
				
			}
			else if (tb.isEmpty()) {
				
				throw new DataNotFoundException();
				
			}
			return tb;
			
		}
	 public Vector<BudgetBean> viewContractorWorkDetails(String loginid)throws ConnectionException,DataNotFoundException{
			
			
			vb=rdao.viewContractorWorkDetails(loginid);
			if(vb==null)
			{
				throw new ConnectionException();
				
			}
			else if (vb.isEmpty()) {
				
				throw new DataNotFoundException();
				
			}
			return vb;
			
		}

	 public Vector<TransactionBean> viewContractorApplication(String loginid)throws ConnectionException,DataNotFoundException{
			
			
			tb=rdao.viewContractorApplication(loginid);
			if(tb==null)
			{
				throw new ConnectionException();
				
			}
			else if (tb.isEmpty()) {
				
				throw new DataNotFoundException();
				
			}
			return tb;
			
		}
	 
	 public Vector<TransactionBean> viewContractorWorkInfo(String loginid)throws ConnectionException,DataNotFoundException{
			
			
			tb=rdao.viewContractorWorkInfo(loginid);
			if(tb==null)
			{
				throw new ConnectionException();
				
			}
			else if (tb.isEmpty()) {
				
				throw new DataNotFoundException();
				
			}
			return tb;
			
		}

	 public Vector<TransactionBean> viewContractorWorksDetails(String loginid,String path1)throws ConnectionException,DataNotFoundException{
			
			
			tb=rdao.viewContractorWorksDetails(loginid,path1);
			if(tb==null)
			{
				throw new ConnectionException();
				
			}
			else if (tb.isEmpty()) {
				
				throw new DataNotFoundException();
				
			}
			return tb;
			
		}
	 
	 public boolean acceptContractor(String cid)throws ConnectionException{
		 
		 flag=rdao.acceptContractor(cid);
		 
			return flag;
		 
	 }
	 public Vector<BudgetBean> viewWorkDetails()throws ConnectionException,DataNotFoundException{
			
			
			vb=rdao.viewWorkDetails();
			if(vb==null)
			{
				throw new ConnectionException();
				
			}
			else if (vb.isEmpty()) {
				
				throw new DataNotFoundException();
				
			}
			return vb;
			
		}

		public Vector<TransactionBean> viewWorkDetails(String deptname,String distname,String path1)throws ConnectionException,DataNotFoundException{
			
			
			tb=rdao.viewWorkDetails(deptname,distname,path1);
			if(tb==null)
			{
				throw new ConnectionException();
				
			}
			else if (tb.isEmpty()) {
				
				throw new DataNotFoundException();
				
			}
			return tb;
			
		}

	 
}
