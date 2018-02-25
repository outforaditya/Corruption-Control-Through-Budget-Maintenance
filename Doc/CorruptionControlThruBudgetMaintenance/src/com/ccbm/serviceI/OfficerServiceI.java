package com.ccbm.serviceI;

import java.util.Vector;

import com.ccbm.bean.RegisterBean;
import com.ccbm.exception.ConnectionException;
import com.ccbm.exception.DataNotFoundException;

public interface OfficerServiceI {
	
	 public boolean registerDeptOfficer(RegisterBean rb)throws ConnectionException;
	 public Vector<RegisterBean> viewDeptOfficers()throws ConnectionException,DataNotFoundException;
	 public Vector<RegisterBean> viewDeptOfficers(String dept)throws ConnectionException,DataNotFoundException;
	 public Vector<RegisterBean> viewDistOfficers()throws ConnectionException,DataNotFoundException;
	 public Vector<RegisterBean> viewDistOfficers(String dist)throws ConnectionException,DataNotFoundException;
	 public boolean deleteDeptoff(String qid)throws ConnectionException;
	 public boolean deleteDistoff(String qid)throws ConnectionException;
}
