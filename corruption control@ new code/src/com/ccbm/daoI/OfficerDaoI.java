package com.ccbm.daoI;

import java.io.FileNotFoundException;
import java.util.Vector;

import com.ccbm.bean.RegisterBean;

public interface OfficerDaoI {
	
	 public boolean registerDeptOfficer(RegisterBean rb)throws FileNotFoundException;
	 public Vector<RegisterBean> viewDeptOfficers();
	 public Vector<RegisterBean> viewDeptOfficers(String dept);
	 public Vector<RegisterBean> viewDistOfficers();
	 public Vector<RegisterBean> viewDistOfficers(String dist);
	 public boolean deleteDeptoff(String qid)throws FileNotFoundException;
	 public boolean deleteDistoff(String qid)throws FileNotFoundException;
		

}
