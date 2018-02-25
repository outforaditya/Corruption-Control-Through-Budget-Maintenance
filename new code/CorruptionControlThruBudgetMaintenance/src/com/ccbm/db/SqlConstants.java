package com.ccbm.db;

public class SqlConstants {
	
	
	
   
   public static final String _UPDATE_TRANSCTION="update transaction set status='YES' where userid=? and transaction_password=?";
   
   
   
   
  //work
   
   public static final String _ADD_WORK="insert into work values((select nvl(max(workid),1000)+1 from work),?,sysdate,?)";
   
   public static final String _DELETE_WORK="delete from work where workid=?";
   
   public static final String _VIEW_WORKS="select workid,workname,TO_CHAR(wdate,'DD-MM-YYYY'),wfund from work";
   
   public static final String _VIEW_WORKAT="select workid,workname,TO_CHAR(wdate,'DD-MM-YYYY'),wfund from work  where workid=?";
   
   public static final String _UPDATE_WORK="update work set workname=?,wfund=? where workid=?";
   
   public static final String _ADD_WORK_DEMAND="insert into demandwork values((select nvl(max(wdid),100)+1 from demandwork),?,?,sysdate,?)" ;
   
   public static final String _VIEW_WORK_DEMANDS="select wdid,workid,userid,TO_CHAR(demanddate,'DD-MM-YYYY'),status from demandwork";
   
   
   public static final String _VIEW_USER_WORK_DEMANDS="select wdid,workid,userid,TO_CHAR(demanddate,'DD-MM-YYYY'),status from demandwork where userid=?";
   
   public static final String _SELECT_WORk_NAME="select workname from work where workid=?";
   
   public static final String _ASSIGN_WORk="insert into assignwork values((select nvl(max(asid ),2010)+1 from assignwork),(select stateid from state where statename=?),(select did from district where dname=?),(select mid from mandel where mandelname=?),?,?,?,?,?,sysdate,?,?,(select vid from village where villagename=?))";
   
   public static final String _SHEDULE_WORk="insert into workshedule values((select nvl(max(wsid),110)+1 from workshedule),?,?,sysdate)";
   
   public static final String _GET_ASSIGN_WORk="select asid,workid from assignwork";
   
   public static final String _GET_WORkERS="select mid,vid from assignwork where asid=?";
   
   public static final String _GET__USERS_WORkERS="select userid,firstname,lastname from userdetails where userid in (select userid from addresses where street=? and city=?) and logintype=?";
   
   public static final String _GET_WORkER_HISTORY="select userid,firstname,lastname from userdetails where loginid=? and logintype=?";
   
   public static final String _GET_WORkER_ADDRESS="select houseno,street,city,state from addresses where userid=?"; 
   
   public static final String _GET_WORkER_PAYMENT="select payamount, TO_CHAR(paydate,'DD-MM-YYYY') from payment where asid=? and userid=?";
   
   public static final String _ISSUE_WORK="insert into workshedule values((select nvl(max(wsid),110)+1 from workshedule),?,?,sysdate)";
   
   public static final String _GET_WORK_STATUS="select w.workname,w.Wfund,a.timeperiod,a.wstatus,TO_CHAR(a.wstartdate,'DD-MM-YYYY'),a.receivedfund,w.workid from work w,assignwork a where w.workid=a.workid";
   
   public static final String _GET_WORK_LOCATION="select stateid,did,mid,vid from assignwork where workid=?";
   
   public static final String _GET_LOCATION="select s.statename,d.dname,m.mandelname,v.villagename from state s,district d,mandel m,village v where s.stateid=? and d.did=? and m.mid=? and v.vid=?";
   
   public static final String _VIEW_WORKER_ADDR="select u.userid,u.firstname,u.lastname,w.houseno,w.vname,w.mname,w.dname,w.state,w.pincode from userdetails u,workeraddresses w where u.userid=w.userid and w.userid in (select userid from workshedule where asid in (select asid from assignwork where workid=?))";
   
   
   
   //Solution
   
   public static final String _GIVE_SOLUTION="insert into solution values(?,?,?)";
   
   public static final String _GET_QUERY_STATUS="select q.queryid,q.userid,q.qdescription,TO_CHAR(q.qdate,'DD-MM-YYYY'),u.userid,q.qstatus from query q , userdetails u where  u.loginid=?";
   
   public static final String _GET_SOLUTION="select u.userid, u.firstname,u.lastname,s.solution,s.soldate,q.qstatus,q.qdate,qdescription from solution s,userdetails u,query q where s.queryid=q.queryid and s.queryid=? and u.userid in (select userid from query where queryid=?) and u.logintype=?";
   
   //Query
   
   public static final String _INSERT_QUERY="insert into query values((select nvl(max(qid),1000)+1 from query),?,?,?,'NOTSOLVED')";
   
   
   public static final String _INSERT_ANSWER="insert into ANSWER values((select nvl(max(aid),1000)+1 from answer),?,?,?,?)";
   
   public static final String _GET_QUERY="select queryid,userid,qdescription,qstatus,to_char(qdate,'dd-mm-yy') from query";
   
   //Feedback
   
   public static final String _INSERT_FEEDBACK="insert into feedback values((select nvl(max(fid),100)+1 from feedback),?,?,?,?,?,?,?,?,?,?)";
   
   public static final String _GET_FEEDBACK="select *from feedback";
   
   public static final String _All_FEEDBACKS="select *from feedback where fid=?";
   
   public static final String _DELETE_FEEDBACK="delete from feedback where fid=?";
   
   
   //Funds
   
   public static final String _INSERT_FUND="insert into funds values(?,?,?,sysdate,?)";
   
   public static final String _UPDATE_RECEIVED_FUND="update assignwork set receivedfund=? where asid=?";
   
   public static final String _GET_FUNDS="select  asid, totalfund,fundamount,TO_CHAR(transfordate,'DD-MM-YYYY'),remainamount from funds";
   
   public static final String _GET_FUNDS_AT="select wfund from work where workid  in (select workid from assignwork where asid=?)";
   
   
   //Payments
   
   public static final String _INSERT_PAYMENT="insert into payment values((select nvl(max(pid),1000)+1 from payment),?,?,?,?,sysdate)";
   
   public static final String _GET_ASID="select asid from assignwork where workid=?";
   
   public static final String _GET_USERID="select userid from userdetails where loginid=?";
   
   public static final String _GET_PAYMENT="select managerid,asid,userid,payamount,TO_CHAR(paydate,'DD-MM-YYYY')from payment";
   
   public static final String _GET_USERINFO="select userid,firstname,lastname from userdetails where userid in (select userid from workshedule where asid in( select asid from assignwork  where workid=?))";
   
   public static final String _GET_WORKINFO="select workid,workname from work";
   
   public static final String _GET_FNAME_LNAME="select firstname,lastname from userdetails where userid=?";
   
   
   //Register
   
   public static final String _INSERT_DEPT_OFFICER="insert into userdetails values((select nvl(max(userid),1000)+1 from userdetails),?,?,?,?,?,?,?,?,?,?,?)";  
   
   public static final String _INSERT_USERS="insert into userdetails values((select nvl(max(userid),1000)+1 from userdetails),?,?,?,?,?,?,?,?,?,?,?)"; 
   
   public static final String _INSERT_FEED="insert into feedback values((select nvl(max(fid),1000)+1 from feedback),?,?,?,?,sysdate,?,?)"; 
   
   public static final String _INSERT_ADDRESS="insert into addresses values((select max(userid) from userdetails),(select nvl(max(addressid),1000)+1 from addresses),'home',?,?,?,?,?,?,?,?)";
   
   public static final String _UPDATE_CONTRACTORWORK="update WORKDETAILS set NO_OF_WORKER=?,STARTDATE=?,ENDDATE=?,AMT_SPENT=?,PHOTO=?,WORKSTATUS=? where CONTRCTORID=?";
   
   public static final String _INSERT_DEPT_OFF_ADDR="insert into addresses values((select max(userid) from userdetails),(select nvl(max(addressid),1000)+1 from addresses),?,?,?,?,?,?,?,?,?)";
   
   public static final String _LOGOUT_ACTION="update loginmaster set logofftime=sysdate where userid=? and logofftime=null";
   
   public static final String _SELECT_USER="select userid from userdetails where loginid=?";
   
   public static final String _UPDATE_LOGINMASTER="update loginmaster set logofftime=sysdate where logofftime is null and userid=?";
   
   
   public static final String _RECOVER_PASSWORD="select password from userdetails where loginid=? and forgotpwquestion=? and forgotpwanswer=? and (LOGINTYPE='citizen' or LOGINTYPE='contractor')";
   
   public static final String _INSERT_TRANSACTION="INSERT INTO TRANSACTION VALUES((SELECT NVL(MAX(TRAN_ID),100)+1 FROM TRANSACTION),(SELECT USERID FROM USERDETAILS WHERE LOGINID=? AND PASSWORD=? AND dob=?),?,'NO')";
   
   public static final String _CHECK_AVAILABILITY="select userid from userdetails where loginid=?";
   
   public static final String _CHECK_CONTRACTOR_STATUS="select dcowilling from contractor where userid=(SELECT USERID FROM USERDETAILS WHERE LOGINID=?)";
   
   public static final String _CHECK_DEPT_AVAIL="select deptname from department where deptname=?";
   
   public static final String _SELECT_DEPT_OFFICER="select distinct u.userid from userdetails u,addresses a where a.addresstype=? and u.logintype='deptoff'";
   
  // public static final String _SELECT_DIST_OFFICER="select userid from addresses where addresstype=? and district=? ";
   
   public static final String _SELECT_DIST_OFFICER="select distinct addresses.userid from addresses,userdetails where addresstype=? and district=? and addresses.userid in(select userid from userdetails where userdetails.LOGINTYPE='distco')";
   
   public static final String _SELECT_CONTRACTORID="SELECT C.CONTRCTORID FROM CONTRACTOR C WHERE C.USERID=(SELECT U.USERID FROM USERDETAILS U WHERE U.LOGINID=?)";
   
   public static final String _SELECT_CONTRACTORID_WORKDETAILS="select * from WORKDETAILS where CONTRCTORID=?";
   
  // public static final String _SELECT_DIST_OFFICER="select userid from addresses where addresstype='Agriculture Department' and district='sri'";
   public static final String _CHECK_SUBDEPT_AVAIL="select subdeptname from sub_department where subdeptname=?";
   
   public static final String _UPDATE_DEPARTMENT="update department set userid=?,budgetdate=sysdate where deptname=?";
   
   public static final String _INSERT_DISTRICT="insert into district values((select nvl(max(distid),1000)+1 from district),?,?)";
   
   public static final String _INSERT_DISTFUNDSTATUS="insert into DISTFUNDSTATUS values((select nvl(max(dfid),1000)+1 from DISTFUNDSTATUS),?,'No','')";
   
   public static final String _INSERT_WORK_BUDEGET="INSERT INTO DIST_BUDGET_DISTRIBUTION VALUES((select nvl(max(workid),1000)+1 from DIST_BUDGET_DISTRIBUTION),?,?,?,?,?,?,(select deptno from dist_budget where distbudgetid=?),(select subdeptno from dist_budget where distbudgetid=?),(select distid from dist_budget where distbudgetid=?),sysdate)";
   
   public static final String _INSERT_CONTRACTOR="INSERT INTO CONTRACTOR VALUES((select nvl(max(CONTRCTORID),1000)+1 from CONTRACTOR),(SELECT USERID FROM USERDETAILS WHERE LOGINID=?),?,'NO',?,?,?)";
   
   public static final String _UPDATE_SUBDEPARTMENT="update sub_department set amount=?,year=?,availfund=? where subdeptname=?";
   
   public static final String _INSERT_DIST_BUDGET="insert into dist_budget values((select nvl(max(distbudgetid),100)+1 from dist_budget),?,?,(select firstname from userdetails where userid=?),(select deptno from department where deptname=?),(select subdeptno from sub_department where subdeptname=?),(select distid from district where distname=?),sysdate,?)";
   
   public static final String _INSERT_CONTRACTOR_WORKDETAILS="insert into WORKDETAILS values((select nvl(max(WORK_DETAILSID),100)+1 from WORKDETAILS),?,(select workid from DIST_BUDGET_DISTRIBUTION where workname=?),?,?,?,?,?,?,?)";
   
   
   public static final String _SELECT_DEPARTMENT="select userid,budgetdate from department where deptname=?";
   
   public static final String _SELECT_SUBDEPARTMENT="select amount,year from sub_department where subdeptname=?";
   
   
   public static final String _INSERT_SUBDEPT="insert into sub_department(subdeptno,subdeptname,deptnoref) values((select nvl(max(subdeptno),1000)+1 from sub_department),?,(select deptno from department where deptname=?))";
   
   public static final String _INSERT_DEPT="insert into department(deptno,deptname) values((select nvl(max(deptno),1000)+1 from department),?)";
   
   public static final String _CHANGE_PASSWORD="update userdetails set password=? where loginid=? and password=?";
   
   public static final String _CHANGE_QUESTION="update userdetails set forgotpwquestion=?,forgotpwanswer=? where loginid=? and password=?";
   
   public static final String _LOGIN_AUDIT="{call signoutprocedure(?)}";
   
   public static final String _VIEW_DEPT_OFFICERS="select u.loginid,u.firstname,a.addresstype,a.district from userdetails u,addresses a where u.userid=a.userid and u.logintype='deptoff'";
   
   public static final String _VIEW_DEPT_OFFICERS1="select u.loginid,u.firstname,a.addresstype,a.district from userdetails u,addresses a where u.userid=a.userid and u.logintype='deptoff' and a.ADDRESSTYPE=?";
   
   public static final String _VIEW_DIST_OFFICERS="select u.loginid,u.firstname,a.addresstype,a.district from userdetails u,addresses a where u.userid=a.userid and u.logintype='distco'";
   
   public static final String _VIEW_DIST_OFFICERS1="select u.loginid,u.firstname,a.addresstype,a.district from userdetails u,addresses a where u.userid=a.userid and u.logintype='distco'and a.district=?";
   
   public static final String _VIEW_DEPARTMENTS="select deptname from department";
   
   public static final String _VIEW_DISTRICT="select DISTID,DISTNAME from DISTRICT";
   
   public static final String _VIEW_WORKDETAILS="select distinct workname,to_char(NOTIFICATIONCLOSEDATE,'dd-mm-yyyy'),to_char(WORKCOMPLT_TARGETDATE,'dd-mm-yyyy'),DEPTNOREF,DISTIDREF from DIST_BUDGET_DISTRIBUTION";
   
   public static final String _VIEW_WORKDATA="select workname,NOTIFICATIONCLOSEDATE,WORKCOMPLT_TARGETDATE,DEPTNOREF,DISTIDREF from DIST_BUDGET_DISTRIBUTION";
   
   public static final String _VIEW_CONTRACTOR_WORKDETAILS="select workname,NOTIFICATIONCLOSEDATE,WORKCOMPLT_TARGETDATE,DEPTNOREF,DISTIDREF from DIST_BUDGET_DISTRIBUTION";
   
   public static final String _VIEW_STATEBUDGET="select d.deptname,TO_CHAR(d.budgetdate,'DD-MM-YYYY'),s.subdeptname,s.amount,s.year from department d,sub_department s where d.deptno=s.deptnoref";
   
   public static final String _VIEW_QUERY="SELECT QID,USERID,QUERY,QDATE,QSTATUS FROM QUERY";
   
   public static final String _VIEW_DISTBUDGETT="select d.distbudgetid,d.amt,d.fyear,d.DISTRIBUTEDBY,d.DEPTNO,d.SUBDEPTNO,d.distid,TO_CHAR(d.budgetdate,'DD-MM-YYYY') from dist_budget d,district d1,userdetails u where d.distid=d1.distid and u.userid=? and d1.userid=? ";//and u.logintype='deptoff';";
   
   public static final String _VIEW_DISTWORKBUDGETT="select d.distbudgetid,d.amt,d.fyear,d.DISTRIBUTEDBY,d.DEPTNO,d.SUBDEPTNO,d.distid,TO_CHAR(d.budgetdate,'DD-MM-YYYY'),d.balamt from dist_budget d where d.distbudgetid=?";
   
   public static final String _VIEW_DISTBUDGET="select d.distbudgetid,d.amt,d.fyear,d.DISTRIBUTEDBY,d.DEPTNO,d.SUBDEPTNO,d.distid,TO_CHAR(d.budgetdate,'DD-MM-YYYY') from dist_budget d,district d1,userdetails u where d.distid=d1.distid and u.userid=d1.userid";
   
   public static final String _VIEW_ONE_DISTRICTBUDGET="select d.distbudgetid,d.amt,d.fyear,d.DISTRIBUTEDBY,d.DEPTNO,d.SUBDEPTNO,d.distid,TO_CHAR(d.budgetdate,'DD-MM-YYYY') from dist_budget d where d.distid=?";
   
   public static final String _VIEW_DISTRICTBUDGET_DO="select d.distbudgetid,d.amt,d.fyear,d.DISTRIBUTEDBY,d.DEPTNO,d.SUBDEPTNO,d.distid,TO_CHAR(d.budgetdate,'DD-MM-YYYY') from dist_budget d where d.distid=(select distid from district where distname=(select district from addresses where userid=(select userid from userdetails where loginid=?)))";
   
   public static final String _VIEW_SUBDEPARTMENTS="select subdeptname,amount,year from sub_department where deptnoref=(select deptno from department where deptname=?)";
   
   //Workers
   
   public static final String _REGISTER_WORKER="insert into userdetails values((select nvl(max(userid),1000)+1 from userdetails),?,?,?,sysdate,?,?,?,?,?,?,?,?,?,null,null,?)";
   
   public static final String _INSERT_WORKER_ADDR="insert into workeraddresses values((select max(userid) from userdetails),(select nvl(max(addressid),1000)+1 from workeraddresses),?,?,?,?,?,?)";
   
   public static final String _GET_WORKER_INFO="select u.userid,u.firstname,u.lastname,TO_CHAR(s.sdate,'DD-MM-YYYY'),p.payamount,w.houseno,w.street,w.city,w.state,w.pincode,s.asid,u.photograph from userdetails u, workshedule s,payment p,addresses w where u.userid=w.userid and u.userid=s.userid and u.userid=p.userid and u.logintype='worker'";
   
   public static final String _GET_WORKER_ADDRESS="select houseno,street,city,state,country,pincode from addresses where userid=?";
   
   public static final String _GET_MANAGER="select u.userid,u.firstname,u.lastname,u.emailid,u.faxno,u.phoneno,w.workname,u.photograph from userdetails u,work w,assignwork a where u.userid=a.userid and w.workid in(select a.workid from assignwork where u.userid=a.userid) and u.logintype='manager'";
   
   public static final String _GET_MANAGER_ADDRESS="select houseno,street,city,state,country,pincode from addresses where userid=?";
   
   public static final String _GET_WORK="select workname from work where workid in(select workid from assignwork where asid=?)";
   
   
   
   public static final String _CHECK_USER="select logintype from userdetails where loginid=? and password=?";
   
   public static final String _CHECK_CONTRACTOR="select CONTRCTORID from CONTROCTORLOGIN where loginname=? and password=?";
	
	
}
