package com.ccbm.delegate;

import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.FeedbackBean;
import com.ccbm.bean.LoginBean;
import com.ccbm.bean.RegisterBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;
import com.ccbm.exception.LoginException;
import com.ccbm.serviceI.*;
import com.ccbm.serviceImpl.*;

public class RegisterMgrDelegate {
	
	RegisterServiceI rsi=new RegisterServiceImpl();
	BudgetServiceI bsi=new BudgetServiceImpl();
	OfficerServiceI osi=new OfficersRegisterServiceImpl();
	ContractorServiceI csi=new ContractorServiceImpl();
	
	public boolean checkAvailability(String userid)throws ConnectionException{
		 
		 return rsi.checkAvailability(userid);
		 
	 }
	
	public boolean acceptContractor(String cid)throws ConnectionException{
		 
		 return csi.acceptContractor(cid);
		 
	 }
	
	public boolean checkContractorshipStatus(String username)throws ConnectionException{
		 
		 return csi.checkContractorshipStatus(username);
		 
	 }
	
	
	public boolean addDept(String dept,String subdept)throws ConnectionException{
		 
		 return rsi.addDept(dept,subdept);
		 
	 }
	
	public boolean registerCitizen(RegisterBean rb)throws ConnectionException{

		return rsi.registerCitizen(rb);
		 
	 }
	
	public boolean addFeedback(FeedbackBean fb)throws ConnectionException{
 
		return rsi.addFeedback(fb);
		 
	 }
	
	public boolean addQuery(FeedbackBean fb)throws ConnectionException{
 
		return rsi.addQuery(fb);
		 
	 }
	
	public boolean replyToQuery(FeedbackBean fb)throws ConnectionException{
 
		return rsi.replyToQuery(fb);
		 
	 }
	
	public boolean deleteQuery(String qid)throws ConnectionException{

		return rsi.deleteQuery(qid);
		 
	 }
	
	
	
	public boolean deleteDeptoff(String qid)throws ConnectionException{

		return osi.deleteDeptoff(qid);
		 
	 }
	
	public boolean deleteDistoff(String qid)throws ConnectionException{

		return osi.deleteDistoff(qid);
		 
	 }
	
	public boolean deleteBudget(String dept,String subdept)throws ConnectionException{

		return bsi.deleteBudget(dept,subdept);
		 
	 }
	
	
	
	
	public boolean updateContractorwork(TransactionBean tb)throws ConnectionException{
 
		return csi.updateContractorwork(tb);
		 
	 }
	
	
	
	public boolean updateBudget(BudgetBean tb)throws ConnectionException{
 
		return bsi.updateBudget(tb);
		 
	 }
	
	
	
	public boolean insertdistrictbudget(TransactionBean tb)throws ConnectionException{
		
		return bsi.insertdistrictbudget(tb);
		 
	 }
	
	public boolean insertdistbudget(TransactionBean tb)throws ConnectionException{

		return bsi.insertdistbudget(tb);
		 
	 }
	
	public boolean insertcontractorworkdetails(TransactionBean tb)throws ConnectionException{

		return csi.insertcontractorworkdetails(tb);
		 
	 }
	
	public boolean insertContractor(LoginBean lb)throws ConnectionException{


		return csi.insertContractor(lb);
		 
	 }
	
	
	public boolean insertworkbudget(BudgetBean tb)throws ConnectionException{
		 

		
		return bsi.insertworkbudget(tb);
		 
	 }
	
	public boolean registerDeptOfficer(RegisterBean rb)throws ConnectionException{
		 

		return osi.registerDeptOfficer(rb);
		 
	 }
	
	public boolean addStateBudget(BudgetBean bb)throws ConnectionException{
		 
		return bsi.addStateBudget(bb);
		 
	 }
	
 public String passwordRecovery(RegisterBean rb)throws ConnectionException,DataNotFoundException{
		 
	 
		 
		 String user=rb.getUserName();
		 System.out.println("....."+user);
		 return rsi.passwordRecovery(rb);
	 }
 
 public String checkUser(String dob,String username,String password)throws ConnectionException{
	 
	 return rsi.checkUser(dob,username,password);
 }
	 
 public String roleCheck(LoginBean lb)throws LoginException,ConnectionException{
		
		return rsi.roleCheck(lb);
		}
 
 public String contractorroleCheck(LoginBean lb)throws LoginException,ConnectionException{
		
		return csi.contractorroleCheck(lb);
		}
 
 public Vector<RegisterBean> viewDeptOfficers()throws ConnectionException,DataNotFoundException{
	 
	 
	 return osi.viewDeptOfficers();
	 
 }
 
public Vector<RegisterBean> viewDeptOfficers(String dept)throws ConnectionException,DataNotFoundException{
	 
	 
	 return osi.viewDeptOfficers(dept);
	 
 }

public Vector<RegisterBean> viewDistOfficers(String dist)throws ConnectionException,DataNotFoundException{
	 
	 
	 return osi.viewDistOfficers(dist);
	 
}
 
 
 public Vector<TransactionBean> checkUsertransaction(String loginid,String transid)throws ConnectionException,DataNotFoundException{
	 
	 
	 return bsi.checkUsertransaction(loginid,transid);
	 
 }
 
 
 public Vector<TransactionBean> checkContractortransaction(String loginid,String transid)throws ConnectionException,DataNotFoundException{
	 
	 
	 return csi.checkContractortransaction(loginid,transid);
	 
 }
 
 
 public Vector<TransactionBean> viewDistricts()throws ConnectionException,DataNotFoundException{
	 
	 
	 return rsi.viewDistricts();
	 
 }
 
public Vector<BudgetBean> viewDepartments()throws ConnectionException,DataNotFoundException{
	 
	 
	 return rsi.viewDepartments();
	 
 }


public Vector<BudgetBean> viewDistrictsforcitzen()throws ConnectionException,DataNotFoundException{
	 
	 
	 return rsi.viewDistrictsforcitzen();
	 
}


public Vector<BudgetBean> viewWorkDetails()throws ConnectionException,DataNotFoundException{
	 
	 
	 return csi.viewWorkDetails();
	 
}

public Vector<TransactionBean> viewWorkDetails(String deptname,String distname,String path1)throws ConnectionException,DataNotFoundException{
	 
	 
	 return csi.viewWorkDetails(deptname,distname,path1);
	 
}

public Vector<BudgetBean> viewContractorWorkDetails(String loginid)throws ConnectionException,DataNotFoundException{
	 
	 
	 return csi.viewContractorWorkDetails(loginid);
	 
}

public Vector<TransactionBean> viewContractorApplication(String loginid)throws ConnectionException,DataNotFoundException{
	 
	 
	 return csi.viewContractorApplication(loginid);
	 
}

public Vector<TransactionBean> viewContractorWorkInfo(String loginid)throws ConnectionException,DataNotFoundException{
	 
	 
	 return csi.viewContractorWorkInfo(loginid);
	 
}


public Vector<TransactionBean> viewContractorWorksDetails(String loginid,String path1)throws ConnectionException,DataNotFoundException{
	 
	 
	 return csi.viewContractorWorksDetails(loginid,path1);
	 
}


public Vector<BudgetBean> viewStateBudget()throws ConnectionException,DataNotFoundException{
	 
	 
	 return bsi.viewStateBudget();
	 
}

public Vector<FeedbackBean> viewQuerySolution(String user)throws ConnectionException,DataNotFoundException{
	 
	 
	 return rsi.viewQuerySolution(user);
	 
}



public Vector<FeedbackBean> viewQuery()throws ConnectionException,DataNotFoundException{
	 
	 
	 return rsi.viewQuery();
	 
}



public Vector<BudgetBean> viewDistBudget(String loginid,String transid)throws ConnectionException,DataNotFoundException{
	 
	 
	 return bsi.viewDistBudget(loginid,transid);
	 
}



public Vector<BudgetBean> viewDistBudgetofDept(String distbudgetid)throws ConnectionException,DataNotFoundException{
	 
	 
	 return bsi.viewDistBudgetofDept(distbudgetid);
	 
}

public Vector<BudgetBean> viewDistBudget()throws ConnectionException,DataNotFoundException{
	 
	 
	 return bsi.viewDistBudget();
	 
}


public Vector<BudgetBean> viewDistDistributedBudget(String loginid)throws ConnectionException,DataNotFoundException{
	 
	 
	 return bsi.viewDistDistributedBudget(loginid);
	 
}

public Vector<BudgetBean> viewDistBudget(String distname)throws ConnectionException,DataNotFoundException{
	 
	 
	 return bsi.viewDistBudget(distname);
	 
}

public Vector<BudgetBean> viewDistBudgetByDco(String user)throws ConnectionException,DataNotFoundException{
	 
	 
	 return bsi.viewDistBudgetByDco(user);
	 
}
 
public Vector<BudgetBean> viewSubDepartments(String deptname)throws ConnectionException,DataNotFoundException{
	 
	 
	 return rsi.viewSubDepartments(deptname);
	 
}

 public Vector<RegisterBean> viewDistOfficers()throws ConnectionException,DataNotFoundException{
	 
	 
	 return osi.viewDistOfficers();
	 
 }
}
