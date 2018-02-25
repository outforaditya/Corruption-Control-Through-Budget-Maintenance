package com.ccbm.daoImpl;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.ccbm.bean.BudgetBean;
import com.ccbm.bean.TransactionBean;
import com.ccbm.daoI.BudgetDaoI;
import com.ccbm.db.ConnectionFactory;
import com.ccbm.db.SqlConstants;
import com.ccbm.util.DateUtil;

public class BudgetDaoImpl implements BudgetDaoI {

	Connection con;
	PreparedStatement pstmt, pstmt1, pstm1, pstm2, pstm3;
	Statement stmt, stmt1, stmt2, stmt3;
	ResultSet rs, rs1, rs2, rs3;

	public BudgetDaoImpl() {

		con = ConnectionFactory.getConnection();

	}

	/**
	 * The deleteBudget method of the BudgetDaoImpl Class.
	 * 
	 * This method is called when to delete Budget details.
	 * 
	 * @param Passing
	 *            department name as a one parameter.
	 * 
	 * @param Passing
	 *            Sub department name as a one parameter.
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean deleteBudget(String dept, String subdept)
			throws FileNotFoundException {

		int i = 0, j = 0;

		boolean flag = false;
		try {
			System.out.println(dept + "-----" + subdept);
			con.setAutoCommit(false);

			stmt2 = con.createStatement();
			i = stmt2
					.executeUpdate("delete from sub_department where subdeptname='"
							+ subdept + "'");

			if (i > 0) {
				System.out.println(i);
				stmt1 = con.createStatement();
				j = stmt1
						.executeUpdate("delete from department where deptname='"
								+ dept + "'");
			} else {
				System.out.println(i);
				stmt1 = con.createStatement();
				j = stmt1
						.executeUpdate("delete from department where deptname='"
								+ dept + "')");
			}
			if (j > 0) {

				System.out.println(j);
				flag = true;
				con.commit();

			}

		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception se) {
			se.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return flag;

	}

	/**
	 * The updateBudget method of the BudgetDaoImpl Class. <br>
	 * 
	 * This method is called when to update budget details.
	 * 
	 * @param Passing
	 *            BudgetBean as a one parameter. This contains Budget details
	 *            like amount,year,department name, sub department name
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean updateBudget(BudgetBean tb) throws FileNotFoundException {

		int update = 0, i = 0;
		boolean flag = true;
		try {
			Vector<BudgetBean> vdo = null;
			System.out.println("in registerDAO connection is ." + con);

			String dept = tb.getDeptname();
			String subdept = tb.getSubdeptname();

			int amt = Integer.parseInt(tb.getAmount());
			int year = Integer.parseInt(tb.getYear());

			pstmt = con
					.prepareStatement("update sub_department set amount="
							+ amt
							+ ",year="
							+ year
							+ ",AVAILFUND="
							+ amt
							+ " where subdeptname='"
							+ subdept
							+ "' and deptnoref=(select deptno from department where deptname='"
							+ dept + "')");

			update = pstmt.executeUpdate();

			if (update > 0) {

				flag = true;
				con.commit();
			}

			else {
				flag = false;
				con.rollback();
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
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return flag;

	}

	/**
	 * The addStateBudget method of the BudgetDaoImpl Class. <br>
	 * 
	 * This method is called when to enter state level budget details.
	 * 
	 * @param Passing
	 *            BudgetBean as a one parameter.This is contains Department,sub
	 *            Department,Amount details.
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean addStateBudget(BudgetBean bb) {
		boolean flag = false;
		int n = 0, m = 0;
		try {
			String deptname = bb.getDeptname();
			String subdeptname = bb.getSubdeptname();
			int amount = Integer.parseInt(bb.getAmount());

			int year = Integer.parseInt(bb.getYear());
			int userid = 0;

			pstmt = con.prepareStatement(SqlConstants._SELECT_DEPT_OFFICER);
			pstmt.setString(1, deptname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userid = rs.getInt(1);
				System.out.println("userid" + userid);

				/*
				 * pstmt=con.prepareStatement(SqlConstants._SELECT_DEPARTMENT);
				 * rs1=pstmt.executeQuery(); if(rs1.next()) {
				 * 
				 * pstmt=con.prepareStatement(SqlConstants._SELECT_SUBDEPARTMENT);
				 * rs2=pstmt.executeQuery(); if(rs2.next()) { flag=false; } }
				 * 
				 * else{
				 * 
				 * stmt=con.createStatement(); rs1=stmt.executeQuery("select
				 * userid from department where userid="+userid);
				 * if(!rs1.next()) {
				 */
				pstm1 = con.prepareStatement(SqlConstants._UPDATE_DEPARTMENT);
				pstm1.setInt(1, userid);
				pstm1.setString(2, deptname);
				m = pstm1.executeUpdate();
				System.out.println(".....m" + m);

				if (m > 0) {
					pstm2 = con
							.prepareStatement(SqlConstants._UPDATE_SUBDEPARTMENT);
					pstm2.setInt(1, amount);
					pstm2.setInt(2, year);
					pstm2.setInt(3, amount);
					pstm2.setString(4, subdeptname);

					n = pstm2.executeUpdate();
					if (n > 0)
						flag = true;
				}
			}
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	/**
	 * The viewStateBudget method of the BudgetDaoImpl Class. <br>
	 * 
	 * This method is called when to view Budget details.
	 * 
	 * @return vector with state Budget Details depends upon operations.
	 */
	public Vector<BudgetBean> viewStateBudget() {
		Vector<BudgetBean> vdo = null;

		try {

			stmt = con.createStatement();// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			rs = stmt.executeQuery(SqlConstants._VIEW_STATEBUDGET);
			vdo = new Vector<BudgetBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				String deptname = (rs.getString(1));
				String budgetdate = (rs.getString(2));
				String subdeptname = (rs.getString(3));
				String amount = Integer.toString(rs.getInt(4));
				String year = Integer.toString(rs.getInt(5));
				System.out.println("dept.........." + deptname);

				BudgetBean rb = new BudgetBean();
				System.out.println("result =============" + rs);
				rb.setDeptname(deptname);
				rb.setSubdeptname(subdeptname);
				rb.setBudgetdate(budgetdate);
				rb.setAmount(amount);
				rb.setYear(year);
				vdo.add(rb);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return vdo;

	}

	/**
	 * The checkUsertransaction method of the BudgetDaoImpl Class.
	 * 
	 * This method is called when to check user transaction status and update
	 * transaction details.
	 * 
	 * @param Passing
	 *            login id as a one parameter.
	 * @param Passing
	 *            transaction id as a one parameter.
	 * 
	 * @return vector with transaction details depends upon operations.
	 */
	public Vector<TransactionBean> checkUsertransaction(String loginid,
			String transid) {
		Vector<TransactionBean> vdo = null;

		try {
			con.setAutoCommit(true);

			stmt = con.createStatement();
			System.out.println("stmt" + stmt);
			System.out.println("transid" + transid);
			rs = stmt
					.executeQuery("select userid,status from transaction where transaction_password='"
							+ transid + "'");
			
			if (rs.next()) {
				System.out.println("stmt...in rs.next");
				int id = rs.getInt(1);
				String status = rs.getString(2);
				// if(status.equalsIgnoreCase("No"))

				// {

				pstmt = con.prepareStatement(SqlConstants._UPDATE_TRANSCTION);
				pstmt.setInt(1, id);
				pstmt.setString(2, transid);
				int m = pstmt.executeUpdate();
				System.out.println("Transaction updated......" + m);
				if (m > 0) {
					System.out.println("m>0...." + m);
					stmt1 = con.createStatement();
					rs1 = stmt1
							.executeQuery("select d.deptname,d.budgetdate,s.subdeptname,s.amount,s.year,s.availfund from department d, sub_department s where d.deptno=(select d.deptno from department d where d.deptname=(select addresstype from addresses where userid="
									+ id
									+ "))and s.deptnoref=(select d.deptno from department d where d.deptname=(select addresstype from addresses where userid="
									+ id + "))");
					System.out.println("rs1..." + rs1);

					con.commit();

					vdo = new Vector<TransactionBean>();
					System.out.println("result -.-..-.-" + rs);
					while (rs1.next()) {
						System.out.println("result....... " + rs1);
						String deptname = (rs1.getString(1));
						System.out.println("loginid.........." + deptname);
						String budgetdate = rs1.getString(2);
						String subdeptname = (rs1.getString(3));
						String amount = rs1.getString(4);
						String year = rs1.getString(5);
						String availfund = rs1.getString(6);
						// System.out.println("dept.........."+dept);
						System.out.println("result " + rs);
						TransactionBean rb = new TransactionBean();
						System.out.println("result =============" + rs);

						rb.setDeptname(deptname);
						rb.setSubdeptname(subdeptname);
						rb.setBudgetdate(budgetdate);
						rb.setAmount(amount);
						rb.setYear(year);
						rb.setAvailfund(availfund);
						vdo.add(rb);

					}
					// }
					// }
				} else {
					vdo = null;
				}

			}
		}

		catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return vdo;

	}

	/**
	 * The viewDistrictBudget method of the BudgetDaoImpl Class. <br>
	 * 
	 * This method is called when to view district budget details.
	 * 
	 * @param passing
	 *            login id as one parameter.
	 * @param passing
	 *            transaction id as one parameter.
	 * @return vector with district budget details depends upon operations.
	 */
	public Vector<BudgetBean> viewDistBudget(String loginid, String transid) {
		Vector<BudgetBean> vdo = null;

		try {
			con.setAutoCommit(true);

			stmt = con.createStatement();
			System.out.println("stmt" + stmt);
			System.out.println("transid" + transid);
			rs = stmt
					.executeQuery("select userid,status from transaction where transaction_password='"
							+ transid + "'");
			System.out.println("stmt....rs" + rs);
			if (rs.next()) {
				System.out.println("stmt...in rs.next");
				int id = rs.getInt(1);
				String status = rs.getString(2);
				// if(status.equalsIgnoreCase("No"))

				// {
				System.out.println("stmt...in rs.next"+id);
				pstmt = con.prepareStatement(SqlConstants._UPDATE_TRANSCTION);
				pstmt.setInt(1, id);
				pstmt.setString(2, transid);
				int m = pstmt.executeUpdate();
				System.out.println("Transaction updated......" + m);
				if (m > 0) {
					System.out.println("m>0...." + m);

					// stmt=con.createStatement();//Statement(SqlConstants.
					// _VIEW_DEPT_OFFICERS);
					pstmt = con
							.prepareStatement(SqlConstants._VIEW_DISTBUDGETT);
					pstmt.setInt(1, id);
					pstmt.setInt(2, id);
					rs = pstmt.executeQuery();
					// rs=stmt.executeQuery(SqlConstants. _VIEW_DISTBUDGET);
					vdo = new Vector<BudgetBean>();
					System.out.println("result -.-..-.-" + rs);
					while (rs.next()) {
						System.out.println("result....... " + rs);
						int distbudegtid = rs.getInt(1);
						String amount = Integer.toString(rs.getInt(2));
						String year = Integer.toString(rs.getInt(3));
						String distributedby = rs.getString(4);
						int deptno = rs.getInt(5);
						int subdeptno = rs.getInt(6);
						int distid = rs.getInt(7);
						String budgetdate = rs.getString(8);
						String deptname = "";
						String subdeptname = "";
						String district = "";
						System.out.println("dept no"+deptno+"...sd"+subdeptno);
						if (deptno != 0) {
							stmt1 = con.createStatement();
							rs1 = stmt1
									.executeQuery("select deptname from department where deptno="
											+ deptno);
							if (rs1.next()) {
								deptname = rs1.getString(1);
							}
						}
						if (subdeptno != 0) {
							stmt2 = con.createStatement();
							rs2 = stmt2
									.executeQuery("select subdeptname from sub_department where subdeptno="
											+ subdeptno);
							if (rs2.next()) {
								subdeptname = rs2.getString(1);
								System.out.println(subdeptname);
							}
						}
						if (distid != 0) {
							stmt3 = con.createStatement();
							rs3 = stmt3
									.executeQuery("select distname from district where distid="
											+ distid);
							if (rs3.next()) {
								district = rs3.getString(1);
							}
						}

						System.out.println("dept.........." + deptname+"sub"+subdeptname);

						BudgetBean rb = new BudgetBean();
						System.out.println("result =============" + rs);
						rb.setDeptname(deptname);
						rb.setSubdeptname(subdeptname);
						rb.setBudgetdate(budgetdate);
						rb.setAmount(amount);
						rb.setYear(year);
						rb.setDistributedby(distributedby);
						rb.setDistrict(district);
						rb.setDistbudgetid(Integer.toString(distbudegtid));
						vdo.add(rb);
					}
				}
			}
			// }

		} catch (SQLException e) {

		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return vdo;

	}

	/**
	 * The viewDistBudgetofDept method of the BudgetDaoImpl Class.
	 * 
	 * This method is called when to view district budget details of particular
	 * department.
	 * 
	 * @param passing
	 *            districtBudgetId as one parameter.
	 * @return vector with district budget details of particular department
	 *         depends upon operations.
	 */
	public Vector<BudgetBean> viewDistBudgetofDept(String distbudgetidd) {
		Vector<BudgetBean> vdo = null;

		try {
			int distbudgetid = Integer.parseInt(distbudgetidd);
			con.setAutoCommit(true);
			pstmt = con.prepareStatement(SqlConstants._VIEW_DISTWORKBUDGETT);
			pstmt.setInt(1, distbudgetid);

			rs = pstmt.executeQuery();
			// rs=stmt.executeQuery(SqlConstants. _VIEW_DISTBUDGET);
			vdo = new Vector<BudgetBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				int distbudegtid = rs.getInt(1);
				String amount = Integer.toString(rs.getInt(2));
				String year = Integer.toString(rs.getInt(3));
				String distributedby = rs.getString(4);
				int deptno = rs.getInt(5);
				int subdeptno = rs.getInt(6);
				int distid = rs.getInt(7);

				String budgetdate = rs.getString(8);
				int balamt = rs.getInt(9);
				String deptname = "";
				String subdeptname = "";
				String district = "";
				if (deptno != 0) {
					stmt1 = con.createStatement();
					rs1 = stmt1
							.executeQuery("select deptname from department where deptno="
									+ deptno);
					if (rs1.next()) {
						deptname = rs1.getString(1);
					}
				}
				if (subdeptno != 0) {
					stmt2 = con.createStatement();
					rs2 = stmt2
							.executeQuery("select subdeptname from sub_department where subdeptno="
									+ subdeptno);
					if (rs2.next()) {
						subdeptname = rs2.getString(1);
					}
				}
				if (distid != 0) {
					stmt3 = con.createStatement();
					rs3 = stmt3
							.executeQuery("select distname from district where distid="
									+ distid);
					if (rs3.next()) {
						district = rs3.getString(1);
					}
				}
				BudgetBean rb = new BudgetBean();
				System.out.println("result =============" + rs);
				rb.setDeptname(deptname);
				rb.setSubdeptname(subdeptname);
				rb.setBudgetdate(budgetdate);
				rb.setAmount(amount);
				rb.setYear(year);
				rb.setDistributedby(distributedby);
				rb.setDistrict(district);
				rb.setDistbudgetid(Integer.toString(distbudegtid));
				rb.setDepartno(deptno);
				rb.setDistno(distid);
				rb.setSubdeptno(subdeptno);
				rb.setBalamt(balamt);
				vdo.add(rb);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return vdo;

	}

	/**
	 * The viewDistrictDistributedBudget method of the BudgetDaoImpl Class. <br>
	 * 
	 * This method is called when to view distributed district budget at work
	 * level.
	 * 
	 * @param passing
	 *            loginId as one parameter.
	 * @return vector with distributed district budget of work level details
	 *         depends upon operations.
	 */
	public Vector<BudgetBean> viewDistDistributedBudget(String loginid) {
		Vector<BudgetBean> vdo = null;

		try {

			con.setAutoCommit(true);
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("select distid from district where userid=(select userid from userdetails where loginid='"
							+ loginid + "')");
			if (rs.next()) {
				int distid = rs.getInt(1);
				stmt1 = con.createStatement();
				rs1 = stmt1
						.executeQuery("select workname,amt,fyear,DISTRIBUTEDBY,to_char(NOTIFICATIONCLOSEDATE,'dd-mm-yyyy'),to_char(WORKCOMPLT_TARGETDATE,'dd-mm-yyyy'),deptnoref from DIST_BUDGET_DISTRIBUTION where distidref="
								+ distid);

				vdo = new Vector<BudgetBean>();
				System.out.println("result -.-..-.-" + rs);
				while (rs1.next()) {
					System.out.println("result....... " + rs);
					String workname = rs1.getString(1);
					String amount = Integer.toString(rs1.getInt(2));
					String year = Integer.toString(rs1.getInt(3));
					String distributedby = rs1.getString(4);
					String lastdate = rs1.getString(5);
					String targetdate = rs1.getString(6);
					int deptno = rs1.getInt(7);
					String deptname = "";
					System.out.println("deptno" + deptno);
					String district = "";
					if (deptno != 0) {
						stmt2 = con.createStatement();
						rs2 = stmt2
								.executeQuery("select deptname from department where deptno="
										+ deptno);
						if (rs2.next()) {
							deptname = rs2.getString(1);
						}
					}

					if (distid != 0) {
						stmt3 = con.createStatement();
						rs3 = stmt3
								.executeQuery("select distname from district where distid="
										+ distid);
						if (rs3.next()) {
							district = rs3.getString(1);
						}
					}

					System.out.println("dept.........." + deptname);

					BudgetBean rb = new BudgetBean();
					System.out.println("result =============" + rs);
					rb.setWorkname(workname);
					rb.setDeptname(deptname);

					rb.setLastdate(lastdate);
					rb.setTargetdate(targetdate);
					rb.setAmount(amount);
					rb.setYear(year);
					rb.setDistributedby(distributedby);
					rb.setDistrict(district);

					vdo.add(rb);
				}

			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return vdo;

	}

	/**
	 * The viewDistBudget method of the BudgetDaoImpl Class. <br>
	 * 
	 * This method is called when to view district budget details of selected
	 * district.
	 * 
	 * @param passing
	 *            distName as one parameter.
	 * @return vector with district budget details depends upon operations.
	 */
	public Vector<BudgetBean> viewDistBudget(String distname) {
		Vector<BudgetBean> vdo = null;
		int district1 = 0;

		try {

			stmt3 = con.createStatement();
			rs3 = stmt3
					.executeQuery("select distid from district where distname='"
							+ distname + "'");
			if (rs3.next()) {
				district1 = rs3.getInt(1);
			}

			pstmt = con.prepareStatement(SqlConstants._VIEW_ONE_DISTRICTBUDGET);
			pstmt.setInt(1, district1);
			rs = pstmt.executeQuery();

			vdo = new Vector<BudgetBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				int distbudegtid = rs.getInt(1);
				String amount = Integer.toString(rs.getInt(2));
				String year = Integer.toString(rs.getInt(3));
				String distributedby = rs.getString(4);
				int deptno = rs.getInt(5);
				int subdeptno = rs.getInt(6);
				int distid = rs.getInt(7);
				String budgetdate = rs.getString(8);
				String deptname = "";
				String subdeptname = "";
				String district = "";
				if (deptno != 0) {
					stmt1 = con.createStatement();
					rs1 = stmt1
							.executeQuery("select deptname from department where deptno="
									+ deptno);
					if (rs1.next()) {
						deptname = rs1.getString(1);
					}
				}
				if (subdeptno != 0) {
					stmt2 = con.createStatement();
					rs2 = stmt2
							.executeQuery("select subdeptname from sub_department where subdeptno="
									+ subdeptno);
					if (rs2.next()) {
						subdeptname = rs2.getString(1);
					}
				}

				System.out.println("dept.........." + deptname);

				BudgetBean rb = new BudgetBean();
				System.out.println("result =============" + rs);
				rb.setDeptname(deptname);
				rb.setSubdeptname(subdeptname);
				rb.setBudgetdate(budgetdate);
				rb.setAmount(amount);
				rb.setYear(year);
				rb.setDistributedby(distributedby);
				rb.setDistrict(distname);
				vdo.add(rb);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return vdo;

	}

	/**
	 * The viewDistBudgetByDco method of the BudgetDaoImpl Class. <br>
	 *
	 * This method is called when to view district budget details of concern district budget officer.
	 * @param passing user as one parameter.
	 * @return vector with  district budget details  depends upon operations.
	 */
	public Vector<BudgetBean> viewDistBudgetByDco(String user) {
		Vector<BudgetBean> vdo = null;
		int district1 = 0;

		try {

			pstmt = con.prepareStatement(SqlConstants._VIEW_DISTRICTBUDGET_DO);
			pstmt.setString(1, user);
			rs = pstmt.executeQuery();

			vdo = new Vector<BudgetBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				int distbudegtid = rs.getInt(1);
				String amount = Integer.toString(rs.getInt(2));
				String year = Integer.toString(rs.getInt(3));
				String distributedby = rs.getString(4);
				int deptno = rs.getInt(5);
				int subdeptno = rs.getInt(6);
				System.out.println("subdept no"+subdeptno);
				int distid = rs.getInt(7);
				String budgetdate = rs.getString(8);
				String deptname = "";
				String subdeptname = "";
				String district = "";
				if (deptno != 0) {
					stmt1 = con.createStatement();
					rs1 = stmt1
							.executeQuery("select deptname from department where deptno="
									+ deptno);
					if (rs1.next()) {
						deptname = rs1.getString(1);
					}
				}
				if (subdeptno != 0) {
					stmt2 = con.createStatement();
					rs2 = stmt2
							.executeQuery("select subdeptname from sub_department where subdeptno="
									+ subdeptno);
					if (rs2.next()) {
						subdeptname = rs2.getString(1);

						stmt3 = con.createStatement();
						rs3 = stmt3
								.executeQuery("select distname from district where distid="
										+ distid);
						if (rs3.next()) {
							district = rs3.getString(1);
						}
					}
				}

				System.out.println("dept.........." + deptname+"sub"+subdeptname+"dist"+district);

				BudgetBean rb = new BudgetBean();
				System.out.println("result =============" + rs);
				rb.setDeptname(deptname);
				rb.setSubdeptname(subdeptname);
				rb.setBudgetdate(budgetdate);
				rb.setAmount(amount);
				rb.setYear(year);
				rb.setDistributedby(distributedby);
				rb.setDistrict(district);
				vdo.add(rb);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return vdo;

	}

	/**
	 * The viewDistBudget method of the BudgetDaoImpl Class.
	 *
	 * This method is called when to view all districts budget details.
	 * @return vector with  district budget details  depends upon operations.
	 */
	public Vector<BudgetBean> viewDistBudget() {
		Vector<BudgetBean> vdo = null;

		try {

			stmt = con.createStatement();// Statement(SqlConstants.
			// _VIEW_DEPT_OFFICERS);

			rs = stmt.executeQuery(SqlConstants._VIEW_DISTBUDGET);
			vdo = new Vector<BudgetBean>();
			System.out.println("result -.-..-.-" + rs);
			while (rs.next()) {
				System.out.println("result....... " + rs);
				int distbudegtid = rs.getInt(1);
				String amount = Integer.toString(rs.getInt(2));
				String year = Integer.toString(rs.getInt(3));
				String distributedby = rs.getString(4);
				int deptno = rs.getInt(5);
				int subdeptno = rs.getInt(6);
				int distid = rs.getInt(7);
				String budgetdate = rs.getString(8);
				String deptname = "";
				String subdeptname = "";
				String district = "";
				if (deptno != 0) {
					stmt1 = con.createStatement();
					rs1 = stmt1
							.executeQuery("select deptname from department where deptno="
									+ deptno);
					if (rs1.next()) {
						deptname = rs1.getString(1);
					}
				}
				if (subdeptno != 0) {
					stmt2 = con.createStatement();
					rs2 = stmt2
							.executeQuery("select subdeptname from sub_department where subdeptno="
									+ subdeptno);
					if (rs2.next()) {
						subdeptname = rs2.getString(1);
					}
				}
				if (distid != 0) {
					stmt3 = con.createStatement();
					rs3 = stmt3
							.executeQuery("select distname from district where distid="
									+ distid);
					if (rs3.next()) {
						district = rs3.getString(1);
					}
				}

				System.out.println("dept.........." + deptname);

				BudgetBean rb = new BudgetBean();
				System.out.println("result =============" + rs);
				rb.setDeptname(deptname);
				rb.setSubdeptname(subdeptname);
				rb.setBudgetdate(budgetdate);
				rb.setAmount(amount);
				rb.setYear(year);
				rb.setDistributedby(distributedby);
				rb.setDistrict(district);
				vdo.add(rb);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		return vdo;

	}

	/**
	 * The insertDistrictBudget method of the BudgetDaoImpl Class. 
	 * 
	 * This method is called when to insert district Budget details.
	 * 
	 * @param Passing
	 *            TransactionBean as a one parameter. It contains Budget
	 *            amount,year,department.
	 * 
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean insertdistrictbudget(TransactionBean tb) {
		boolean flag = false;
		int n = 0, m = 0, l = 0;
		try {
			String deptname = tb.getDeptname();
			String subdeptname = tb.getSubdeptname();
			int amount = Integer.parseInt(tb.getAmount());
			int availfund = Integer.parseInt(tb.getAvailfund());
			int availbal = availfund - amount;
			int year = Integer.parseInt(tb.getYear());
			String dist = tb.getDistrict();
			System.out.println(dist + "........." + deptname + ".....===dist"
					+ dist);
			int userid = 0;

			pstmt = con.prepareStatement(SqlConstants._SELECT_DIST_OFFICER);
			pstmt.setString(1, deptname);
			pstmt.setString(2, dist);
			rs = pstmt.executeQuery();
			System.out.println("....rs....." + rs);
			if (rs.next()) {
				System.out.println("..rs....." + rs);
				userid = rs.getInt(1);
				System.out.println("userid" + userid);

				pstm1 = con.prepareStatement(SqlConstants._INSERT_DISTRICT);
				pstm1.setString(1, dist);
				pstm1.setInt(2, userid);
				m = pstm1.executeUpdate();
				System.out.println(".....m" + m);

				if (m > 0) {

					pstm2 = con
							.prepareStatement(SqlConstants._INSERT_DIST_BUDGET);
					pstm2.setInt(1, amount);
					pstm2.setInt(2, year);
					pstm2.setInt(3, userid);
					pstm2.setString(4, deptname);
					pstm2.setString(5, subdeptname);
					pstm2.setString(6, dist);
					// pstm2.setInt(7,availfund);
					n = pstm2.executeUpdate();

					if (n > 0) {

						stmt = con.createStatement();
						l = stmt
								.executeUpdate("update sub_department set availfund="
										+ availbal
										+ " where subdeptname='"
										+ subdeptname + "'");

						if (l > 0)
							flag = true;
						con.commit();
					}
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	/**
	 * The insertDistrictBudget method of the BudgetDaoImpl Class. 
	 * 
	 * This method is called when to insert district Budget details.
	 * 
	 * @param Passing
	 *            TransactionBean as a one parameter. It contains Budget
	 *            amount,year,department.
	 * 
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean insertdistbudget(TransactionBean tb) {
		boolean flag = false;
		int n = 0, m = 0, l = 0;
		try {
			String deptname = tb.getDeptname();
			String subdeptname = tb.getSubdeptname();
			int amount = Integer.parseInt(tb.getAmount());
			int availfund = Integer.parseInt(tb.getAvailfund());
			int availbal = availfund - amount;
			int year = Integer.parseInt(tb.getYear());
			String dist = tb.getDistrict();
			System.out.println(dist + "........." + deptname + ".....===dist"
					+ dist);
			int userid = 0;

			pstmt = con.prepareStatement(SqlConstants._SELECT_DIST_OFFICER);
			pstmt.setString(1, deptname);
			pstmt.setString(2, dist);
			rs = pstmt.executeQuery();
			System.out.println("....rs....." + rs + "bal amt" + availbal);
			if (rs.next()) {
				System.out.println("..rs....." + rs);
				userid = rs.getInt(1);
				System.out.println("userid" + userid);

				pstm2 = con.prepareStatement(SqlConstants._INSERT_DIST_BUDGET);
				pstm2.setInt(1, amount);
				pstm2.setInt(2, year);
				pstm2.setInt(3, userid);
				pstm2.setString(4, deptname);
				pstm2.setString(5, subdeptname);
				pstm2.setString(6, dist);
				pstm2.setInt(7, amount);
				n = pstm2.executeUpdate();

				if (n > 0) {

					stmt = con.createStatement();
					l = stmt
							.executeUpdate("update sub_department set availfund="
									+ availbal
									+ " where subdeptname='"
									+ subdeptname + "'");

					if (l > 0)
						flag = true;
					con.commit();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	/**
	 * The insertWorkBudget method of the BudgetDaoImpl Class. 
	 * 
	 * This method is called when to insert work details.
	 * 
	 * @param Passing
	 *            BudgetBean as a one parameter. It contains Work name
	 *            amount,Work start date,Target date.
	 * 
	 * 
	 * @return boolean value true or false depends upon operations.
	 */
	public boolean insertworkbudget(BudgetBean tb) {
		boolean flag = false;
		int n = 0, m = 0, p = 0;
		try {
			System.out.println("in dao impl");
			String workname = tb.getWorkname();
			String lastdate = tb.getLastdate();
			String targetdate = tb.getTargetdate();
			String name = tb.getDistributedby();
			System.out.println("in dao impl");
			String distbudgetidd = tb.getDistbudgetid();
			System.out.println("in dao impl" + distbudgetidd);
			int distbudgetid = Integer.parseInt(distbudgetidd);
			System.out.println("in dao impl" + distbudgetid);
			int amount = Integer.parseInt(tb.getAmount());
			int year = Integer.parseInt(tb.getYear());
			// String dist=tb.getDistrict();

			System.out.println("in dao impl");

			pstmt = con.prepareStatement(SqlConstants._INSERT_WORK_BUDEGET);
			pstmt.setString(1, workname);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, year);
			pstmt.setString(4, name);

			pstmt.setString(5, DateUtil.parseDate(lastdate));
			pstmt.setString(6, DateUtil.parseDate(targetdate));
			pstmt.setInt(7, distbudgetid);
			pstmt.setInt(8, distbudgetid);
			pstmt.setInt(9, distbudgetid);

			rs = pstmt.executeQuery();
			System.out.println("....rs....." + rs);
			if (rs.next()) {
				System.out.println("....rs....." + rs);

				pstm1 = con
						.prepareStatement(SqlConstants._INSERT_DISTFUNDSTATUS);
				pstm1.setInt(1, distbudgetid);

				m = pstm1.executeUpdate();
				System.out.println(".....m" + m);

				if (m > 0) {

					stmt = con.createStatement();
					p = stmt
							.executeUpdate("update dist_budget set balamt=(select balamt-"
									+ amount
									+ " from dist_budget where distbudgetid="
									+ distbudgetid
									+ ") where distbudgetid="
									+ distbudgetid);

					if (p > 0)
						flag = true;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

}
