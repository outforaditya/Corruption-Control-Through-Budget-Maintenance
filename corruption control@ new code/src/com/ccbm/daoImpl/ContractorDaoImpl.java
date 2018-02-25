package com.ccbm.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.LoginBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.daoI.ContractorDaoI;
import com.ccbm.db.ConnectionFactory;
import com.ccbm.db.SqlConstants;
import com.ccbm.exception.ConnectionException;
import com.ccbm.util.DateUtil;
import com.ccbm.util.DateWrapper;

public class ContractorDaoImpl implements ContractorDaoI {

	Connection con;
	PreparedStatement pstmt, pstmt1, pstm1, pstm2, pstm3;
	Statement stmt, stmt1, stmt2, stmt3;
	ResultSet rs, rs1, rs2, rs3;

	public ContractorDaoImpl() {

		con = ConnectionFactory.getConnection();

	}

	/**
	 * The insertContractor method of the ContractorDaoImpl Class.
	 * 
	 * This method is called when to accept contractor by district officer.
	 * 
	 * @param Passing
	 *            LoginBean as a one parameter. It contains contractor details. .
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean insertContractor(LoginBean lb) {
		boolean flag = false;
		int n = 0, m = 0;
		try {
			System.out.println("in dao impl");
			String workname = lb.getWorkname();
			System.out.println("in dao impl");
			String username = lb.getUsername();
			String password = lb.getPassword();
			String ta = lb.getTa();
			String deptname = lb.getDeptname();
			String dist = lb.getDistname();

			String name = lb.getName();

			pstmt = con.prepareStatement(SqlConstants._INSERT_CONTRACTOR);
			pstmt.setString(1, username);
			pstmt.setString(2, ta);

			pstmt.setString(3, dist);
			pstmt.setString(4, deptname);
			pstmt.setString(5, workname);

			rs = pstmt.executeQuery();
			System.out.println("....rs....." + rs);
			if (rs.next()) {

				flag = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}
		return flag;
	}

	/**
	 * The checkContractorshipStatus method of the ContractorDaoImpl Class. <br>
	 * 
	 * This method is called when contractor want to check is status of
	 * acceptance .
	 * 
	 * @param Passing
	 *            userName as a one parameter.
	 * 
	 * @return boolean value true or false depends upon operations.
	 */

	public boolean checkContractorshipStatus(String username) {
		boolean flag = false;
		try {
			con.setAutoCommit(true);
			pstmt = con.prepareStatement(SqlConstants._CHECK_CONTRACTOR_STATUS);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				String check = rs.getString(1);

				System.out.println("check" + check);
				if (check.equalsIgnoreCase("YES"))
					flag = true;
			}
			System.out.println("flag" + flag);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}
		return flag;
	}

	/**
	 * The updateContractorwork method of the ContractorDaoImpl Class. <br>
	 * 
	 * This method is called when contractor want to update work details .
	 * 
	 * @param Passing
	 *            TransactionBean as a one parameter.
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean updateContractorwork(TransactionBean tb)
			throws FileNotFoundException {

		int update = 0;
		boolean flag = true;
		try {
			Vector<TransactionBean> vdo = null;
			System.out.println("in registerDAO connection is ." + con);
			pstmt = con.prepareStatement(SqlConstants._INSERT_USERS);

			String username = tb.getUserid();
			String noofworkers = tb.getNoofworkers();
			int no = Integer.parseInt(noofworkers);
			String startdate = DateWrapper.parseDate(tb.getStartdate());
			String targetdate = DateWrapper.parseDate(tb.getTargetdate());
			String relesedamt = tb.getAmount();
			String spentamt = tb.getSpentamount();
			int amt = Integer.parseInt(relesedamt);
			int spent = Integer.parseInt(spentamt);
			String status = tb.getStatus();
			String photo = tb.getPhoto();
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());

			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select CONTRCTORID from contractor where userid=(select userid from userdetails WHERE LOGINID='"
							+ username + "')");
			if (rs.next()) {
				int contractorid = rs.getInt(1);
				vdo = new Vector<TransactionBean>();
				System.out.println("in Contractorworksdetails DAO in 1st rs");

				pstmt1 = con
						.prepareStatement(SqlConstants._UPDATE_CONTRACTORWORK);

				// String dob=DateWrapper.parseDate(rb.getDob());

				pstmt1.setInt(1, no);
				pstmt1.setString(2, startdate);
				pstmt1.setString(3, targetdate);
				pstmt1.setInt(4, spent);

				pstmt1.setBinaryStream(5, fis, (int) f.length());

				pstmt1.setString(6, status);
				pstmt1.setInt(7, contractorid);

				update = pstmt1.executeUpdate();

				if (update > 0) {

					flag = true;
					con.commit();
				}

				else {
					flag = false;
					con.rollback();
				}
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}

		return flag;

	}

	/**
	 * The contractorroleCheck method of the ContractorDaoImpl Class. <br>
	 * 
	 * This method is called when to check role of user .
	 * 
	 * @param Passing
	 *            LoginBean as a one parameter.Its contains Login details like
	 *            user name and password.
	 * 
	 * @return String with role depends upon operations.
	 */
	public String contractorroleCheck(LoginBean lb) {

		String role = "";

		try {
			con = ConnectionFactory.getConnection();

			System.out.println("in DAo impl is..con is....." + con);

			pstmt = con.prepareStatement(SqlConstants._CHECK_CONTRACTOR);

			String uname = lb.getUsername();
			System.out.println("in Security DAO class.....uname is" + uname);
			String pwd = lb.getPassword();
			System.out.println("in Security DAO class.....password is" + pwd);

			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// role=rs.getString(1);
				role = "contractor";
				System.out.println("in result set login type is........."
						+ role);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Exception raised" + e);
		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}
		return role;

	}

	/**
	 * The checkContractortransaction method of the ContractorDaoImpl Class.
	 * <br>
	 * 
	 * This method is called when contractor want to check is status of
	 * transaction .
	 * 
	 * @param Passing
	 *            loginId as a one parameter.
	 * @param Passing
	 *            transactionId as a one parameter.
	 * @return vector with transaction details depends upon operations.
	 */
	public Vector<TransactionBean> checkContractortransaction(String loginid, String transid) {

		Vector<TransactionBean> vdo = null;

		try {
			stmt = con.createStatement();
			System.out.println("stmt" + stmt);
			System.out.println("transid" + transid);
			rs = stmt.executeQuery("select userid,status from transaction where transaction_password='"+transid+ "'");
			System.out.println("stmt....rs" + rs);
			if (rs.next()) {
				System.out.println("stmt...in rs.next");
				int id = rs.getInt(1);
				String status = rs.getString(2);
				System.out.println("id and status"+id+".."+status);
				// if(status.equalsIgnoreCase("No"))

				// {

				pstmt = con.prepareStatement(SqlConstants._UPDATE_TRANSCTION);
				pstmt.setInt(1,id);
				pstmt.setString(2,transid);
				int m = pstmt.executeUpdate();
				System.out.println("Transaction updated......" + m);
				if (m > 0) {
					System.out.println("m>0...." + m);

					System.out.println("in Contractorviewworkdetails DAO");
					TransactionBean rb = new TransactionBean();
					stmt1 = con.createStatement();
					rs1 = stmt1
							.executeQuery("select district,department,workname from contractor where userid=(select userid from userdetails WHERE LOGINID='"
									+ loginid + "')");
					if (rs1.next()) {

						vdo = new Vector<TransactionBean>();
						System.out
								.println("in Contractorviewworkdetails DAO in 1st rs");
						String district = rs1.getString(1);

						String deptname = rs1.getString(2);
						String workname = rs1.getString(3);
						rb.setDeptname(rs1.getString(2));
						rb.setDistrict(rs1.getString(1));
						rb.setWorkname(rs1.getString(3));
						System.out
								.println("in Contractorviewworkdetails DAO in 1st rs"
										+ district
										+ "..."
										+ workname
										+ "   "
										+ deptname);

						stmt2 = con.createStatement();
						rs2 = stmt2
								.executeQuery("select amt,fyear,DISTRIBUTEDBY,to_char(NOTIFICATIONCLOSEDATE,'dd-mm-yyyy'),to_char(WORKCOMPLT_TARGETDATE,'dd-mm-yyyy') from DIST_BUDGET_DISTRIBUTION where workname='"
										+ workname
										+ "'and DEPTNOREF=(select deptno from department where deptname='"
										+ deptname
										+ "') and distidref=(select distid from district where distname='"
										+ district + "')");
						if (rs2.next()) {
							System.out
									.println("in Contractorviewworkdetails DAO at 2nd rs");
							rb.setAmount(Integer.toString(rs2.getInt(1)));
							rb.setYear(Integer.toString(rs2.getInt(2)));
							rb.setDistributedby(rs2.getString(3));

							rb.setLastdate(rs2.getString(4));
							rb.setTargetdate(rs2.getString(5));
							String lastdate = rs2.getString(4);
							String targetdate = rs2.getString(5);
							System.out
									.println("in Contractorviewworkdetails DAO at 2nd rs....."
											+ lastdate
											+ "........"
											+ targetdate);
							// rb.setTargetdate(DateUtil.parseDate(targetdate));

						}
						System.out.println(vdo);
						vdo.add(rb);
						System.out.println(vdo);
					}

				}
			}
		}

		catch (SQLException e) {
			// TODO: handle exception
		}

		finally {

//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}

		return vdo;

	}

	/**
	 * The viewContractorWorkDetails method of the ContractorDaoImpl Class.
	 * 
	 * This method is called when to view contractor work details.
	 * 
	 * @param passing
	 *            loginId as one parameter.
	 * @return vector with work details of contractor details depends upon
	 *         operations.
	 */
	public Vector<BudgetBean> viewContractorWorkDetails(String loginid) {
		Vector<BudgetBean> vdo = null;

		try {
			System.out.println("in Contractorviewworkdetails DAO  ========    "
					+ loginid);

			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select district,department,workname from contractor where userid=(select userid from userdetails WHERE LOGINID='"
							+ loginid + "')");
			if (rs.next()) {

				vdo = new Vector<BudgetBean>();
				System.out
						.println("in Contractorviewworkdetails DAO in 1st rs");
				String district = rs.getString(1);
				String deptname = rs.getString(2);
				String workname = rs.getString(3);
				System.out
						.println("in Contractorviewworkdetails DAO in 1st rs  "
								+ district + "..." + workname + " ......  "
								+ deptname);

				stmt1 = con.createStatement();
				rs1 = stmt1
						.executeQuery("select amt,fyear,DISTRIBUTEDBY,to_char(NOTIFICATIONCLOSEDATE,'dd-mm-yyyy'),to_char(WORKCOMPLT_TARGETDATE,'dd-mm-yyyy') from DIST_BUDGET_DISTRIBUTION where workname='"
								+ workname
								+ "'and DEPTNOREF=(select deptno from department where deptname='"
								+ deptname
								+ "') and distidref=(select distid from district where distname='"
								+ district + "')");
				while (rs1.next()) {

					BudgetBean rb = new BudgetBean();
					rb.setDeptname(deptname);
					rb.setDistrict(district);
					rb.setWorkname(workname);

					System.out
							.println("in Contractorviewworkdetails DAO at 2nd rs");
					rb.setAmount(Integer.toString(rs1.getInt(1)));
					rb.setYear(Integer.toString(rs1.getInt(2)));
					rb.setDistributedby(rs1.getString(3));

					rb.setLastdate(rs1.getString(4));
					rb.setTargetdate(rs1.getString(5));
					String lastdate = rs1.getString(4);
					String targetdate = rs1.getString(5);
					System.out
							.println("in Contractorviewworkdetails DAO at 2nd rs....."
									+ lastdate + "........" + targetdate);
					// rb.setTargetdate(DateUtil.parseDate(targetdate));
					vdo.add(rb);

				}
				System.out.println(vdo);

				System.out.println(vdo.size());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
//			try {
//				if (con != null)
//					//con.close();
//			} catch (SQLException e) {
//			}
		}

		return vdo;

	}

	/**
	 * The viewContractorApplication method of the ContractorDaoImpl Class.
	 * 
	 * This method is called when to view contractor Applications.
	 * 
	 * @param passing
	 *            loginId as one parameter.
	 * @return vector with contractor application details depends upon
	 *         operations.
	 */
	public Vector<TransactionBean> viewContractorApplication(String loginid) {
		Vector<TransactionBean> vdo = null;

		try {
			System.out
					.println("in Contractorviewworkdetails DAO...." + loginid);
			TransactionBean rb = new TransactionBean();
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select district,department,workname,INTRESTDIN,CONTRCTORID,DCOWILLING,userid from contractor where district=(select distname from district where userid=(select userid from userdetails WHERE LOGINID='"
							+ loginid + "')) and dcowilling='NO'");
			vdo = new Vector<TransactionBean>();
			while (rs.next()) {

				String dcowilling = rs.getString(6);
				if (dcowilling.equalsIgnoreCase("NO")) {
					int userid = rs.getInt(7);
					System.out.println("userid" + userid);
					stmt1 = con.createStatement();
					rs1 = stmt1
							.executeQuery("select firstname,lastname from USERDETAILS WHERE userid="
									+ userid);

					System.out
							.println("in Contractorviewworkdetails DAO in 1st rs1"
									+ rs1);
					String district = rs.getString(1);
					String deptname = rs.getString(2);
					String workname = rs.getString(3);
					String intrest = rs.getString(4);
					String contractorid = Integer.toString(rs.getInt(5));

					rb.setDeptname(rs.getString(2));
					rb.setDistrict(rs.getString(1));
					rb.setWorkname(rs.getString(3));
					rb.setIntrest(intrest);
					rb.setContractorid(contractorid);
					rb.setDcowilling(dcowilling);
					System.out
							.println("in Contractorviewworkdetails DAO in 1st rs"
									+ district
									+ "..."
									+ workname
									+ "   "
									+ deptname + "" + intrest);

					if (rs1.next()) {
						String name = rs1.getString(1) + "." + rs1.getString(2);
						System.out.println("....." + name);
						rb.setContractorname(name);
					}
				}
				vdo.add(rb);

			}

			System.out.println("Size......" + vdo.size());

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}

		return vdo;

	}

	/**
	 * The viewContractorWorkInfo method of the ContractorDaoImpl Class.
	 * 
	 * This method is called when contractor wants to view contractor work
	 * information .
	 * 
	 * @param passing
	 *            loginId as one parameter.
	 * @return vector with contractor work details depends upon operations.
	 */
	public Vector<TransactionBean> viewContractorWorkInfo(String loginid) {
		Vector<TransactionBean> vdo = null;

		try {
			System.out
					.println("in Contractorviewworkdetails DAO...." + loginid);
			TransactionBean rb = new TransactionBean();
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select district,department,workname,INTRESTDIN,CONTRCTORID,DCOWILLING,userid from contractor where district=(select distname from district where userid=(select userid from userdetails WHERE LOGINID='"
							+ loginid + "'))");
			vdo = new Vector<TransactionBean>();
			while (rs.next()) {

				String dcowilling = rs.getString(6);

				int userid = rs.getInt(7);
				System.out.println("userid" + userid);
				stmt1 = con.createStatement();
				rs1 = stmt1
						.executeQuery("select firstname,lastname from USERDETAILS WHERE userid="
								+ userid);

				System.out
						.println("in Contractorviewworkdetails DAO in 1st rs1"
								+ rs1);
				String district = rs.getString(1);
				String deptname = rs.getString(2);
				String workname = rs.getString(3);
				String intrest = rs.getString(4);
				String contractorid = Integer.toString(rs.getInt(5));

				rb.setDeptname(rs.getString(2));
				rb.setDistrict(rs.getString(1));
				rb.setWorkname(rs.getString(3));
				rb.setIntrest(intrest);
				rb.setContractorid(contractorid);
				rb.setDcowilling(dcowilling);
				System.out.println("in Contractorviewworkdetails DAO in 1st rs"
						+ district + "..." + workname + "   " + deptname + ""
						+ intrest);

				if (rs1.next()) {
					String name = rs1.getString(1) + "." + rs1.getString(2);
					System.out.println("....." + name);
					rb.setContractorname(name);
				}
			}
			vdo.add(rb);

			System.out.println("Size......" + vdo.size());

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}

		return vdo;

	}

	/**
	 * The viewContractorWorksDetails method of the ContractorDaoImpl Class.
	 * 
	 * This method is called when to view contractor work details.
	 * 
	 * @param passing
	 *            loginId as one parameter.
	 * @param passing
	 *            path as one parameter.
	 * @return vector with contractor work details depends upon operations.
	 */
	public Vector<TransactionBean> viewContractorWorksDetails(String loginid,
			String path1) {
		Vector<TransactionBean> vdo = null;

		try {
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select CONTRCTORID from contractor where userid=(select userid from userdetails WHERE LOGINID='"
							+ loginid + "')");
			while (rs.next()) {
				int contractorid = rs.getInt(1);
				vdo = new Vector<TransactionBean>();
				stmt1 = con.createStatement();
				rs1 = stmt1
						.executeQuery("select NO_OF_WORKER,to_char(STARTDATE,'dd-mm-yyyy'),to_char(ENDDATE,'dd-mm-yyyy'),AMT_RELEASED,AMT_SPENT,PHOTO,WORKSTATUS from WORKDETAILS where CONTRCTORID="
								+ contractorid);
				if (rs1.next()) {
					TransactionBean rb = new TransactionBean();
					String path = path1;
					System.out
							.println("in Contractorviewworkdetails DAO at 2nd rs..."
									+ path);
					rb.setNoofworkers(Integer.toString(rs1.getInt(1)));

					rb.setStartdate(rs1.getString(2));
					rb.setTargetdate(rs1.getString(3));
					rb.setAmount(Integer.toString(rs1.getInt(4)));
					rb.setSpentamount(rs1.getString(5));
					System.out.println("....." + rs1.getString(2));
					System.out.println("....." + rs1.getString(3));
					System.out.println("....." + rs1.getString(1));
					System.out.println("....." + rs1.getString(4));
					Blob b = rs1.getBlob(6);
					byte b1[] = b.getBytes(1, (int) b.length());
					System.out.println("....." + b1);
					path = path + "/" + contractorid + ".jpg";

					OutputStream fout = new FileOutputStream(path);
					fout.write(b1);
					rb.setPhoto(path);

					rb.setStatus(rs1.getString(7));
					System.out.println("path  :" + path + ".....-------"
							+ rs1.getString(2));
					// rb.setTargetdate(DateUtil.parseDate(targetdate));
					vdo.add(rb);

				}

				System.out.println(vdo.size());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}

		return vdo;

	}

	/**
	 * The acceptContractor method of the ContractorDaoImpl Class.
	 * 
	 * This method is called when district officer accepts contractor.
	 * 
	 * @param Passing
	 *            contractorId as a one parameter.
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean acceptContractor(String cid) throws ConnectionException{
		boolean flag = false;
		try {
			int conid = Integer.parseInt(cid);

			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select DCOWILLING from CONTRACTOR where CONTRCTORID="
							+ conid);
			if (rs.next()) {
				String will = rs.getString(1);
				if (will.equalsIgnoreCase("NO")) {
					stmt1 = con.createStatement();
					rs1 = stmt1
							.executeQuery("update contractor set DCOWILLING='YES' where CONTRCTORID="
									+ conid);
					if (rs1.next()) {
						flag = true;

					}

				} else
					flag = false;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ConnectionException("Server problem..");
		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//				throw new ConnectionException("Server problem....");
//			}
		}
		return flag;
	}

	/**
	 * The viewWorkDetails method of the ContractorDaoImpl Class. <br>
	 * 
	 * This method is called when want to all view work details.
	 * 
	 * @return vector with work details depends upon operations.
	 */
	public Vector<BudgetBean> viewWorkDetails() {
		Vector<BudgetBean> vdo = null;

		try {
			System.out.println("in viewworkdetails DAO");

			stmt = con.createStatement();// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			rs = stmt.executeQuery(SqlConstants._VIEW_WORKDETAILS);
			vdo = new Vector<BudgetBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {

				BudgetBean rb = new BudgetBean();
				System.out.println("result....... " + rs);
				String workname = (rs.getString(1));
				System.out.println("workname" + workname);
				String closedate = (rs.getString(2));
				String targetdate = (rs.getString(3));
				int deptno = (rs.getInt(4));
				int distno = (rs.getInt(5));

				stmt1 = con.createStatement();
				rs1 = stmt1
						.executeQuery("select distinct deptname from department where deptno="
								+ deptno);
				if (rs1.next()) {
					rb.setDeptname(rs1.getString(1));

					System.out.println("deptname" + rs1.getString(1));
				}

				stmt2 = con.createStatement();
				rs2 = stmt2
						.executeQuery("select distinct distname from district where distid="
								+ distno);
				if (rs2.next()) {
					rb.setDistrict(rs2.getString(1));
				}
				System.out.println("work.........." + workname);

				System.out.println("result =============" + rs);
				rb.setWorkname(workname);
				rb.setTargetdate(DateUtil.parseDate(targetdate));
				rb.setLastdate(DateUtil.parseDate(closedate));
				rb.setDepartno(deptno);
				rb.setDistno(distno);
				vdo.add(rb);
				System.out.println(vdo.size());

			}

		} catch (SQLException e) {

		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}

		return vdo;

	}

	/**
	 * The viewWorkDetails method of the ContractorDaoImpl Class.
	 * 
	 * This method is called when to view work details when state and district
	 * selected.
	 * 
	 * @param Passing
	 *            departmentName as a one parameter.
	 * @param Passing
	 *            districtName as a one parameter.
	 * @param Passing
	 *            path as a one parameter.
	 * @return vector with work details depends upon operations.
	 */
	public Vector<TransactionBean> viewWorkDetails(String deptname,String distname, String path1) {
		Vector<TransactionBean> vdo = null;

		int contractorid = 0, workid = 0, userid = 0;
		String name = "", workname = "";
		try {
			System.out.println("in viewworkdetails DAO" + distname);
			System.out.println("in viewworkdetails DAO" + deptname);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select CONTRCTORID,userid from CONTRACTOR where department='"+ deptname + "' and district='" + distname + "'");// +"and
			// district="+distname);
			System.out.println("in viewworkdetails DAO1" + rs);
			while (rs.next()) {

				System.out.println("in viewworkdetails DAO2");

				contractorid = rs.getInt(1);
				userid = rs.getInt(2);
				stmt1 = con.createStatement();
				rs2 = stmt1
						.executeQuery("select firstname,lastname from userdetails where userid="
								+ userid);// +"and district="+distname);
				if (rs2.next()) {
					name = rs2.getString(1) + "." + rs2.getString(2);
					System.out.println("....." + name + "..." + contractorid);

				}

				vdo = new Vector<TransactionBean>();
				System.out.println("in Contractorworksdetails DAO in 1st rs");

				stmt2 = con.createStatement();
				rs1 = stmt2
						.executeQuery("select NO_OF_WORKER,to_char(STARTDATE,'dd-mm-yyyy'),to_char(ENDDATE,'dd-mm-yyyy'),AMT_RELEASED,AMT_SPENT,PHOTO,WORKSTATUS ,workid from WORKDETAILS where CONTRCTORID="
								+ contractorid);
				if (rs1.next()) {
					TransactionBean rb = new TransactionBean();
					String path = path1;
					System.out
							.println("in Contractorviewworkdetails DAO at 2nd rs..."
									+ path);
					rb.setNoofworkers(Integer.toString(rs1.getInt(1)));

					rb.setStartdate(rs1.getString(2));
					rb.setTargetdate(rs1.getString(3));
					rb.setAmount(Integer.toString(rs1.getInt(4)));
					rb.setSpentamount(rs1.getString(5));
					System.out.println("....." + rs1.getString(2));
					System.out.println("....." + rs1.getString(3));
					System.out.println("....." + rs1.getString(1));
					System.out.println("....." + rs1.getString(4));
					Blob b = rs1.getBlob(6);
					byte b1[] = b.getBytes(1, (int) b.length());
					System.out.println("....." + b1);
					path = path + "/" + contractorid + ".jpg";

					OutputStream fout = new FileOutputStream(path);
					fout.write(b1);
					rb.setPhoto(path);
					rb.setUserid(name);
					rb.setStatus(rs1.getString(7));
					workid = rs1.getInt(8);

					System.out.println("....." + workid);
					System.out.println("....." + path);
					stmt3 = con.createStatement();
					rs3 = stmt3
							.executeQuery("select workname from DIST_BUDGET_DISTRIBUTION where workid="
									+ workid);
					System.out.println("....." + rs3);
					if (rs3.next()) {
						System.out.println("....." + rs3);
						workname = rs3.getString(1);
					}
					rb.setWorkname(workname);
					System.out.println("path  :" + path + ".....-------"
							+ rs1.getString(2));
					// rb.setTargetdate(DateUtil.parseDate(targetdate));
					vdo.add(rb);
break;
				}

				System.out.println(vdo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}

		return vdo;

	}

	/**
	 * The insertContractorworkDetails method of the ContractorDaoImpl Class.
	 * 
	 * This method is called when to insert Contractor Work details by
	 * Contractor.
	 * 
	 * @param Passing
	 *            TransactionBean as a one parameter. It contains contractor
	 *            work information.
	 * 
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean insertcontractorworkdetails(TransactionBean tb) {
		boolean flag = false;
		int n = 0;
		try {
			String deptname = tb.getDeptname();
			String workname = tb.getWorkname();

			int noofworkers = Integer.parseInt(tb.getNoofworkers());
			String startdate = DateUtil.parseDate(tb.getStartdate());
			String enddate = DateUtil.parseDate(tb.getLastdate());
			int releasedamount = Integer.parseInt(tb.getAmount());
			int spentamount = Integer.parseInt(tb.getSpentamount());
			String photo = tb.getPhoto();
			System.out.println("photo=" + photo);
			File f = new File(photo);
			FileInputStream fis = new FileInputStream(f);
			System.out.println("fole=" + f.length());
			String status = tb.getStatus();
			System.out.println("........." + deptname);
			int contractorid = 0;
			String username = tb.getUserid();
			System.out.println("user" + username);
			pstmt = con.prepareStatement(SqlConstants._SELECT_CONTRACTORID);
			pstmt.setString(1, username);

			rs = pstmt.executeQuery();
			System.out.println("....rs....." + rs);

			if (rs.next()) {
				System.out.println(".rs....." + rs);
				contractorid = rs.getInt(1);
				System.out.println("contractorid" + contractorid);
				pstm2 = con.prepareStatement(SqlConstants._SELECT_CONTRACTORID_WORKDETAILS);
				pstm2.setInt(1, contractorid);
				rs1 = pstm2.executeQuery();
				System.out.println("rs1" + rs1);
				if(rs1.next()){
				stmt = con.createStatement();
				rs2 = stmt
						.executeQuery("select nvl(max(CONTRCTORID),100)+1 from WORKDETAILS where CONTRCTORID="
								+ contractorid);

				if (rs2.next()) {
					flag = false;
				} }else

					pstm1 = con.prepareStatement(SqlConstants._INSERT_CONTRACTOR_WORKDETAILS);
				pstm1.setInt(1, contractorid);

				pstm1.setString(2, workname);
				pstm1.setInt(3, noofworkers);
				pstm1.setString(4, startdate);
				pstm1.setString(5, enddate);
				pstm1.setInt(6, releasedamount);
				pstm1.setInt(7, spentamount);

				pstm1.setBinaryStream(8, fis, (int) f.length());
				pstm1.setString(9, status);
				n = pstm1.executeUpdate();
				System.out.println("n =" + n);
				if (n > 0)
					flag = true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
//			try {
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//			}
		}
		return flag;
	}

}
